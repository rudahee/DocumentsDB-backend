package com.docdb.model.repository;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.Topic;
import com.docdb.model.repository.base.BaseRepository;
@Repository
public interface TopicRepository extends BaseRepository<Topic, Integer>{

}
