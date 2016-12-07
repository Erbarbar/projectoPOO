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
class Funcionario extends Pessoa{
    int numeroMecanografico;
    
    Funcionario(String nome, String email, int numero){
        super(nome,email);
        this.numeroMecanografico = numero;
    }
}
