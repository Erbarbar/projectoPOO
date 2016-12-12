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
class NaoDocente extends Funcionario{
    String categoria;
    String cargo;
    
    List<Exame> exames;
    
    NaoDocente(String nome, String email, int numero, String categoria, String cargo){
        super(nome, email, numero);
        this.categoria = categoria;
        this.cargo = cargo;
        exames = new ArrayList<>();
    }
    
    void addExame(Exame exame){
        exames.add(exame);
        System.out.println("Atribuido o exame de " + exame.disciplina.nome + " ao nao docente " + this.nome);
    }
}
