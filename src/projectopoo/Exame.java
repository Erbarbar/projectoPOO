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
        
        System.out.println("Exame criado");
        System.out.println(toString());
    }
    
    void addSala(Sala novaSala){
        if(!novaSala.addExame(this)){
            return;
        }
        this.salas.add(novaSala);
        
        System.out.println("Sala adicionada ao exame " + toString());
        System.out.println(novaSala.toString());
    }
    
    void addDocenteREsponsavel(Docente docente){
        this.docenteResponsavel = docente;
        
        System.out.println("Docente adicionado ao exame " + toString());
        System.out.println(docente.toString());
    }
    
    void addVigilanteDocentes(Docente docente){
        this.listaVigilantesDocentes.add(docente);
        
        System.out.println("Docente Vigilante adicionado ao exame " + toString());
        System.out.println(docente.toString());
    }
    
    void addVigilanteNaoDocentes(NaoDocente naoDocente){
        this.listaVigilantesNaoDocentes.add(naoDocente);
        
        System.out.println("Nao docente Vigilante adicionado ao exame " + toString());
        System.out.println(naoDocente.toString());
    }
    
    void changeData(Data data){
        this.data = data;
        
        System.out.println("Nova data do exame " + toString());
        System.out.println(data.toString());
    }
    @Override
    public String toString() {
        return "Exame{" + "disciplina=" + disciplina + ", salas=" + salas + ", docenteResponsavel=" + docenteResponsavel + ", listaVigilantesDocentes=" + listaVigilantesDocentes + ", listaVigilantesNaoDocentes=" + listaVigilantesNaoDocentes + '}';
    }
}
