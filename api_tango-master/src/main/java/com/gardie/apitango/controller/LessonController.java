package com.gardie.apitango.controller;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gardie.apitango.model.Lesson;
import com.gardie.apitango.service.LessonService;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	/**
	 * Create - Add a new lesson
	 * @param lesson An object lesson
	 * @return The Lesson object saved
	 */
	@PostMapping("/lesson")
	public Lesson createLesson(@RequestBody Lesson lesson) {
		return lessonService.saveLesson(lesson);
	}
	
	
	/**
	 * Read - Get one lesson 
	 * @param id The id of the lesson
	 * @return An Lesson object full filled
	 */
	@GetMapping("/lesson/{id}")
	public Lesson getLesson(@PathVariable("id") final Long id) {
		Optional<Lesson> lesson = lessonService.getLesson(id);
		if(lesson.isPresent()) {
			return lesson.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Read - Get all lessons
	 * @return - An Iterable object of Lesson full filled
	 */
	@GetMapping("/lessons")
	public Iterable<Lesson> getLessons() {
		return lessonService.getLessons();
	}
	
	/**
	 * Update - Update an existing lesson
	 * @param id - The id of the lesson to update
	 * @param employee - The lesson object updated
	 * @return
	 */
	@PutMapping("/lesson/{id}")
	public Lesson updateLesson(@PathVariable("id") final Long id, @RequestBody Lesson lesson) {
		Optional<Lesson> l = lessonService.getLesson(id);
		if(l.isPresent()) {
			Lesson currentLesson = l.get();
			
			String lessonName = lesson.getLessonName();
			if(lessonName != null) {
				currentLesson.setLessonName(lessonName);
			}
			String description = lesson.getDescription();
			if(description != null) {
				currentLesson.setDescription(description);;
			}
			Date lessonDate = lesson.getLessonDate();
			if(lessonDate != null) {
				currentLesson.setLessonDate(lessonDate);
			}
			String lessonTime = lesson.getLessonTime();
			if(lessonTime != null) {
				currentLesson.setLessonTime(lessonTime);
			}
			String danceLevel = lesson.getDanceLevel();
			if(danceLevel != null) {
				currentLesson.setDanceLevel(danceLevel);
			}
			Integer price = lesson.getPrice();
			if(price != null) {
				currentLesson.setPrice(price);
			}
			lessonService.saveLesson(currentLesson);
			return currentLesson;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete a lesson
	 * @param id - The id of the lesson to delete
	 */
	@DeleteMapping("/lesson/{id}")
	public void deleteLesson(@PathVariable("id") final Long id) {
		lessonService.deleteLesson(id);
	}
	

}
