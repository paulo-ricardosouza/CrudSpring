package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Colaborador;
import com.example.demo.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping
	public List<Colaborador> listarColaboradores(){
		return colaboradorService.listarColaborador();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador criar(@RequestBody Colaborador colaborador) {
		return colaboradorService.criar(colaborador);
	}

	@DeleteMapping("/{id}")
	public void removerColaborador(@PathVariable Long id) {
		colaboradorService.remover(id);
	}

	@PutMapping("/{id}")
	public Colaborador atualizaNomeESobrenome(@PathVariable Long id, @RequestBody Colaborador colaborador ) {
		return colaboradorService.alterarNomeESobrenome(id, colaborador.getNome(), colaborador.getSobrenome());
	}

}


