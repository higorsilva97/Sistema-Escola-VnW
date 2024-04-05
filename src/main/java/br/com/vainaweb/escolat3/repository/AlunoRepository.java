package br.com.vainaweb.escolat3.repository;

import br.com.vainaweb.escolat3.model.AlunoModel;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository <AlunoModel, Long> {
    Optional<AlunoModel> findByCpf(String cpf);

}
