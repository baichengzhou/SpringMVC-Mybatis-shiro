package com.sojson.core.shiro.cache.impl;

import org.apache.shiro.cache.Cache;

import com.sojson.core.shiro.cache.JedisManager;
import com.sojson.core.shiro.cache.JedisShiroCache;
import com.sojson.core.shiro.cache.ShiroCacheManager;


public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
//        getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
