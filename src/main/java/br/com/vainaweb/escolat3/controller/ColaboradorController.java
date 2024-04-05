package br.com.vainaweb.escolat3.controller;

import java.util.List;

import br.com.vainaweb.escolat3.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador-teste")



// Classe responsavel por receber requisições e retornar respostas
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@Autowired
	private ColaboradorRepository repository;

	@GetMapping
	public List<ColaboradorModel> listarTodosColaboradores() {
		return service.encontrarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public String cadastrar(@RequestBody DadosColaborador dados) {

		return service.cadastrar(dados);
	}



}