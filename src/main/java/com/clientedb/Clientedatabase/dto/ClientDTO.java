
package com.clientedb.Clientedatabase.dto;

import java.time.LocalDate;

import com.clientedb.Clientedatabase.entities.Client;

public class ClientDTO {
	
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private LocalDate birthDate;
	private Integer children;
	
	
	public ClientDTO(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	public ClientDTO(Client client) {
		name = client.getName();
		cpf = client.getCpf();
		income = client.getIncome();
		birthDate = client.getBirthDate();
		children = client.getChildren();
		
	}
	
	
	public String getName() {
		return name;
	}
	public String getCpf() {
		return cpf;
	}
	public Double getIncome() {
		return income;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public Integer getChildren() {
		return children;
	}
	
	
}
