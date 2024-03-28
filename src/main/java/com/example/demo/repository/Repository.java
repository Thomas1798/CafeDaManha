package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Colaborador;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Colaborador, Long >{
	
	List<Colaborador> findByCpf(String cpf);
}
