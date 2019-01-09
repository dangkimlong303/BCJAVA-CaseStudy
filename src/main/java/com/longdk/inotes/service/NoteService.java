package com.longdk.inotes.service;

import com.longdk.inotes.model.Note;

public interface NoteService {
    Iterable<Note> findAll();

    Note findById(int id);

    void save(Note note);

    void remove(int id);
}
