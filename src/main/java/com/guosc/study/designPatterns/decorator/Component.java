package com.guosc.study.designPatterns.decorator;

/**
 * Created by DOOM on 2018/1/16.
 */
public interface Component {
    public void show();
    public void decorator(Component component);
}
