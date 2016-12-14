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
public class ExameRecurso extends Exame implements Serializable{
     List<Notas> notas;

    public ExameRecurso(Disciplina disciplina) {
        super(disciplina);
        this.notas = new ArrayList<>();
    }
}
