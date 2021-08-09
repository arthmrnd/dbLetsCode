package br.com.letscode.dbletscode.entity;

import br.com.letscode.dbletscode.enums.Modalidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Curso {

    @Id
    @Column(name = "codigo_curso")
    private int codigoCurso;
    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;
    private int duracao;
    @Column(name = "numero_alunos")
    private int numeroAlunos;
    @Column(name = "nome_curso")
    private String nomeCurso;
}
