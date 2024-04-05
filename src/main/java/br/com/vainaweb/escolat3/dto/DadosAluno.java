package br.com.vainaweb.escolat3.dto;

import br.com.vainaweb.escolat3.enums.Curso;

public record DadosAluno(String nome, String email, String cpf, String telefone, Curso curso) {


}
