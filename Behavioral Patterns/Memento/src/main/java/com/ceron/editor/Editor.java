package com.ceron.editor;

public class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // Saves the current state in a memento
    public Memento save() {
        return new Memento(content);
    }

    // Restores the state from a memento
    public void restore(Memento memento) {
        this.content = memento.getContent();
    }
}
