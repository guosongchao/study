package com.guosc.study.designPatterns.iterator;

/**
 * Created by DOOM on 2017/12/19.
 */
public interface Iterator<K> {
    public boolean hasNext();

    public K next();
}
