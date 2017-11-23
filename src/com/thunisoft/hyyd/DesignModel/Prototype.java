package com.thunisoft.hyyd.DesignModel;
import java.io.Serializable;




public class Prototype {
    public static void main(String[] args) {
        CompayPrototype  com  = new CompayPrototype();
        Long start = System.currentTimeMillis();
        for(int i =0 ;i<100000000;i++){
//            System.out.print(i);
            new CompayPrototype();
        }
        System.out.println("时间"+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        for(int i =0 ;i<100000000;i++){
            try {
                com.clone();
//                System.out.print(i);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("时间"+(System.currentTimeMillis()-start));
    }
}


class Part implements Cloneable,Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name ;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
class CompayPrototype implements Cloneable,Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name ;
    private Part part;
    private String [] list  ;
    private Part [] parts ;
    
    
    
    public String[] getList() {
        return list;
    }
    public void setList(String[] list) {
        this.list = list;
    }
    public CompayPrototype() {
        name  = "2";
        part = new Part();
        list =new String[2];
        parts = new Part[12];
        for(int i =0 ;i<10;i++){
            parts[i] = new Part();
        }
    }
    public CompayPrototype(String name, Part part) {
        super();
        this.name = name;
        this.part = part;
    }

    public String getName() {
        return name;
    }
    
    @Override
    protected CompayPrototype clone() throws CloneNotSupportedException {
        CompayPrototype com   = (CompayPrototype) super.clone();
        com.list  = this.getList().clone();
        if(this.part!=null){
//            com.part = (Part) this.part.clone();
        }
        return com;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    public Part getPart() {
        return part;
    }
    public void setPart(Part part) {
        this.part = part;
    }
    public Part[] getParts() {
        return parts;
    }
    public void setParts(Part[] parts) {
        this.parts = parts;
    }
}
