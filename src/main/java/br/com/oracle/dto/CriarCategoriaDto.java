package br.com.oracle.dto;

import java.util.List;

import br.com.oracle.entidade.Tarefa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriarCategoriaDto {
	private String nomeCategoria;
	private List<Tarefa>tarefas;
}
