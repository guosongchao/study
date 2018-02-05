package com.guosc.study.proxy;

/**
 * Created by DOOM on 2018/2/5.
 */
public class Executor implements IProxy {
    @Override
    public void action() {
        System.out.println("exector:action");
    }
}
