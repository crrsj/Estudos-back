package br.com.oracle.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oracle.entidade.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
