package org.zsm.wordcount;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @Author: zengsm.
 * @Date:Created in 2023/8/6.
 * @Description: DataStream 实现WordCount：读文件（有界流）
 */
public class WordCountStream {

  public static void main(String[] args) throws Exception {
    // 1.创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    // 2.读取数据，从文件读
    DataStreamSource<String> lineDS = env.readTextFile("src/main/resources/word.txt");
    // 3.处理数据：切分、转换、分组、聚合
    // 3.1切分、转换
    SingleOutputStreamOperator<Tuple2<String, Integer>> wordAndOne = lineDS.flatMap(
        new FlatMapFunction<String, Tuple2<String, Integer>>() {
          @Override
          public void flatMap(String s, Collector<Tuple2<String, Integer>> collector)
              throws Exception {
            String[] words = s.split(" ");
            for (String word : words) {
              Tuple2<String, Integer> wordTuple2 = Tuple2.of(word, 1);
              collector.collect(wordTuple2);  // 通过采集器向下游发送数据
            }
          }
        });
    // 3.2分组
    KeyedStream<Tuple2<String, Integer>, String> wordAndOneKeys = wordAndOne.keyBy(
        new KeySelector<Tuple2<String, Integer>, String>() {
          @Override
          public String getKey(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
            return stringIntegerTuple2.f0;
          }
        });
    // 3.3聚合
    SingleOutputStreamOperator<Tuple2<String, Integer>> sum = wordAndOneKeys.sum(1);
    // 4.输出数据
    sum.print();
    // 5.执行：类似 sparkstream最后的ssc.start()
    env.execute();
  }
}
