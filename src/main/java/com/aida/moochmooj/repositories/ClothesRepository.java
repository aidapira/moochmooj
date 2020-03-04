package com.aida.moochmooj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aida.moochmooj.models.clothes;

import java.util.List;

@Repository
public interface ClothesRepository extends CrudRepository<clothes, Long>{

	List<clothes> findAll();
}
