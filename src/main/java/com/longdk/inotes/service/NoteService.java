package com.longdk.inotes.service;

import com.longdk.inotes.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);

    Note findById(int id);

    void save(Note note);

    void remove(int id);

    Page<Note> findAllByTitleContaining(String title,Pageable pageable);
}
