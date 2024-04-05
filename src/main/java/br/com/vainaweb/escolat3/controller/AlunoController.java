package br.com.vainaweb.escolat3.controller;

import br.com.vainaweb.escolat3.dto.DadosAluno;
import br.com.vainaweb.escolat3.model.AlunoModel;
import br.com.vainaweb.escolat3.repository.AlunoRepository;
import br.com.vainaweb.escolat3.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno-teste")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public List<AlunoModel> listarTodosAlunos(){
        return service.encontrarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id){
        var response = repository.findById(id)
                .map( resposta -> ResponseEntity.ok(resposta) )
                .orElse(ResponseEntity.notFound().build());

        return response;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody DadosAluno dados){
        return  service.cadastrar(dados);
    }







}
