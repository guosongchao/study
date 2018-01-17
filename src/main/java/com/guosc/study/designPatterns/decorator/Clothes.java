package com.guosc.study.designPatterns.decorator;

/**
 * Created by DOOM on 2018/1/16.
 */
public class Clothes implements Component {
    private String name;
    private Component component;

    public Clothes(String name){
        this.name = name;
    }

    @Override
    public void show() {
        System.out.print(name + "\t");
        if(component != null){
            component.show();
        }
    }

    @Override
    public void decorator(Component component) {
        this.component = component;
    }
}
