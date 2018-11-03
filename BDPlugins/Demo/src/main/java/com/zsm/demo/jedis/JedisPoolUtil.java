package com.zsm.demo.jedis;

/**
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/9/12.
 * @Modified By:
 */
public class JedisPoolUtil
{
   /* private static final Logger LOGGER= LoggerFactory.getLogger(JedisPoolUtil.class);
    private static JedisPoolUtil pool=null;
    static {
        InputStream in=JedisPoolUtil.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties properties=new Properties();
        try
        {
            properties.load(in);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数
        poolConfig.setMaxTotal(Integer.parseInt( pro.get("redis.maxTotal").toString()));
        //最大空闲连接数
        poolConfig.setMaxIdle(Integer.parseInt( pro.get("redis.maxIdle").toString()));
        //最小空闲连接数
        poolConfig.setMinIdle(Integer.parseInt( pro.get("redis.minIdle").toString()));
        pool = new JedisPool(poolConfig, pro.get("redis.url").toString(),Integer.parseInt( pro.get("redis.port")
            .toString()));
    }
    public static RedisProperties.Jedis getJedis(){
        return pool.getResource();
    }
    public static void release(RedisProperties.Jedis jedis){
        if(null != jedis){
            jedis.close();
        }
    }*/
}
