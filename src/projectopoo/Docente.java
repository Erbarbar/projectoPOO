/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

/**
 *
 * @author Filipe
 */
class Docente extends Funcionario{
    String categoria;
    String areaInvestigacao;
    
    Docente(String nome, String email, int numero, String categoria, String areaInvestigacao){
        super(nome, email, numero);
        this.categoria = categoria;
        this.areaInvestigacao = areaInvestigacao;
    }
}
