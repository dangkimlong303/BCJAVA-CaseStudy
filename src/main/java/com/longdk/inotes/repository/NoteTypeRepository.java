package com.longdk.inotes.repository;

import com.longdk.inotes.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteTypeRepository extends PagingAndSortingRepository<NoteType, Integer> {
}
