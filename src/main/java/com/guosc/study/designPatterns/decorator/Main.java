package com.guosc.study.designPatterns.decorator;

/**
 * Created by DOOM on 2018/1/16.
 */
public class Main {
    public static void main(String[] args) {
        //装饰模式：动态的给对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更灵活

        Person p = new Person("阿Q");
        Clothes tShirt = new Clothes("T-Shirt");
        Clothes bigTrouser = new Clothes("Big-Trouse");

        p.eat();
        p.drink();

        tShirt.decorator(bigTrouser);
        p.decorator(tShirt);
        p.show();
    }
}
