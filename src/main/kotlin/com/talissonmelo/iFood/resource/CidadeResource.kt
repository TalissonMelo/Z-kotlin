package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Cidade
import com.talissonmelo.iFood.service.CidadeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/cidades"])
class CidadeResource {

    @Autowired
    lateinit var service: CidadeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Cidade> {
        return service.listarCidades();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody cidade: Cidade) : ResponseEntity<Cidade> {
        var novaCidade: Cidade = service.cadastrarCidade(cidade);
        return ResponseEntity.ok().body(novaCidade);
    }

    @GetMapping(value = ["/nome-cidade"])
    fun buscarCidadesNome(nome: String) : ResponseEntity<List<Cidade>> {
        var cidades: List<Cidade> = service.buscarCidadesNome(nome);
        return ResponseEntity.ok().body(cidades);
    }

    @GetMapping(value = ["/cidade"])
    fun buscarCidade(nome: String): ResponseEntity<Cidade> {
        var cidade: Cidade =  service.buscarCidadeNome(nome);
        return ResponseEntity.ok().body(cidade);
    }
}