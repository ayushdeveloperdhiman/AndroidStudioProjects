package com.ayush.bio.data;

public class Bio {
    private String name,hobbies;
    public Bio(String name,String hobbies){
        this.name=name;
        this.hobbies=hobbies;
    }

    public Bio() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
