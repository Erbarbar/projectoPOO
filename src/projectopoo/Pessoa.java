/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.io.Serializable;

/**
 *
 * @author Filipe
 */
class Pessoa implements Serializable{
    String nome;
    String email;
    
    Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
}
