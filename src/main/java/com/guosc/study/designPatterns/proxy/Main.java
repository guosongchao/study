package com.guosc.study.designPatterns.proxy;

/**
 * Created by DOOM on 2018/1/16.
 */
public class Main {
    public static void main(String[] args) {
        //代理模式：为其他对象提供一种代理以控制这种对象的访问
        RPCInterface rpc = new RPCReal(new RPCProxy());

        System.out.println(rpc.httpGetRequest("get"));
        System.out.println(rpc.httpPostRequest("post"));
    }
}
