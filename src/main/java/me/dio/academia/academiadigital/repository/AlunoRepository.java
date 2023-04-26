package me.dio.academia.academiadigital.repository;

import me.dio.academia.academiadigital.entity.Aluno;
import me.dio.academia.academiadigital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    /**
     *
     * @param dataDeNascimento: data de nascimento dos alunos
     * @return lista com todos os alunos com a data de nascimento passada como parâmetro da função
     */
    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
}