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
 * Classe principal
 */
public class ProjectoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Disciplina D1 = new Disciplina("Disciplina1");
        Sala S1 = new Sala("Dei", "G4.3",5);
        
        
        
        
        Exame ex = new Exame(D1);
        ex.addSala(S1);
        System.out.println(ex.toString());
        
    }
    
}
