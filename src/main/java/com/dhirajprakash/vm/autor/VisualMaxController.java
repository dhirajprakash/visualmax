package com.dhirajprakash.vm.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VisualMaxController {

	private VisualMaxService visualMaxService;

	@Autowired
	public void setVisualMaxService(VisualMaxService visualMaxService) {
		this.visualMaxService = visualMaxService;
	}
	
	/*
	Codigo corrigido para incluir com post da json em format seguinte
	{
		"id":1,
		"nome":"Dhiraj Prakash"
		}
	
	*/
	
	@PostMapping("/vmax/incluir-via-json")
	@CrossOrigin
	public ResponseEntity<?> createUser(@RequestBody Autor autor) {
		return visualMaxService.incluirAutor(autor.getNome());
	}

	@PostMapping("/vmax/incluir")
	@CrossOrigin
	public ResponseEntity<?> incluirAutor(@RequestHeader("nome") String nome) {
		return visualMaxService.incluirAutor(nome);
	}

	@PostMapping("/vmax/alterar")
	@CrossOrigin
	public ResponseEntity<?> alterarAutor(@RequestHeader("id") String id, @RequestHeader("nome") String nome) {
		return visualMaxService.alterarAutor(Integer.valueOf(id), nome);
	}

	@PostMapping("/vmax/excluir")
	@CrossOrigin
	public ResponseEntity<?> excluirAutor(@RequestHeader("id") String id) {
		return visualMaxService.excluirAutor(Integer.valueOf(id));
	}

	@PostMapping("/vmax/listar")
	@CrossOrigin
	public ResponseEntity<?> listarAutor(@RequestHeader("id") String id) {
		return visualMaxService.listarAutor(Integer.valueOf(id));
	}

	@PostMapping("/vmax/listartodos")
	@CrossOrigin
	public ResponseEntity<?> listarTodosAutor() {
		return visualMaxService.listarTodosAutor();
	}

}
