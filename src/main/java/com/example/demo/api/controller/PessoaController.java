package com.example.demo.api.controller;

import com.example.demo.api.entity.Pessoa;
import com.example.demo.api.repository.PessoaRepository;
import com.example.demo.api.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;
    private final PessoaService pessoaService;

    public PessoaController(PessoaRepository pessoaRepository, PessoaService pessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaService = pessoaService;
    }

    @GetMapping("/all")
    public List<Pessoa> listAll() {
        return pessoaService.findAll();
    }

    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

    @GetMapping("{id}")
    public Pessoa findById(@PathVariable Long id) {
        return pessoaService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        pessoaService.delete(id);
    }

}
