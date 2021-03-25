package com.luobo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

/**
 * RedisHelper class
 * redis访问帮助类
 *
 * @author chenlingyu
 * @date 2020/6/6 14:40
 */
@Component
public class RedisHelper {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 获取JedisPool连接池实例
     *
     * @return JedisPool连接池实例（通过Spring生成）
     */
    public JedisPool getJedisPool() {
        return jedisPool;
    }

    /**
     * 获取Jedis实例
     *
     * @return Jedis实例
     */
    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * Redis设置键值对
     *
     * @param key   键
     * @param value 值
     * @return 值
     */
    public String set(String key, String value) {
        return action(jedis -> jedis.set(key, value));
    }

    /**
     * Redis获取键对应的值
     *
     * @param key 键
     * @return 值
     */
    public String get(String key) {
        return action(jedis -> jedis.get(key));
    }

    /**
     * Redis是否存在当前键
     *
     * @param key 查询的键
     * @return 是否存在
     */
    public Boolean exists(String key) {
        return action(jedis -> jedis.exists(key));
    }

    /**
     * 设置Key的过期时间，单位以秒计
     *
     * @param key     键
     * @param seconds 秒数
     * @return 1为设置成功，0为设置失败（Jedis返回的就是Long，不知道为嘛要用Long）
     */
    public Long expire(String key, int seconds) {
        return action(jedis -> jedis.expire(key, seconds));
    }

    /**
     * 返回key的过期时间
     *
     * @param key 键
     * @return 返回过期时长（以秒为单位） 若不存在该key或该key不存在过期时间则返回-1
     */
    public Long ttl(String key) {
        return action(jedis -> jedis.ttl(key));
    }

    /**
     * 将key对应的值+1
     * （由于在Redis中都是字符串，所以Redis会将字符串转换为最大64bit的有符号整数类型后再增加）
     * （如果key不存在，则会将key对应的值设置为0后再执行增加操作）
     * （如果value的类型错误，则会异常报错！）
     *
     * @param key 键
     * @return 返回增加的结果，
     */
    public Long incr(String key) {
        return action(jedis -> jedis.incr(key));
    }

    /**
     * Redis设置Hash
     *
     * @param key   键
     * @param value 值（一个Map）
     * @return 存在则更新并返回0，不存在则新建并返回1
     */
    public Long hSet(String key, Map<String, String> value) {
        return action(jedis -> jedis.hset(key, value));
    }

    /**
     * Redis获取Hash
     *
     * @param key 键
     * @return hashMap
     */
    public Map<String, String> hGet(String key) {
        return action(jedis -> jedis.hgetAll(key));
    }

    /**
     * Redis设置hashMap
     *
     * @param key   map对应的键
     * @param field map中键
     * @param value map中键对应的值
     * @return 如果存在此map且存在此field，则更新数据并返回0，否则创建数据并返回1
     */
    public Long hSet(String key, String field, String value) {
        return action(jedis -> jedis.hset(key, field, value));
    }

    /**
     * Redis获取Hash
     *
     * @param key   键
     * @param field map中的键
     * @return map中键对应的值
     */
    public String hGet(String key, String field) {
        return action(jedis -> jedis.hget(key, field));
    }

    /**
     * Redis删除Hash
     *
     * @param key   键
     * @param field map中可变数量的键
     * @return 如果field在map中存在则删除并返回1，否则不做任何操作返回0
     */
    public Long hDel(String key, String... field) {
        return action(jedis -> jedis.hdel(key, field));
    }

    /**
     * Redis判断是否存在
     *
     * @param key   键
     * @param field map中的键
     * @return 判断key对应的map中是否存在field的键
     */
    public Boolean hExists(String key, String field) {
        return action(jedis -> jedis.hexists(key, field));
    }

    /**
     * Redis获取hash对应的val
     *
     * @param key 键
     * @return val的列表
     */
    public List<String> hVals(String key) {
        return action(jedis -> jedis.hvals(key));
    }

    /**
     * Redis删除key对应的数据
     *
     * @param key 键
     * @return 存在就删除且返回1，不存在不做任何操作返回0
     */
    public Long del(String... key) {
        return action(jedis -> jedis.del(key));
    }

    /**
     * 封装一部分重复操作，使jedis操作更简便
     */
    public <T> T action(RedisAction<T> action) {
        Jedis jedis = jedisPool.getResource();
        T v = action.action(jedis);
        jedis.close();
        return v;
    }

    public interface RedisAction<T> {
        T action(Jedis jedis);
    }
}
