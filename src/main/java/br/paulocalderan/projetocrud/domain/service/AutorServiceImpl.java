package br.paulocalderan.projetocrud.domain.service;

import br.paulocalderan.projetocrud.domain.request.AutorRequest;
import br.paulocalderan.projetocrud.domain.entity.Autor;
import br.paulocalderan.projetocrud.domain.repository.AutorRepository;
import br.paulocalderan.projetocrud.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor salvar(AutorRequest request) {
        Autor autor = new Autor();
        autor.setName(request.getName());
        autorRepository.save(autor);
        return autor;
    }

    @Override
    public void update(Long id, AutorRequest request) {
        autorRepository
                .findById(id)
                .map(autor -> {
                    autor.setName(request.getName());
                    return autorRepository.save(autor);
                }).orElseThrow(() -> new ApiException(
                        "Autor não encontrado."));
    }


    @Override
    public void delete(Long id) {
        autorRepository
                .findById(id)
                .map(autor -> {
                    autorRepository.delete(autor);
                    return autor;
                }).orElseThrow(() -> new ApiException(
                        "Autor não encontrado."));
    }

    @Override
    public Optional<Autor> obterAutor(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
}
