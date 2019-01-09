package com.longdk.inotes.service.Impl;

import com.longdk.inotes.model.Note;
import com.longdk.inotes.repository.NoteRepository;
import com.longdk.inotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(int id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(int id) {
        noteRepository.deleteById(id);
    }
}
