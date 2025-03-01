package com.example.android_project_2;

public class Car {
    private final String name;
    private final int imageResId; // Store image resource ID

    private final String manufacturerUrl;

    public Car(String name, int imageResId, String manufacturerUrl) {
        this.name = name;
        this.imageResId = imageResId;
        this.manufacturerUrl = manufacturerUrl;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getManufacturerUrl() {
        return manufacturerUrl;

    }
}
