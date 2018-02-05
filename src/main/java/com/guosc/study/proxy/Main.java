package com.guosc.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by DOOM on 2018/2/5.
 */
public class Main {
    public static void main(String[] args) {
        //static proxy
//        IProxy proxy = new StaticProxy(new Executor());
//        proxy.action();
        //dynamic proxy
        Executor executor = new Executor();
        InvocationHandler handler = new DynamicProxy(executor);
        IProxy proxy = (IProxy) Proxy.newProxyInstance(handler.getClass().getClassLoader(), executor.getClass().getInterfaces(), handler);
        proxy.action();
    }
}
