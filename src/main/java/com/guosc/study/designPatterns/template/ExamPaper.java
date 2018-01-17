package com.guosc.study.designPatterns.template;

/**
 * Created by DOOM on 2018/1/17.
 */
public abstract class ExamPaper {
    public void question1(){
        System.out.println("问题1:");
        System.out.println("答案:" + answer1());
    }

    public abstract String answer1();

}
