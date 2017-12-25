package com.lwtech.customer.bean;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */

public class Template {

    public Template(String name,int height){
        this.name = name;
        this.height = height;
    }
    private String name;
    private int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
