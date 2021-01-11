package com.docdb.model.repository;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.Document;
import com.docdb.model.repository.base.BaseRepository;
@Repository
public interface DocumentRepository extends BaseRepository<Document, Integer>{

}
