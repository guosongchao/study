package com.guosc.study.designPatterns.decorator;

/**
 * Created by DOOM on 2018/1/16.
 */
public class Person implements Component {
    private String name;
    private Component component;

    public Person(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println("eat");
    }

    public void drink(){
        System.out.println("drink");
    }

    @Override
    public void show() {
        if(component != null){
            System.out.print(name + "今天穿了:");
            component.show();
        }
    }

    @Override
    public void decorator(Component component) {
        this.component = component;
    }
}
