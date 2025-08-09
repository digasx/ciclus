package br.org.ule.ciclus.mapper;

import br.org.ule.ciclus.dto.AlunoRequestDto;
import br.org.ule.ciclus.dto.AlunoResponseDto;
import br.org.ule.ciclus.entity.Aluno;
import br.org.ule.ciclus.entity.Monitor;
import br.org.ule.ciclus.entity.Turma;
import br.org.ule.ciclus.error.ResourceNotFoundException;

public class AlunoMapper {

    //De dto para Entidade
    public static Aluno toEntity(AlunoRequestDto dto,  Monitor monitor) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setTurma(Turma.deString(dto.getTurma()));
        aluno.setMonitor(monitor);

        return aluno;
    }

    //De Entidade para dto
    public static AlunoResponseDto toDto(Aluno aluno) {
        return new AlunoResponseDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTurma().name(),
                aluno.getMonitor() != null ? aluno.getMonitor().getId() : null,
                aluno.getMonitor() != null ? aluno.getMonitor().getNome() : null
        );
    }

}
