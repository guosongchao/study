package com.guosc.study.proxy;

/**
 * Created by DOOM on 2018/2/5.
 */
public class StaticProxy implements IProxy {

    IProxy executor;

    public StaticProxy(IProxy executor){
        this.executor = executor;
    }

    @Override
    public void action() {
        System.out.println("static proxy:action");
        executor.action();
    }
}
