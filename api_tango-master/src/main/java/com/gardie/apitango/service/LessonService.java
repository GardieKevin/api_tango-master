package com.gardie.apitango.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gardie.apitango.model.Lesson;
import com.gardie.apitango.repository.LessonRepository;

import lombok.Data;

@Data
@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public Optional<Lesson> getLesson(final Long id) {
        return lessonRepository.findById(id);
    }

    public Iterable<Lesson> getLessons() {
        return lessonRepository.findAll();
    }

    public void deleteLesson(final Long id) {
    	lessonRepository.deleteById(id);
    }

    public Lesson saveLesson(Lesson lesson) {
        Lesson savedLesson = lessonRepository.save(lesson);
        return savedLesson;
    }

}
