package com.clientedb.Clientedatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientedb.Clientedatabase.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
