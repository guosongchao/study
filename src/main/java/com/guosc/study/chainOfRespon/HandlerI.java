package com.guosc.study.chainOfRespon;

/**
 * Created by DOOM on 2018/2/7.
 */
public abstract class HandlerI {
    public String handlerName;
    public HandlerI nextHandler;
    public abstract void handler();
}
