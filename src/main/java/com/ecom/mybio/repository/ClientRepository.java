package com.ecom.mybio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.mybio.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
