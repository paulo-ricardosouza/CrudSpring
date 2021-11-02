package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Colaborador;
import com.example.demo.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public List<Colaborador> listarColaborador(){
		return colaboradorRepository.findAll();

	}

	public Colaborador buscarColaborador( long id) {
		Optional<Colaborador> colaboradorOpt = colaboradorRepository.findById(id);
		if(colaboradorOpt.isPresent()) {
			return colaboradorOpt.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}


	public Colaborador criar(Colaborador colaborador) {
		colaborador.setId(null);
		return colaboradorRepository.save(colaborador);
	}

	public void remover(Long id) {
		colaboradorRepository.deleteById(id);
	}

	public Colaborador alterarNomeESobrenome(Long id, String nome, String sobrenome) {
		Colaborador colaborador = buscarColaborador(id);
		colaborador.setNome(nome);
		colaborador.setSobrenome(sobrenome);
		return colaboradorRepository.save(colaborador);
	}
}



