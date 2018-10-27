package com.dhirajprakash.vm.autor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VisualMaxService {

	@Autowired
	private AutorRepository vmaxAutor;
	ObjectMapper mapper = new ObjectMapper();
	Map<String, String> returnString = new HashMap<>();

	private Logger logger = LoggerFactory.getLogger(VisualMaxService.class);

	public ResponseEntity<?> incluirAutor(String nome) {

		Autor autor = new Autor();
		autor.setId(vmaxAutor.findMaxId() + 1);
		autor.setNome(nome);
		vmaxAutor.save(autor);
		String jsonInString = "{}";
		try {
			jsonInString = mapper.writeValueAsString(autor);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnString.put("DESCRICAO", "SALVO COM SUCESSO");
		returnString.put("DADOS", jsonInString);

		return new ResponseEntity(returnString.toString(), HttpStatus.OK);
	}

	public ResponseEntity<?> alterarAutor(Integer id, String nome) {

		Autor autor = vmaxAutor.findOne(id);
		autor.setNome(nome);
		vmaxAutor.save(autor);
		String jsonInString = "{}";
		try {
			jsonInString = mapper.writeValueAsString(autor);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		returnString.put("DESCRICAO", "ALTERADO COM SUCESSO");
		returnString.put("DADOS", jsonInString);

		return new ResponseEntity(returnString.toString(), HttpStatus.OK);
	}

	public ResponseEntity<?> excluirAutor(Integer id) {

		Autor autor = vmaxAutor.findOne(id);
		vmaxAutor.delete(autor);
		String jsonInString = "{}";
		try {
			jsonInString = mapper.writeValueAsString(autor);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		returnString.put("DESCRICAO", "EXCLUIDO COM SUCESSO");
		returnString.put("DADOS", jsonInString);

		return new ResponseEntity(returnString.toString(), HttpStatus.OK);
	}

	public ResponseEntity<?> listarAutor(Integer id) {
		Autor autor = vmaxAutor.findOne(id);
		String jsonInString = "{}";
		try {
			jsonInString = mapper.writeValueAsString(autor);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnString.put("DESCRICAO", "LISTADO AUTOR COM SUCESSO");
		returnString.put("DADOS", jsonInString);

		return new ResponseEntity(returnString.toString(), HttpStatus.OK);
		

	}

	public ResponseEntity<?> listarTodosAutor() {

		return new ResponseEntity(vmaxAutor.findAll(), HttpStatus.OK);
	}

}
