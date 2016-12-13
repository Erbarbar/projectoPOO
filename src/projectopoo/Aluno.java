/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
class Aluno extends Pessoa implements Serializable{
    int numeroAluno;
    Curso curso;
    int anoMatriculacurso;
    String regime;
    List<Disciplina> listaDisciplinaNotas;
    List<Notas> notas;
    
    Aluno(String nome, String email, int numero, Curso curso, int ano, String regime){
        super(nome,email);
        this.numeroAluno = numero;
        this.curso = curso;
        this.anoMatriculacurso = ano;
        this.regime = regime;
        this.listaDisciplinaNotas = new ArrayList<>();
        this.notas = new ArrayList<>();
    }
    
    void addDisciplinas(Disciplina disciplina){
        listaDisciplinaNotas.add(disciplina);
    }

    @Override
    public String toString() {
        return "Aluno{" + "numeroAluno=" + numeroAluno + ", curso=" + curso + ", anoMatriculacurso=" + anoMatriculacurso + ", regime=" + regime + ", listaDisciplinaNotas=" + listaDisciplinaNotas + '}';
    }
    
}
