package ru.denis.spring.model;

public class Note {
    private int id;
    private String text;

    public Note(int id, String name) {
        this.id = id;
        this.text = name;
    }
    public Note(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
