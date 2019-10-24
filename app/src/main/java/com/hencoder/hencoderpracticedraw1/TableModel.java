package com.hencoder.hencoderpracticedraw1;

/**
 * @author ck
 * @date 2019/10/17.
 */
public class TableModel {
    public double percent;

    public String name;

    public int color;

    public int selected;
    public TableModel(String name,double percent){
        this.name = name;
        this.percent = percent;
    }
    public TableModel(String name,double percent,int color,int selected){
        this.name = name;
        this.percent = percent;
        this.color = color;
        this.selected = selected;
    }
}
