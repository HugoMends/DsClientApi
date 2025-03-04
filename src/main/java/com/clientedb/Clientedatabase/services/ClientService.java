package com.clientedb.Clientedatabase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientedb.Clientedatabase.dto.ClientDTO;
import com.clientedb.Clientedatabase.entities.Client;
import com.clientedb.Clientedatabase.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client result = repo.findById(id).get();
		return new ClientDTO(result);
		
	}
}
