package com.gardie.apitango.controller;

import java.util.List;
import java.util.Optional;

import com.gardie.apitango.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gardie.apitango.model.Dancer;
import com.gardie.apitango.service.DancerService;

@RestController
public class DancerController {
	
	@Autowired
	private DancerService dancerService;
	
	/**
	 * Create - Add a new dancer
	 * @param dancer An object dancer
	 * @return The Dancer object saved
	 */
	@PostMapping("/dancer")
	public Dancer createDancer(@RequestBody Dancer dancer) {
		return dancerService.saveDancer(dancer);
	}
	
	
	/**
	 * Read - Get one dancer 
	 * @param id The id of the dancer
	 * @return An Dancer object full filled
	 */
	@GetMapping("/dancer/{id}")
	public Dancer getDancer(@PathVariable("id") final Long id) {
		Optional<Dancer> dancer = dancerService.getDancer(id);
		if(dancer.isPresent()) {
			return dancer.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Read - Get all dancers
	 * @return - An Iterable object of Dancer full filled
	 */
	@GetMapping("/dancers")
	public Iterable<Dancer> getDancers() {
		return dancerService.getDancers();
	}
	
	/**
	 * Update - Update an existing dancer
	 * @param id - The id of the dancer to update
	 * @param dancer - The dancer object updated
	 * @return
	 */
	@PutMapping("/dancer/{id}")
	public Dancer updateDancer(@PathVariable("id") final Long id, @RequestBody Dancer dancer) {
		Optional<Dancer> d = dancerService.getDancer(id);
		if(d.isPresent()) {
			Dancer currentDancer = d.get();
			
			String firstname = dancer.getFirstname();
			if(firstname != null) {
				currentDancer.setFirstname(firstname);
			}
			String lastname = dancer.getLastname();
			if(lastname != null) {
				currentDancer.setLastname(lastname);
			}
			String danceLevel = dancer.getDanceLevel();
			if(danceLevel != null) {
				currentDancer.setDanceLevel(danceLevel);
			}
			String telephone = dancer.getTelephone();
			if(telephone != null) {
				currentDancer.setTelephone(telephone);
			}
			String email = dancer.getEmail();
			if(email != null) {
				currentDancer.setEmail(email);
			}
			String gender = dancer.getGender();
			if (gender != null){
				currentDancer.setGender(gender);
			}
			List<Lesson> followedLessons = dancer.getFollowedLessons();
			if(followedLessons != null){
				currentDancer.setFollowedLessons(followedLessons);
			}

			dancerService.saveDancer(currentDancer);
			return currentDancer;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete a dancer
	 * @param id - The id of the dancer to delete
	 */
	@DeleteMapping("/dancer/{id}")
	public void deleteDancer(@PathVariable("id") final Long id) {
		dancerService.deleteDancer(id);
	}
	

}
