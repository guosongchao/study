package com.guosc.study.chainOfRespon;

/**
 * Created by DOOM on 2018/2/7.
 */
public class Main {
    public static void main(String[] args) {
        HandlerI secondHandler = new SecondHandler(null);
        HandlerI firstHandler = new FirstHandler(secondHandler);

        firstHandler.handler();
    }
}
