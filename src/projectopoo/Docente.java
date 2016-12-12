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
class Docente extends Funcionario{
    String categoria;
    String areaInvestigacao;
    
    List<Exame> exames;
    List<Disciplina> disciplinas;
    
    Docente(String nome, String email, int numero, String categoria, String areaInvestigacao){
        super(nome, email, numero);
        this.categoria = categoria;
        this.areaInvestigacao = areaInvestigacao;
        exames = new ArrayList<>();
        disciplinas = new ArrayList<>();
    }
    
    void addDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
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
        System.out.println("Atribuido o exame de " + exame.disciplina.nome + " ao docente " + this.nome);
        return true;
    }

}
