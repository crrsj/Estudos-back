package br.com.oracle.controle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.dto.AtualizarTarefaDto;
import br.com.oracle.dto.CriarTarefaDto;
import br.com.oracle.entidade.Tarefa;
import br.com.oracle.servico.TarefaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TarefaControle {

	private final TarefaServico tarefaServico;
	
	
	@PostMapping("/{categoriaId}")
	public ResponseEntity<Tarefa>criarTarefa(@RequestBody CriarTarefaDto criarTarefaDto,@PathVariable Long categoriaId){
		var criar = tarefaServico.criarTarefa(criarTarefaDto,categoriaId );
		return new ResponseEntity<>(criar,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Tarefa>>listarTarefas(){
		var listar = tarefaServico.listarTarefas();
		return new ResponseEntity<>(listar,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa>buscarPorId(@PathVariable Long id){
		var buscar = tarefaServico.buscarPorId(id);
		return new ResponseEntity<>(buscar,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Tarefa>atualizarTarefa(@RequestBody AtualizarTarefaDto atualizarTarefaDto){
		var atualizar = tarefaServico.atualizarTarefa(atualizarTarefaDto);
		return new ResponseEntity<>(atualizar,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluirTarefa(@PathVariable Long id){
		tarefaServico.excluirTarefa(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
