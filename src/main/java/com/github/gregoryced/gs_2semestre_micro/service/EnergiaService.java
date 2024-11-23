package com.github.gregoryced.gs_2semestre_micro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gregoryced.gs_2semestre_micro.model.Energia;
import com.github.gregoryced.gs_2semestre_micro.repository.EnergiaRepository;

@Service
public class EnergiaService {
	
	@Autowired
    private EnergiaRepository energiaRepository;
	
	public List<Energia> list() {
        return energiaRepository.findAll();
    }
	
	 public Optional<Energia> findById(Long id) {
	     return energiaRepository.findById(id);
	 }
	 
	 public Optional<Energia> findBySustentavel(String nome) {
	     return energiaRepository.findByNome(nome);
	 }
	 
	 public Energia save(Energia energia) {
		 return energiaRepository.save(energia);
	 }
	 
	 public void delete(Long id) {
        energiaRepository.deleteById(id);
    }
	
	public boolean existsById(Long id) {        
        return energiaRepository.existsById(id);
    }
	
}
