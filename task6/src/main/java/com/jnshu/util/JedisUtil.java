package com.jnshu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    // redis 连接池
    private static JedisPool pool = null;

//    private String password = "zhang62853";

    private JedisPool getPool() {

        if (pool == null) {

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

            //连接超时时是否阻塞，false时报异常,ture阻塞直到超时, 默认true
            jedisPoolConfig.setBlockWhenExhausted(true);

            //逐出策略（默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)）
            jedisPoolConfig.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");

            //最大空闲连接数, 默认8个
            jedisPoolConfig.setMaxIdle(100);

            //最大连接数, 默认8个
            jedisPoolConfig.setMaxTotal(210);

            //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted)
            // 如果超时就抛异常, 小于零:阻塞不确定的时间, 默认-1
            jedisPoolConfig.setMaxWaitMillis(-1);

            //逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
            jedisPoolConfig.setMinEvictableIdleTimeMillis(500);

            //最小空闲连接数, 默认0
            jedisPoolConfig.setMinIdle(0);

            //每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
            jedisPoolConfig.setNumTestsPerEvictionRun(100);

            //对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出
            // 不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
            jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1000);

            // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted)
            // 如果超时就抛异常, 小于零:阻塞不确定的时间, 默认-1
//            jedisPoolConfig.setMaxWaitMillis(3000);

            //对拿到的connection进行validateObject有效性校验, 默认false
            jedisPoolConfig.setTestOnBorrow(false);

            //在进行returnObject对返回的connection进行validateObject校验
            jedisPoolConfig.setTestOnReturn(true);

            //定时对线程池中空闲的链接进行validateObject有效性校验, 默认false
            jedisPoolConfig.setTestWhileIdle(true);
            pool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
//            pool = new JedisPool(jedisPoolConfig, "47.94.93.251", 6379);
            return pool;
        } else {
            return pool;
        }
    }

    public void set(String key, String value) {
        if (pool == null) {
            pool = getPool();
        }
        Jedis jedis = pool.getResource();
//        jedis.auth(password);
        jedis.set(key, value);
        jedis.close();
    }

    public String get(String key) {
        if (pool == null) {
            pool = getPool();
        }
        Jedis jedis = pool.getResource();
//        jedis.auth(password);
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    public boolean exists(String key) {
        if (pool == null) {
            pool = getPool();
        }
        Jedis jedis = pool.getResource();
//        jedis.auth(password);
        Boolean isExists = jedis.exists(key);
        jedis.close();
        return isExists;

    }
}
