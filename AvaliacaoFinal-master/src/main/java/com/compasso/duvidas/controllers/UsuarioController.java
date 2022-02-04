package com.compasso.duvidas.controllers;

import com.compasso.duvidas.dto.UsuarioDTO;
import com.compasso.duvidas.dto.UsuarioFormDTO;
import com.compasso.duvidas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @CacheEvict(value = "listaDeUsuario")
    public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioFormDTO form) {
        return usuarioService.save(form);
    }

    @GetMapping
    @Cacheable(value = "listaDeUsuario")
    public ResponseEntity<Page<UsuarioDTO>> findAll(@PageableDefault Pageable page,
                                                    @RequestParam(required = false)String nome){
        return ResponseEntity.ok(usuarioService.findAll(page, nome));

    }

    /* adicionar aluno à uma determinada turma
    @GetMapping("/turmas/")
    public ResponseEntity<UsuarioDTO> adicionarEmTurma(){
    } */



}
