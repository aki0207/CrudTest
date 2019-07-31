package com.example.test.domain.service;

import java.util.Collection;

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
}
