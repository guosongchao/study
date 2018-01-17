package com.guosc.study.designPatterns.proxy;

/**
 * Created by DOOM on 2018/1/16.
 */
public class RPCProxy implements RPCInterface {
    @Override
    public String httpGetRequest(String request) {
        return "this is rpc proxy to http get request :" + request;
    }

    @Override
    public String httpPostRequest(String request) {
        return "this is rpc proxy to http post request :" + request;
    }
}
