/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Filipe
 */
class Curso implements Serializable{
    String nome;
    int duracao;
    String grau;
    
    List<Disciplina> disciplinas;
    
    Curso (String nome, int duracao, String grau){
        this.nome = nome;
        this.duracao = duracao;
        this.grau = grau;
    }
    
    void addDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }

    @Override
    public String toString() {
        return "Curso{" + "nome=" + nome + ", duracao=" + duracao + ", grau=" + grau + ", disciplinas=" + disciplinas + '}';
    }
}