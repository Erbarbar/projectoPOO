/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.util.List;

/**
 *
 * @author Filipe
 */
class Aluno extends Pessoa{
    int numeroAluno;
    Curso curso;
    int anoMatriculacurso;
    String regime;
    List<Disciplina> listaDisciplinaNotas;
    
    Aluno(String nome, String email, int numero, Curso curso, int ano, String regime, List<Disciplina> disciplina){
        super(nome,email);
        this.numeroAluno = numero;
        this.curso = curso;
        this.anoMatriculacurso = ano;
        this.regime = regime;
        this.listaDisciplinaNotas = disciplina;
    }
    
    void addDisciplinas(Disciplina disciplina){
        listaDisciplinaNotas.add(disciplina);
    }
    
}
