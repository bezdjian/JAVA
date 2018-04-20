package com.example.jerseyapi;

public class Track {

    String title;
    String singer;

    public Track(String title, String singer){
        this.singer = singer;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Track [title=" + title + ", singer=" + singer + "]";
    }
}
