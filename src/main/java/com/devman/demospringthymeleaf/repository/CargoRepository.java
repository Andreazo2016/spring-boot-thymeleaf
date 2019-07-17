package com.devman.demospringthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devman.demospringthymeleaf.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
