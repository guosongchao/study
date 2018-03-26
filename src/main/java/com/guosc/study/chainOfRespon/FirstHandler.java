package com.guosc.study.chainOfRespon;

/**
 * Created by DOOM on 2018/2/7.
 */
public class FirstHandler extends HandlerI {

    public FirstHandler(HandlerI nextHandler){
        this.handlerName = "first handler";
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
