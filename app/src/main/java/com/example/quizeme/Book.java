package com.example.quizeme;

public class Book {
    private String title;
    private int imageResId;
    private String fileName;

    public Book(String title, int imageResId, String fileName) {
        this.title = title;
        this.imageResId = imageResId;
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getFileName() {
        return fileName;
    }
}
