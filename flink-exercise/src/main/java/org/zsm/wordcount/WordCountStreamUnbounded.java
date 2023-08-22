package org.zsm.wordcount;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @Author: zengsm.
 * @Date:Created in 2023/8/6.
 * @Description:
 */
public class WordCountStreamUnbounded {

  public static void main(String[] args) throws Exception {
    // 1.创建执行环境
//    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());
    // 2.读取数据：socket
    DataStreamSource<String> socketTS = env.socketTextStream("hadoop10", 8081);
    // 3.处理数据：切换、转 换、分组、聚合
    SingleOutputStreamOperator<Tuple2<String, Integer>> sum = socketTS.flatMap(
        new FlatMapFunction<String, Tuple2<String, Integer>>() {
          @Override
          public void flatMap(String s, Collector<Tuple2<String, Integer>> collector)
              throws Exception {
            String[] words = s.split(" ");
            for (String word : words) {
              collector.collect(Tuple2.of(word, 1));
            }
          }
        }).returns(Types.TUPLE(Types.STRING,Types.INT)).keyBy(new KeySelector<Tuple2<String, Integer>, String>() {
      @Override
      public String getKey(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
        return stringIntegerTuple2.f0;
      }
    }).sum(1);
    // 4.输出
    sum.print();
    // 5.执行
    env.execute();
  }
}
