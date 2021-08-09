package br.com.letscode.dbletscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "aluno")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Aluno {

    @Id
    private int ra;
    private String  nome;
    private String sobrenome;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")
    private Curso codigoCurso;
}
