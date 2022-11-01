package com.gardie.apitango.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gardie.apitango.model.Lesson;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {

}