package br.com.letscode.dbletscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Disciplina {

    @Id
    @Column(name = "codigo_disciplina")
    private String codigoDisciplina;
    private int chpratica;
    private int chteorica;
    @Column(name = "nome_disciplina")
    private String nomeDisciplina;
}
