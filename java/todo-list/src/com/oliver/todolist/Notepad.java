package com.oliver.todolist;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.logging.XMLFormatter;

public class Notepad {
    private ArrayList<Note> notes;

    public Notepad(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public Notepad() {
        this(new ArrayList<>());
    }

    public void Init() {
        this.Add(new Note("Do stuff"));
        this.Add(new Note("Do things"));
        this.Add(new Note("Do shit"));
        this.Add(new Note("Do nothing"));
        this.Add(new Note("die"));

        this.notes.addAll(NotepadIO.GetNotes());
    }

    public void Run() {
        while (true) {
            Loop();
        }
    }

    private void Loop() {
        NotepadIO.PrintNotes(notes);
        int i = NotepadIO.GetInt("Enter note to mark as done: ", x -> x >= 0 && x <= notes.size() - 1);
        this.Find(GetContentsForIndex(i))
            .MarkAsDone();
    }

    private String GetContentsForIndex(int i) {
        return notes.get(i)
                    .getContents();
    }


    public Note Find(Predicate<Note> condition) {
        return notes.stream()
                          .filter(condition)
                          .findFirst()
                          .orElse(null);
    }

    public Note Find(String contents) {
        return this.Find(x -> x.getContents()
                               .equals(contents));
    }

    public void Add(Note note) {
        this.notes.add(note);
    }
}
