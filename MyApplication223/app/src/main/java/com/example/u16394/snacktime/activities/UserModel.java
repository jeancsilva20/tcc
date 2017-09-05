package com.example.u16394.snacktime.activities;


public class UserModel {

    private final String mName;
    private final String mDescription;
    private final String mImage;

    public UserModel(String name, String description,String image) {
        mName = name;
        mDescription = description;
        mImage = image;

    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImage() {
        return mImage;
    }

    @Override
    public String toString() {
        return this.mDescription+this.mName+this.mImage;
    }
}
