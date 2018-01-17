package com.guosc.study.designPatterns.template;

/**
 * Created by DOOM on 2018/1/17.
 */
public class Main {
    public static void main(String[] args) {
        //模板模式：子类通过实现扩展方案，实现复制父类并产生差异
        //定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使得子类在不改变算法的结构即可重新定义该算法的某些步骤
        ExamPaper examPaper = new ExamPaper() {
            @Override
            public String answer1() {
                return "";
            }
        };
        ExamPaper answer1 = new Answer1Paper();
        ExamPaper answer2 = new Answer2Paper();

        examPaper.question1();
        answer1.question1();
        answer2.question1();
    }
}
