package br.com.oracle.entidade;

import br.com.oracle.enums.DiaSemana;
import br.com.oracle.enums.StatusTarefa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_tarefas")
@Data
@NoArgsConstructor
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private DiaSemana diaSemana;
	private String descricao;
	private StatusTarefa status;	
	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoria;
	
	

}
