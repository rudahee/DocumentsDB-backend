package com.docdb.model.repository;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.Event;
import com.docdb.model.repository.base.BaseRepository;
@Repository
public interface EventRepository extends BaseRepository<Event, Integer> {

}
