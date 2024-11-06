package com.ceron.editor;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Caretaker caretaker = new Caretaker();

        editor.setContent("Content version 1.");
        System.out.println("Current content: " + editor.getContent());
        caretaker.save(editor);

        editor.setContent("Content version 2.");
        System.out.println("Current content: " + editor.getContent());
        caretaker.save(editor);

        editor.setContent("Content version 3.");
        System.out.println("Current content: " + editor.getContent());

        // Undo changes
        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getContent());

        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getContent());
    }
}
