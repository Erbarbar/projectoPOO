/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.util.ArrayList;
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
    private List<Exame> exames;
    
    Disciplina(String nome){
        this.nome = nome;
        this.outrosDocentes = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    void addExame(Data data, Sala sala){
        Exame ex = new Exame(this);
        ex.changeData(data);
        ex.addSala(sala);
        exames.add(ex);
    }
    
    void addDocenteResponsavel(Docente docenteResponsavel){
        this.docenteResponsavel = docenteResponsavel;
    }
    
    void addOutroDocente(Docente docente){
        this.outrosDocentes.add(docente);
    }
    
    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", docenteResponsavel=" + docenteResponsavel + ", outrosDocentes=" + outrosDocentes + ", alunos=" + alunos + '}';
    }
    
}
