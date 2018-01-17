package com.guosc.study.designPatterns.proxy;

/**
 * Created by DOOM on 2018/1/16.
 */
public class RPCReal implements RPCInterface {

    private RPCInterface proxy;

    public RPCReal(RPCInterface proxy){
        this.proxy = proxy;
    }

    @Override
    public String httpGetRequest(String request) {
        return proxy.httpGetRequest(request);
    }

    @Override
    public String httpPostRequest(String request) {
        return proxy.httpPostRequest(request);
    }
}
