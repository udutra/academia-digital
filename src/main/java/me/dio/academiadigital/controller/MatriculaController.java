package me.dio.academiadigital.controller;

import jakarta.validation.Valid;
import me.dio.academiadigital.entity.Matricula;
import me.dio.academiadigital.entity.form.MatriculaForm;
import me.dio.academiadigital.service.impl.MatriculaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaServiceImpl service;

    public MatriculaController(MatriculaServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

}