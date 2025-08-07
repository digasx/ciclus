package br.org.ule.ciclus.mapper;

import br.org.ule.ciclus.dto.AlunoRequestDto;
import br.org.ule.ciclus.dto.AlunoResponseDto;
import br.org.ule.ciclus.entity.Aluno;
import br.org.ule.ciclus.entity.Monitor;

public class AlunoMapper {

    //De dto para Entidade
    public static Aluno toEntity(AlunoRequestDto dto, Monitor monitor){
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setTurma(dto.getTurma());
        aluno.setMonitor(monitor);
        return aluno;
    }

    //De Entidade para dto
    public static AlunoResponseDto toDto(Aluno aluno) {
        return new AlunoResponseDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getTurma(),
                aluno.getMonitor().getId(),
                aluno.getMonitor().getNome()
        );
    }

}
