package com.example.danangdulich.model;

public class ScreenItem {
    String Title,Description;
    int SceenImg;

    public ScreenItem(String title, String description, int sceenImg) {
        Title = title;
        Description = description;
        SceenImg = sceenImg;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setSceenImg(int sceenImg) {
        SceenImg = sceenImg;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getSceenImg() {
        return SceenImg;
    }
}
