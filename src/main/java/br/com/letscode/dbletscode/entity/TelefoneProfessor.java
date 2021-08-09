package br.com.letscode.dbletscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefone_professor")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TelefoneProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    @ManyToOne
    @JoinColumn(name = "registro_professor", referencedColumnName = "registro_professor")
    private Professor registroProfessor;
}
