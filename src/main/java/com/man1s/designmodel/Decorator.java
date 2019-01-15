package com.man1s.designmodel;


public class Decorator {
    public static void main(String[] args) {
        Food f = new Vegetable(new Cream(new Bread(new Food())));
        System.out.println(f.make());

    }

}

class Food {
    private String name;

    public String make() {
        return name;
    }

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Bread extends Food {
    public Bread() {
    }

    private Food basic_food;

    public Bread(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make() + "面包";
    }
}

//奶油类
class Cream extends Food {

    private Food basic_food;

    public Cream(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make() + "奶油";
    }
}

//蔬菜类
class Vegetable extends Food {

    private Food basic_food;

    public Vegetable(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make() + "蔬菜";
    }

}

