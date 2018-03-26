package com.guosc.study.chainOfRespon;

/**
 * Created by DOOM on 2018/2/7.
 */
public class SecondHandler extends HandlerI {

    public SecondHandler(HandlerI nextHandler){
        this.handlerName = "second handler";
        this.nextHandler = nextHandler;
    }

    @Override
    public void handler() {
        System.out.println("this is " + handlerName);
        if(nextHandler != null){
            nextHandler.handler();
        }
    }
}
