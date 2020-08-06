package com.example.demo.api.controller;

import com.example.demo.api.entity.Pessoa;
import com.example.demo.api.repository.PessoaRepository;
import com.example.demo.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/all")
    public List<Pessoa> listarPessoa() {
        return pessoaService.listarPessoas();
    }

    @PostMapping("/salvar")
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.salvarPessoa(pessoa);
    }

    @GetMapping("/buscarPorId/{id}")
    public Pessoa buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscarPessoaPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPessoaPorId(@PathVariable Long id) {
        pessoaService.deletarPessoaPorId(id);
    }

    @GetMapping("/deletarTudo")
    public void deletarTudo() {
        pessoaService.deletarTudo();
    }

    @Transactional
    @DeleteMapping("/deletarPessoa/{id}/{cpf}")
    public void deletarPessoaPorCpfOuId(@PathVariable Long id, @PathVariable String cpf) {
        pessoaService.deletarPessoaCpf(id, cpf);
    }

    @Transactional
    @DeleteMapping("/deletarPessoaPorCpf/{cpf}")
    public void deletarPessoaPorCpf(@PathVariable String cpf) {
        pessoaService.deletarPessoaPorCpf(cpf);
    }

    @GetMapping("/buscarPessoaPorNome/{nome}")
    public List<Pessoa> buscarPessoaPorNome(@PathVariable String nome) {
        return pessoaRepository.findPessoaByNome(nome);
    }


}
