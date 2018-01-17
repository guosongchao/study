package com.guosc.study.designPatterns.proxy;

/**
 * Created by DOOM on 2018/1/16.
 */
public interface RPCInterface {
    public String httpGetRequest(String request);
    public String httpPostRequest(String request);
}
