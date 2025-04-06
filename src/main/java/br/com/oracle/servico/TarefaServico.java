package br.com.oracle.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.oracle.dto.AtualizarTarefaDto;
import br.com.oracle.dto.CriarTarefaDto;
import br.com.oracle.entidade.Tarefa;
import br.com.oracle.repositorio.CategoriaRepositorio;
import br.com.oracle.repositorio.TarefaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaServico {
	
	private final TarefaRepositorio tarefaRepositorio;
	private final CategoriaRepositorio categoriaRepositorio;
	private final ModelMapper modelMapper;
	
	public Tarefa criarTarefa(CriarTarefaDto criarTarefaDto,Long categoriaId) {
		var categoria = categoriaRepositorio.findById(categoriaId).orElseThrow();	
		var criar = modelMapper.map(criarTarefaDto, Tarefa.class);
		criar.setCategoria(categoria);		
		return tarefaRepositorio.save(criar);
	}

	public List<Tarefa> listarTarefas() {
		return tarefaRepositorio.findAll()
				.stream().map(listar -> modelMapper
				.map(listar,Tarefa.class))
				.collect(Collectors.toList());
	}
	
	public Tarefa buscarPorId(Long id) {
		Optional<Tarefa>buscar = tarefaRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	public Tarefa atualizarTarefa(AtualizarTarefaDto atualizarTarefaDto) {
		return tarefaRepositorio.save(modelMapper.map(atualizarTarefaDto, Tarefa.class));
	}
	
	public void excluirTarefa(Long id) {
		buscarPorId(id);
		tarefaRepositorio.deleteById(id);
	}
}
