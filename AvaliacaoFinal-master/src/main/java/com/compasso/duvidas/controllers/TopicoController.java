package com.compasso.duvidas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.duvidas.dto.TopicoDTO;
import com.compasso.duvidas.dto.TopicoFormDTO;
import com.compasso.duvidas.services.TopicoService;

@RestController
@RequestMapping("topicos")
public class TopicoController {
	
	@Autowired
	private TopicoService topicoService;
	
	@PostMapping
	public ResponseEntity<TopicoDTO> save(@RequestBody @Valid TopicoFormDTO form) {
		return topicoService.save(form);
	}
	
	@GetMapping
	public ResponseEntity <Page<TopicoDTO>> findAll(@PageableDefault Pageable page,
			@RequestParam(required = false)String titulo) {
		return ResponseEntity.ok(topicoService.findAll(page, titulo));
	}

	/*@GetMapping("/{id}")
	public ResponseEntity<TopicoDTO> findById(@PathVariable Long id){ return topicoService.findById(id);}*/


	@PutMapping("/{id}")
	public ResponseEntity<TopicoDTO> update(@PathVariable Long id, @RequestBody TopicoFormDTO form){
		return topicoService.update(id, form);
	}

	@DeleteMapping
	public ResponseEntity<TopicoDTO> delete(@PathVariable Long id){ return topicoService.delete(id);}

	@GetMapping("/fechar/{id}")
	public ResponseEntity<?> findAll(@PathVariable Long id) {
		return topicoService.close(id);
	}
}
