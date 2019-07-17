package com.devman.demospringthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devman.demospringthymeleaf.model.Cargo;
import com.devman.demospringthymeleaf.repository.CargoRepository;
import com.devman.demospringthymeleaf.util.ValidacaoUtil;

@Service
@Transactional(readOnly = false)
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public void salvar(Cargo cargo) {
		cargoRepository.save( cargo );
	}
	public void update(Cargo cargo) {
		cargoRepository.save( cargo );
	}
	public void delete(Long idCargo) {
		cargoRepository.deleteById( idCargo );
	}
	@Transactional(readOnly = true)
	public Cargo findById(Long id) {
		return cargoRepository.getOne(id);
	}
	@Transactional(readOnly = true)
	public List<Cargo> findAll(){
		return cargoRepository.findAll();
	}

	public boolean podeDeletar(Long idCargo) {
		Cargo cargo =  findById(idCargo);
		return ValidacaoUtil.isPreenchido(cargo) && cargo.getFuncionarios().isEmpty();
	}
}
