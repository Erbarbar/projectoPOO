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
public class Notas implements Serializable{
    Aluno aluno;
    float classificacao;
    Exame exame;

    public Notas(Aluno aluno, float classificacao, Exame exame) {
        this.aluno = aluno;
        this.classificacao = classificacao;
        this.exame = exame;
    }
    
    
}
