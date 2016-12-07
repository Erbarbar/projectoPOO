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
class Disciplina{
    String nome;
    
    private Docente docenteResponsavel;
    private List<Docente> outrosDocentes;
    private List<Aluno> alunos;
    
    Disciplina(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", docenteResponsavel=" + docenteResponsavel + ", outrosDocentes=" + outrosDocentes + ", alunos=" + alunos + '}';
    }
    
}
