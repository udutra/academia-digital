package me.dio.academiadigital.service.impl;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AlunoForm;
import me.dio.academiadigital.entity.form.AlunoUpdateForm;
import me.dio.academiadigital.infra.utils.JavaTimeUtils;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.service.IAlunoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class AlunoServiceImpl implements IAlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

        if(dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        return repository.findById(id).orElseThrow().getAvaliacoes();
    }
}
