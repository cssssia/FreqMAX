package com.example.freqmax;

public class Athlete {

    private String name;
    private String age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getFCM(){
        return "FCM: " + (220 - Integer.parseInt(age));
    }

}