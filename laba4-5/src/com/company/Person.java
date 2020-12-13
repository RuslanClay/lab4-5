package com.company;

public class Person {
    private int id;
    private String name;
    private String surname;
    private int height;
    private int weight;

    public Person() {
        this.id = 00;
        this.name = "";
        this.surname = "";
        this.height = 0;
        this.weight = 0;
    }

    public Person(int id, String name, String surname, int height, int weight) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}