package com.example.touhoutd;

public class AvatarIcon {

    private String name;

    private int imageId;

    private int width;

    private int height;

    public AvatarIcon(String name, int imageId, int width, int height) {
        this.name = name;
        this.imageId = imageId;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
