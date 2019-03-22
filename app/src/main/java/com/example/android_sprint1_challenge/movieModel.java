package com.example.android_sprint1_challenge;

public class movieModel
{
    int index;
    String title;
    boolean seen;

    public movieModel(int index, String title, boolean seen)
    {
        this.index = index;
        this.title = title;
        this.seen = seen;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
