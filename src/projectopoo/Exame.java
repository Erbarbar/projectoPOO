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
class Exame implements Serializable{
    
    Disciplina disciplina;
    Data data;
    List<Sala> salas;
    
    
    Docente docenteResponsavel;
    List<Docente> listaVigilantesDocentes;
    List<NaoDocente> listaVigilantesNaoDocentes;
    
    

    public Exame(Disciplina disciplina) {
        this.disciplina = disciplina;
        
        this.salas = new ArrayList<>();
        this.listaVigilantesDocentes = new ArrayList<>();
        this.listaVigilantesNaoDocentes = new ArrayList<>();
        
        System.out.println("Exame de " + disciplina.nome + " criado"); System.out.println();
    }
    
    void addSala(Sala novaSala){
        if(novaSala.addExame(this)){
            this.salas.add(novaSala);
            System.out.println("Sala " + novaSala.numeroSala + " adicionada ao exame de" + disciplina.nome);System.out.println();
        }
        
        
    }
    
    void addDocenteResponsavel(Docente docente){
        this.docenteResponsavel = docente;
        
        System.out.println("Docente "+ docente.nome +" adicionado ao exame de " + disciplina.nome);System.out.println();
    }
    
    void addVigilanteDocentes(Docente docente){
        if(docente.addExame(this)){
            this.listaVigilantesDocentes.add(docente);
            System.out.println("Docente Vigilante " + docente.nome + " adicionado ao exame de" + disciplina.nome);System.out.println();
        }
    }
    
    void addVigilanteNaoDocentes(NaoDocente naoDocente){
        naoDocente.addExame(this);
        this.listaVigilantesNaoDocentes.add(naoDocente);
        
        System.out.println("Nao docente Vigilante " + naoDocente.nome + " adicionado ao exame " + disciplina.nome);System.out.println();
    }
    
    void changeData(Data data){
        this.data = data;
        
        System.out.println("Nova data do exame de " + disciplina.nome);
        System.out.println(data.toString());System.out.println();
    }
    @Override
    public String toString() {
        return "Exame{" + "disciplina=" + disciplina + ", salas=" + salas + ", docenteResponsavel=" + docenteResponsavel + ", listaVigilantesDocentes=" + listaVigilantesDocentes + ", listaVigilantesNaoDocentes=" + listaVigilantesNaoDocentes + '}';
    }
}
