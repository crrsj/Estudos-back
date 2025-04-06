package br.com.oracle.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.oracle.dto.AtualizarCat;
import br.com.oracle.dto.CriarCategoriaDto;
import br.com.oracle.entidade.Categoria;
import br.com.oracle.repositorio.CategoriaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServico {
	
	private final CategoriaRepositorio categoriaRepositorio;
	private final ModelMapper modelMapper;

	public Categoria criarCategoria(CriarCategoriaDto criarCategoriaDto) {
		return categoriaRepositorio.save(modelMapper.map(criarCategoriaDto,Categoria.class));
	}
	
	public List<Categoria>listarCategorias(){
		return categoriaRepositorio.findAll()
				.stream().map(listar -> modelMapper
				.map(listar, Categoria.class))
				.collect(Collectors.toList());
	}
	
	public Categoria buscarPorId(Long id) {
		Optional<Categoria>buscar = categoriaRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	public Categoria atualizarCategoria(AtualizarCat atualizarCat) {
		return categoriaRepositorio.save(modelMapper.map(atualizarCat, Categoria.class));
	}
	
	public void excluirCategoria(Long id) {
		buscarPorId(id);
		categoriaRepositorio.deleteById(id);
	}
	
}
