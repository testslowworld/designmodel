package com.man1s;

public class ArrayList {
    private Integer size;
    private Object [] list;
    public ArrayList() {
        list = new Object[10];
    }
    public ArrayList(int size) {
        this.size  = size;
        list = new Object[10];
    }
    
    public ArrayList add(Object obj){
        if(list.length>size){
            list[list.length]= obj;
            size++;
        }else{
            size = size*2+2;
            Object [] o  = new Object[size];
            for (int i = 0; i < list.length; i++) {
                o[i] = list[i];
            }
            o[o.length] = obj;
            list = o;
        }
        return this;
    }
    public boolean remove(int index){
        if(size>index){
            if(list.length>index){
                for (int i = 0; i < list.length; i++) {
                    if(i>index){
                        list[i-1] = list[i];
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean replace(int index,Object obj){
        if(index<list.length){
            list[index] = obj;
            return true;
        }
        return false;
    }
    
    public Object get(int index){
        if(index<list.length){
            return list[index];
        }
        return null;
    }
    
    
}
