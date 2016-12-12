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
class Sala  implements Serializable{
    private String departamento;
    String numeroSala;
    private int numeroLugares;
    
    private List<Exame> exames;
    
    Sala(String departamento, String numeroSala,int numeroLugares){
        this.departamento = departamento;
        this.numeroSala = numeroSala;
        this.numeroLugares = numeroLugares;
        this.exames = new ArrayList<>();
    }

    
    Boolean addExame(Exame exame){
        for(Exame ex : exames){
            //mesmo dia
            if(exame.data.ano == ex.data.ano && 
               exame.data.mes == ex.data.mes && 
               exame.data.dia == ex.data.dia)
                //interseccao de horario
                if((exame.data.horaInicio  >= ex.data.horaInicio &&
                    exame.data.horaInicio  <= ex.data.horaFim ) 
                    ||
                    exame.data.horaFim  <= ex.data.horaFim &&
                    exame.data.horaFim  >= ex.data.horaInicio ){
                    System.out.println("Exame em sobreposicao com o de " + ex.disciplina);
                    return false;
                }
        }
        this.exames.add(exame);
        
        System.out.println("Alocado exame " + exame.disciplina.nome + " a sala " + this.numeroSala);System.out.println();
        return true;
    }
    
}
