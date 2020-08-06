package com.example.demo.api.repository;


import com.example.demo.api.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public void deletePessoaByIdOrCpf(Long id, String cpf);

    public void deletePessoaByCpf(String s);

    public List<Pessoa> findPessoaByNome(@Param("nome") String nome);

}
