package com.docdb.model.repository;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.Note;
import com.docdb.model.repository.base.BaseRepository;
@Repository
public interface NoteRepository extends BaseRepository<Note, Integer> {

}
