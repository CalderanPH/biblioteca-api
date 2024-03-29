package br.paulocalderan.projetocrud.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Campo nome não pode estar vazio.")
    private String name;

    public Editora(String name) {
        this.name = name;
    }

    public Editora(Long id) {
        this.id = id;
    }

}