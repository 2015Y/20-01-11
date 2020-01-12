package com.bootdo.redis;

import com.bootdo.utils.GetRedisConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisConnect {

    @Test
    public void testRedis() {
        try {
            //和Redis服务器创建连接，参数为Redis服务器所在电脑Ip和Redis的端口号
            Jedis jedis = new Jedis(GetRedisConfig.getRedisIp(), GetRedisConfig.getRedisPort());
            jedis.auth(GetRedisConfig.getRedisPassword());
            //设值，Redis中的集合命令对应Jedis的方法名称
            jedis.set("linKey001", "linValue001");
            String result = jedis.get("linKey001");
            System.out.println(result);
            //用完关闭连接
            jedis.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(e.getCause());
        }

    }

    @Test
    public void testRedisPool() {
        try {
            //创建连接池，连接池为单例的，参数为Redis服务器所在linux系统ip和端口号
            JedisPool jedisPool = new JedisPool(GetRedisConfig.getRedisIp(),GetRedisConfig.getRedisPort());

            // 从连接池中获取一个连接
            Jedis jedis = jedisPool.getResource();
            jedis.auth(GetRedisConfig.getRedisPassword());
            System.out.println(jedis.get("linKey001"));
            // 关闭连接，被连接池回收
            jedis.close();
            // 关闭连接池
            jedisPool.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(e.getCause());
        }
    }
}