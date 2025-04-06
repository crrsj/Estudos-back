package br.com.oracle.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oracle.entidade.Tarefa;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long>{

}
