package com.example.test.domain.repository;

import java.util.Collection;

import com.example.test.domain.model.Crud;


public interface CrudRepository {

	Collection<Crud> findAll();
	
	void create(Crud crund);
}
