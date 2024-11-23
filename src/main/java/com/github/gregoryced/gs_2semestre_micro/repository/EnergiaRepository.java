package com.github.gregoryced.gs_2semestre_micro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.gregoryced.gs_2semestre_micro.model.Energia;

@Repository
public interface EnergiaRepository extends JpaRepository<Energia, Long>{
	<T> T findByNome(String nome);	
	<T> List<T> findAllByNome(String nome, Class<T> type);
	<T> List<T> findAllByNomeContains(String nome, Class<T> type);
}
