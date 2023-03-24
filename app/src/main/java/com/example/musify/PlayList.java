package com.example.musify;

public class PlayList {
    private String name;
    private String owner;
    private int image;

    public PlayList(String name, String owner, int image) {
        this.name = name;
        this.owner = owner;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getImage() {
        return image;
    }
}
