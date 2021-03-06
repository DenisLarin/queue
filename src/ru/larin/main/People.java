package ru.larin.main;

/**
 * Created by mrden on 30.10.2016.
 */
public class People {
    private String name;
    private int age;

    public People(){
        name = null;
        age = 0;
    }
    public People(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
