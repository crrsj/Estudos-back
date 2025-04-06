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

import br.com.oracle.dto.AtualizarCat;
import br.com.oracle.dto.CriarCategoriaDto;
import br.com.oracle.entidade.Categoria;
import br.com.oracle.servico.CategoriaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoriaControle {

	
	private final CategoriaServico categoriaServico;
	
	@PostMapping
	public ResponseEntity<Categoria>criarCategoria(@RequestBody CriarCategoriaDto criarCategoriaDto){
		var criar = categoriaServico.criarCategoria(criarCategoriaDto);
		return new ResponseEntity<>(criar,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>>listarCategorias(){
		var listar = categoriaServico.listarCategorias();
		return new ResponseEntity<>(listar,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>buscarPorId(@PathVariable Long id){
		var buscar = categoriaServico.buscarPorId(id);
		return new ResponseEntity<>(buscar, HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<Categoria>atualizarCategoria(@RequestBody AtualizarCat atualizarDto){
		var atualizar = categoriaServico.atualizarCategoria(atualizarDto);
		return new ResponseEntity<>(atualizar,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluirCategoria(@PathVariable Long id){
	  categoriaServico.excluirCategoria(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
