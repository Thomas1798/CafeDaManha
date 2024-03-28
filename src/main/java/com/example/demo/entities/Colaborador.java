package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Colaborador {
	 
	 private String nome;
	 @Column(unique = true)
	 private String cpf;
	 private String cafe;
	 private Date data;
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 public String getNome() {
		 return this.nome;
	 }
	 public String getCpf() {
		 return this.cpf;
	 }
	 public String getCafe() {
		 return this.cafe;
	 }
	 public Date getData() {
		 return this.data;
	 }
	 public Long getId() {
		 return this.id;
	 }
	 public void setNome(String a) {
		this.nome=a;
	 }
	 public void setCpf(String a) {
			this.cpf=a;
	}
	 public void setCafe(String a) {
			this.cafe=a;
	}
	 public void setData(Date a) {
			this.data=a;
	}
	
	 public boolean existsByCpf(String cpf) {
		return true;// metodo para verificar a existencia de outro cpf
	}
	 
	 public boolean isDataPosterior(Date data) {
			// Método para verificar se a data fornecida é posterior à data atual.
			Date dataAtual = new Date();
			return data.after(dataAtual);
	}
	
	  	 
}

