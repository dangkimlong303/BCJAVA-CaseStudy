package com.longdk.inotes.service.Impl;

import com.longdk.inotes.model.NoteType;
import com.longdk.inotes.repository.NoteTypeRepository;
import com.longdk.inotes.service.NoteService;
import com.longdk.inotes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;

    @Override
    public Iterable<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType findById(int id) {
        return noteTypeRepository.findById(id).get();
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);
    }

    @Override
    public void remove(int id) {
        noteTypeRepository.deleteById(id);
    }
}
