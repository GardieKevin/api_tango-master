package com.gardie.apitango.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gardie.apitango.model.Dancer;

@Repository
public interface DancerRepository extends CrudRepository<Dancer, Long> {

}