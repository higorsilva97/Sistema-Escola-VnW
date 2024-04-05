package br.com.vainaweb.escolat3.service;


import br.com.vainaweb.escolat3.dto.DadosAluno;
import br.com.vainaweb.escolat3.model.AlunoModel;
import br.com.vainaweb.escolat3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<AlunoModel> encontrarTodos(){
        return  repository.findAll();
    }

    public String cadastrar(DadosAluno dados){
        var alunoExistente = repository.findByCpf(dados.cpf());

        if(alunoExistente.isPresent()){
            return "Aluno já existe!";
        }
        else {
            var aluno = new AlunoModel(dados.nome(), dados.email(), dados.cpf(), dados.telefone(), dados.curso());
            repository.save(aluno);
            return "Aluno cadastrado!";
        }
    }
}
