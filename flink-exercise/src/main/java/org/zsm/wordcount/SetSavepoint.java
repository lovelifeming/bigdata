package org.zsm.wordcount;

import org.apache.flink.runtime.checkpoint.Checkpoint;
import org.apache.flink.runtime.state.StateBackend;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.io.*;


/**
 * @Author: zengsm.
 * @Date:Created in 2023/8/23.
 * @Description: org.zsm.wordcount
 */
public class SetSavepoint
{
    public static void main(String[] args)
        throws Exception
    {
        // 默认checkpoint功能是disabled的，想要使用的时候须要先启用
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 每隔1000 ms进行启动一个检查点【设置checkpoint的周期】
        env.enableCheckpointing(10000);
        // 高级选项：
        // 设置模式为exactly-once （这是默认值）
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        // 确保检查点之间有至少500 ms的间隔【checkpoint最小间隔】
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(500);
        // 检查点必须在一分钟内完成，或者被丢弃【checkpoint的超时时间】
        env.getCheckpointConfig().setCheckpointTimeout(60000);
        // 同一时间只容许进行一个检查点
        env.getCheckpointConfig().setMaxConcurrentCheckpoints(1);
        // 表示一旦Flink处理程序被cancel后，会保留Checkpoint数据，以便根据实际须要恢复到指定的
        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);
        // ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION:表示一旦Flink处理程序被
        //cancel后，会保留Checkpoint数据，以便根据实际须要恢复到指定的Checkpoint
        // ExternalizedCheckpointCleanup.DELETE_ON_CANCELLATION: 表示一旦Flink处理程序被
        // cancel后，会删除Checkpoint数据，只有job执行失败的时候才会保存checkpoint
        // 设置 checkpoint 保存目录
        env.setStateBackend((StateBackend)new OutputStreamWriter(new FileOutputStream("hdfs:///flink/checkpoints-data/")));

        env.execute();
    }

}
