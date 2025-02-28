package com.example.android_project_2;

public class Car {
    private final String name;
    private final int imageResId; // Store image resource ID

    public Car(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
