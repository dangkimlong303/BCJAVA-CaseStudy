package com.longdk.inotes.service;

import com.longdk.inotes.model.NoteType;

public interface NoteTypeService {

    Iterable<NoteType> findAll();

    NoteType findById(int id);

    void save(NoteType noteType);

    void remove(int id);
}
