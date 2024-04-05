package br.com.vainaweb.escolat3.model;

import br.com.vainaweb.escolat3.enums.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_alunos")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    @Email
    private String email;

    @Column(unique = true)
    @CPF
    private String cpf;

    private String telefone;

    private Curso curso;

    @Embedded
    private Endereco endereco;


    public AlunoModel(String nome, String email, String cpf, String telefone, Curso curso) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.curso = curso;
    }
}
