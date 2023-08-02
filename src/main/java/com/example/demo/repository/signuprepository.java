package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.mymodels;
@Repository

public interface signuprepository extends CrudRepository<mymodels,Integer> {

}