package me.dio.academiadigital.service.impl;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaForm;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.repository.AvaliacaoFisicaRepository;
import me.dio.academiadigital.service.IAvaliacaoFisicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository repositoryAvaliacaoFisica;

    private final AlunoRepository repositoryAluno;

    public AvaliacaoFisicaServiceImpl(AvaliacaoFisicaRepository repositoryAvaliacaoFisica, AlunoRepository repositoryAluno) {
        this.repositoryAvaliacaoFisica = repositoryAvaliacaoFisica;
        this.repositoryAluno = repositoryAluno;
    }

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = repositoryAluno.findById(form.getAlunoId()).orElseThrow();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return repositoryAvaliacaoFisica.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return null;
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}