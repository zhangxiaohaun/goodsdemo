package com.cskt.zxh.goodsdemo.utils;

import redis.clients.jedis.Jedis;

/**
 * @program: SpringBoot-01-mybatis
 * @description: 一句话描述本类
 * @author: chenqi
 * @create: 2021-11-19 14:14
 **/
public class RedisUtil {
    /**
     * 设置key的有效期，单位是秒
     * @param key
     * @param exTime
     * @return
     */
    public static Long expire(String key,int exTime){
        Jedis jedis = null;
        Long result = null;
        try {
            //从Redis连接池中获得Jedis对象
            jedis = RedisPool.getJedis();
            //设置成功则返回Jedis对象
            result = jedis.expire(key,exTime);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }finally {
            RedisPool.returnResource(jedis);
        }
        return result;
    }
    
    //exTime的单位是秒
    //设置key-value并且设置超时时间
    public static String setEx(String key,String value,int exTime){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setex(key,exTime,value);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }finally {
            RedisPool.returnResource(jedis);
        }
        return result;
    }
    
    public static String set(String key,String value){
        Jedis jedis = null;
        String result = null;
        
        try {
            jedis = RedisPool.getJedis();
            result = jedis.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }finally {
            RedisPool.returnResource(jedis);
        }
        return result;
    }
    
    public static String get(String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }finally {
            RedisPool.returnResource(jedis);
        }
        return result;
    }
    
    public static Long del(String key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }finally {
            RedisPool.returnResource(jedis);
        }
        return result;
    }
    //省略其他方法

}
