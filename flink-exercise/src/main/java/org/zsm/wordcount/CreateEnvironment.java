package org.zsm.wordcount;

import org.apache.flink.api.common.functions.RichFilterFunction;
import org.apache.flink.api.common.io.FileInputFormat;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 * @Author: zengsm.
 * @Date:Created in 2023/8/28.
 * @Description: org.zsm.wordcount
 */
public class CreateEnvironment
{
    public static void main(String[] args)
    {
        //region 创建执行环境
        //创建一个执行环境，表示当前执行程序的上下文
        //ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //创建本地执行环境，需要在调用时指定默认的并行度
        //LocalStreamEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(1);
        //创建本地执行环境和WebUI，需要指定配置
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(
            new Configuration());

        //集群执行环境，将 Jar 提交到远程服务器。需要在调用时指定 JobManager的 IP 和端口号，并指定要在集群中运行的 Jar 包。
        //StreamExecutionEnvironment env =StreamExecutionEnvironment
        //    .createRemoteEnvironment("jobmanage-hostname", 6123, "YOURPATH//WordCount.jar");
        //endregion

        //region
        //开始读取文件
        //DataStreamSource<String> dataStream1 = env.readTextFile("data/flink.txt", "UTF-8");

        //readFile()
        //DataStreamSource<String> dataStream2 = env.readFile(new FileInputFormat<String>()
        //{
        //    @Override
        //    public boolean reachedEnd()
        //        throws IOException
        //    {
        //        return false;
        //    }
        //
        //    @Override
        //    public String nextRecord(String s)
        //        throws IOException
        //    {
        //        return null;
        //    }
        //}, "data/flink.txt");

        //创建一个Collection
        List<String> list = Arrays.asList("aa bb", "bb cc", "cc dd", "dd ee", "ee ff", " ff aa");
        DataStreamSource<String> dataStream = env.fromCollection(list);

        //基于Element
        DataStreamSource<String> dataStream2 = env.fromElements("aa bb", "bb cc", "cc dd", "dd ee", "ee ff", " ff aa");

        //generateSequence(from, to)
        DataStreamSource<Long> dataStream3 = env.generateSequence(1, 100);



        //endregion

    }
}
