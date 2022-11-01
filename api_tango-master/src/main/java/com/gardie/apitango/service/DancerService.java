package com.gardie.apitango.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gardie.apitango.model.Dancer;
import com.gardie.apitango.repository.DancerRepository;
import lombok.Data;

@Data
@Service
public class DancerService {

    @Autowired
    private DancerRepository dancerRepository;

    public Optional<Dancer> getDancer(final Long id) {
        return dancerRepository.findById(id);
    }

    public Iterable<Dancer> getDancers() {
        return dancerRepository.findAll();
    }

    public void deleteDancer(final Long id) {
    	dancerRepository.deleteById(id);
    }

    public Dancer saveDancer(Dancer dancer) {
    	Dancer savedDancer = dancerRepository.save(dancer);
        return savedDancer;
    }

}
