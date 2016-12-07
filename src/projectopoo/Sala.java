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
class Sala{
    private String departamento;
    private String numeroSala;
    private int numeroLugares;
    
    private List<Exame> exames;
    
    Sala(String departamento, String numeroSala,int numeroLugares){
        this.departamento = departamento;
        this.numeroSala = numeroSala;
        this.numeroLugares = numeroLugares;
    }

    
    void addExame(Exame exame){
        this.exames.add(exame);
    }
    
    
    @Override
    public String toString() {
        return "Sala{" + "departamento=" + departamento + ", numeroSala=" + numeroSala + ", numeroLugares=" + numeroLugares + ", exames=" + exames + '}';
    }
}
