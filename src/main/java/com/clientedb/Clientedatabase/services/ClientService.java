package com.clientedb.Clientedatabase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientedb.Clientedatabase.dto.ClientDTO;
import com.clientedb.Clientedatabase.entities.Client;
import com.clientedb.Clientedatabase.repositories.ClientRepository;
import com.clientedb.Clientedatabase.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client result = repo.findById(id).orElseThrow(() -> (new ResourceNotFoundException("Id inválido")));
		return new ClientDTO(result);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> dto = repo.findAll(pageable);
		return dto.map(x -> new ClientDTO(x));
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
		client = repo.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client client = repo.getReferenceById(id);
			client.setName(dto.getName());
			client.setCpf(dto.getCpf());
			client.setIncome(dto.getIncome());
			client.setBirthDate(dto.getBirthDate());
			client.setChildren(dto.getChildren());
			client = repo.save(client);
			return new ClientDTO(client);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id inválido");
		}
	}

	@Transactional
	public void delete(Long id) {
		if (!repo.existsById(id)) {
			throw new ResourceNotFoundException("Id inválido");
		}
		repo.deleteById(id);

	}

}
