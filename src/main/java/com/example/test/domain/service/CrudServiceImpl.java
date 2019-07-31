package com.example.test.domain.service;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.test.domain.model.Crud;
import com.example.test.domain.repository.CrudRepository;

@Service
public class CrudServiceImpl implements CrudService {

	@Inject
    CrudRepository crudRepository;

	@Override
	public Collection<Crud> findAll() {
		return crudRepository.findAll();
	}

	@Override
	public Crud create(Crud crud) {
		
		String crudId = UUID.randomUUID().toString();
		crud.setUserId(crudId);
		crudRepository.create(crud);
		return crud;
	}
}
