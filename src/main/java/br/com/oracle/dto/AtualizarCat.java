package br.com.oracle.dto;

import java.util.List;

import br.com.oracle.entidade.Tarefa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarCat {
	private Long id;
	private String nome;
	private List<Tarefa>tarefas;
}
