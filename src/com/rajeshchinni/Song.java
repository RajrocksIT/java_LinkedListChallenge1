package com.rajeshchinni;

public class Song {

    private String title;
    private double duration;

    // constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    // getter
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
