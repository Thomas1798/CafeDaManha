package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseModelDTO;
import com.example.demo.entities.Colaborador;
import com.example.demo.repository.Repository;


@RestController 
@RequestMapping("/colaboradores")
public class ColaboradorController {
	
	@Autowired
	private Repository repository;
	
	@GetMapping
	public List<Colaborador> listar() {
		return repository.findAll();
	}
	
	
	@PostMapping
	public ResponseModelDTO put(@RequestBody Colaborador colaborador) {
		if(colaborador.getCpf().length()!=11 )  {
			return new ResponseModelDTO("CPF inválido");
		}else if(!colaborador.getCpf().matches("[0-9]+")){
			return new ResponseModelDTO("CPF inválido");
		}else if(repository.findByCpf(colaborador.getCpf()).size()>0) {
			return new ResponseModelDTO("CPF já existe");
		}else if(!colaborador.isDataPosterior(colaborador.getData())) {
			return new ResponseModelDTO("data inválida");
		}
		Colaborador colaboradorSalvo = repository.save(colaborador);
		return new ResponseModelDTO<Colaborador>("Sucesso",colaboradorSalvo);
	}
}
