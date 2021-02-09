package com.oliver.todolist;

import java.util.UUID;

public class Note {
    private UUID id;
    private String contents;
    private boolean done;

    public Note(String contents) {
        this.id = UUID.randomUUID();
        this.contents = contents;
        this.done = false;
    }


    public UUID getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public boolean isDone() {
        return done;
    }

    public void MarkAsDone() {
        this.done = true;
    }
}
