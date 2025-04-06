package br.com.oracle.dto;

import br.com.oracle.entidade.Categoria;
import br.com.oracle.enums.DiaSemana;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriarTarefaDto {

	private String titulo;
	private DiaSemana diaSemana;
	private String descricao;
	private String status;
	private Long categoriaId;
	private Categoria categoria;
}
