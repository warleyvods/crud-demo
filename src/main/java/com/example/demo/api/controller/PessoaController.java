package com.example.demo.api.controller;

import com.example.demo.api.entity.Pessoa;
import com.example.demo.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

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


}
