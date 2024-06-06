package com.libarary.Library.dto;

public class KitabDto {
    private int id;
    private String name;
    private String author;
    private int cost;

    public KitabDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public KitabDto(int id, String name, String author, int cost) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.cost = cost;
    }
}
