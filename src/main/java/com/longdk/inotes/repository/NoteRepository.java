package com.longdk.inotes.repository;

import com.longdk.inotes.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Integer> {
    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
}
