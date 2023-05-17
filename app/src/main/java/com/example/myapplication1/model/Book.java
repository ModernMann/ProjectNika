package com.example.myapplication1.model;

public class Book {
    int id, category;
    String  img, title, nomer, colvo, color, text;

    public Book(int id, String img, String title, String nomer, String colvo, String color, String text, int category) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.nomer = nomer;
        this.colvo = colvo;
        this.color = color;
        this.category = category;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getColvo() {
        return colvo;
    }

    public void setcolvo(String colvo) {
        this.colvo = colvo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
