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
class NaoDocente extends Funcionario{
    String categoria;
    String cargo;
    
    
    
    NaoDocente(String nome, String email, int numero, String categoria, String cargo){
        super(nome, email, numero);
        this.categoria = categoria;
        this.cargo = cargo;
    }
}
