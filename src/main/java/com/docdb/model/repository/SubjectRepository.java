package com.docdb.model.repository;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.Subject;
import com.docdb.model.repository.base.BaseRepository;
@Repository
public interface SubjectRepository extends BaseRepository<Subject, Integer>{

}
