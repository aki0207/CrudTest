package com.example.test.domain.service;

import java.util.Collection;

import com.example.test.domain.model.Crud;

public interface CrudService {

	Collection<Crud> findAll();
	
	Crud create(Crud crud);
}
