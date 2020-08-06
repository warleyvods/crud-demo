package com.example.demo.api.service;

import com.example.demo.api.entity.Pessoa;
import com.example.demo.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoaPorId(Long id) {
        pessoaRepository.delete(id);
    }

    public Pessoa buscarPessoaPorId(Long id) {
        return pessoaRepository.findOne(id);
    }

    public void deletarTudo() {
        List<Pessoa> lista = pessoaRepository.findAll();

        for (Pessoa pessoa : lista) {
            pessoaRepository.delete(pessoa.getId());
        }
    }


    public void deletarPessoaCpf(Long id, String cpf) {
        pessoaRepository.deletePessoaByIdOrCpf(id, cpf);
    }

    public void deletarPessoaPorCpf(String string) {
        pessoaRepository.deletePessoaByCpf(string);
    }




}
