package br.paulocalderan.projetocrud.domain.repository;

import br.paulocalderan.projetocrud.domain.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByNameLike(String name);

}