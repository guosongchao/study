package com.guosc.study.designPatterns.iterator;

/**
 * Created by DOOM on 2017/12/19.
 */
public class Book {
    public String name;

    public Book(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
