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
public class Exame {
    
    Disciplina disciplina;
    List<Sala> salas;
    
    
    Docente docenteResponsavel;
    List<Docente> listaVigilantesDocentes;
    List<NaoDocente> listaVigilantesNaoDocentes;
    
    

    public Exame(Disciplina disciplina) {
        this.disciplina = disciplina;
        
        this.salas = new ArrayList<>();
        this.listaVigilantesDocentes = new ArrayList<>();
        this.listaVigilantesNaoDocentes = new ArrayList<>();
    }
    
    void addSala(Sala novaSala){
        this.salas.add(novaSala);
    }
    
    void addDocengteREsponsavel(Docente docente){
        this.docenteResponsavel = docente;
    }
    
    void addDocentesVigilantesDocentes(List<Docente> docentes){
        this.listaVigilantesDocentes.addAll(docentes);
    }
    
    void addDocentesVigilantesNaoDocentes(List<NaoDocente> naoDocentes){
        this.listaVigilantesNaoDocentes.addAll(naoDocentes);
    }
    

    @Override
    public String toString() {
        return "Exame{" + "disciplina=" + disciplina + ", salas=" + salas + ", docenteResponsavel=" + docenteResponsavel + ", listaVigilantesDocentes=" + listaVigilantesDocentes + ", listaVigilantesNaoDocentes=" + listaVigilantesNaoDocentes + '}';
    }
}
