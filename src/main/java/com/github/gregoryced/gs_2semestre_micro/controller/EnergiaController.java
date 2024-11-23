package com.github.gregoryced.gs_2semestre_micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.gregoryced.gs_2semestre_micro.dtos.EnergiaRequestCreateDto;
import com.github.gregoryced.gs_2semestre_micro.dtos.EnergiaRequestUpdateDto;
import com.github.gregoryced.gs_2semestre_micro.dtos.EnergiaResponseDto;
import com.github.gregoryced.gs_2semestre_micro.mapper.EnergiaMapper;
import com.github.gregoryced.gs_2semestre_micro.repository.EnergiaRepository;
import com.github.gregoryced.gs_2semestre_micro.service.EnergiaService;
import com.github.gregoryced.gs_2semestre_micro.views.EnergiaFullView;
import com.github.gregoryced.gs_2semestre_micro.views.EnergiaSimpleView;
import com.github.gregoryced.gs_2semestre_micro.views.EnergiaViewType;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/energia")
@RequiredArgsConstructor
public class EnergiaController {
		
	@Autowired
	private  EnergiaService energiaService;
	@Autowired
	private  EnergiaMapper energiaMapper;
	@Autowired
	private  EnergiaRepository energiaRepository;
	   
	   @GetMapping
	   public ResponseEntity<List<EnergiaResponseDto>> list() {
	       List<EnergiaResponseDto> dtos = energiaService.list()
	           .stream()
	           .map(e -> energiaMapper.toDto(e))
	           .toList();
	       
	       return ResponseEntity.ok().body(dtos);
	   }

	   @PostMapping
	   public ResponseEntity<EnergiaResponseDto> create(@RequestBody EnergiaRequestCreateDto dto) {        

	       return ResponseEntity
	       		.status(HttpStatus.CREATED)
	       		.body(
	       			energiaMapper.toDto(
	       					energiaService.save(energiaMapper.toModel(dto)))
	       			);
	   }

	   @PutMapping("{id}")
	   public ResponseEntity<EnergiaResponseDto> update(
	                       @PathVariable Long id, 
	                       @RequestBody EnergiaRequestUpdateDto dto) {
	       if (! energiaService.existsById(id)){
	           throw new RuntimeException("Id inexistente");
	       }                
	       return ResponseEntity.ok()
	       		.body(
	       			energiaMapper.toDto(
	       				energiaService.save(energiaMapper.toModel(id, dto)))
	       		);
	   }
	   
	   @DeleteMapping("{id}")
	   public void delete(@PathVariable Long id) {
	       if (! energiaService.existsById(id)){
	       	throw new RuntimeException("Id inexistente");
	       }

	       energiaService.delete(id);
	   }

	   @GetMapping("{id}")
	   public ResponseEntity<EnergiaResponseDto> findById(@PathVariable Long id) {    	
	   	return ResponseEntity.ok()
	   			.body(
	   				energiaService
	   					.findById(id)
	   					.map(e -> energiaMapper.toDto(e))
	   					.orElseThrow(() -> new RuntimeException("Id inexistente"))
	   			);    	  		     
	   }
	   
	   @GetMapping("/find")
	   public  ResponseEntity<?> findBySustentavel(
	               @RequestParam String nome, 
	               EnergiaViewType type) { 

	       switch (type) {
	           case FULL:
	               return ResponseEntity.ok().body(energiaRepository.findAllByNomeContains(nome, EnergiaFullView.class));                
	           case SIMPLE:
	               return ResponseEntity.ok().body(energiaRepository.findAllByNomeContains(nome, EnergiaSimpleView.class));            
	       }
	       return ResponseEntity.noContent().build();
	   }
}
