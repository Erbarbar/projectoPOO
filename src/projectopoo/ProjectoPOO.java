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
        
        Curso curso = new Curso("Lei", 3, "Licenciatura");
        
        // Cria disciplinas
        List<Disciplina> disciplinas = new ArrayList<>();
        Disciplina disciplina_1 = new Disciplina("Disciplina_1"); disciplinas.add(disciplina_1);
        Disciplina disciplina_2 = new Disciplina("Disciplina_2"); disciplinas.add(disciplina_2);
        Disciplina disciplina_3 = new Disciplina("Disciplina_3"); disciplinas.add(disciplina_3);
        Disciplina disciplina_4 = new Disciplina("Disciplina_4"); disciplinas.add(disciplina_4);
        Disciplina disciplina_5 = new Disciplina("Disciplina_5"); disciplinas.add(disciplina_5);
        
        // cria salas de aulas (String departamento, String numeroSala,int numeroLugares)
        Sala sala_1 = new Sala("Dei", "Sala_1",20);
        Sala sala_2 = new Sala("Dei", "Sala_2",20);
        Sala sala_3 = new Sala("Dei", "Sala_3",20);
        Sala sala_4 = new Sala("Dei", "Sala_4",20);
        Sala sala_5 = new Sala("Dei", "Sala_5",20);
        
        // cria alunos (String nome, String email, int numero, Curso curso, int ano, String regime, List<Disciplina> disciplina)
        Aluno aluno_1 = new Aluno("Aluno_1", "1@aluno.com", 1, curso, 2, "normal", disciplinas);
        Aluno aluno_2 = new Aluno("Aluno_2", "2@aluno.com", 2, curso, 2, "normal", disciplinas);
        Aluno aluno_3 = new Aluno("Aluno_3", "3@aluno.com", 3, curso, 2, "normal", disciplinas);
        Aluno aluno_4 = new Aluno("Aluno_4", "4@aluno.com", 4, curso, 2, "normal", disciplinas);
        Aluno aluno_5 = new Aluno("Aluno_5", "5@aluno.com", 5, curso, 2, "normal", disciplinas);
        
        //cria docentes (String nome, String email, int numero, String categoria, String areaInvestigacao)
        Docente docente_1 = new Docente("Docente_1", "1@Docente.com", 1, "associado", "engenharia de software");
        Docente docente_2 = new Docente("Docente_2", "2@Docente.com", 2, "associado", "engenharia de software");
        Docente docente_3 = new Docente("Docente_3", "3@Docente.com", 3, "associado", "engenharia de software");
        Docente docente_4 = new Docente("Docente_4", "4@Docente.com", 4, "associado", "engenharia de software");
        Docente docente_5 = new Docente("Docente_5", "5@Docente.com", 5, "associado", "engenharia de software");
        
        // atribuir docentes a disciplinas
        disciplina_1.addDocenteResponsavel(docente_1); disciplina_1.addOutroDocente(docente_2);
        disciplina_2.addDocenteResponsavel(docente_2); disciplina_1.addOutroDocente(docente_3);
        disciplina_3.addDocenteResponsavel(docente_3); disciplina_1.addOutroDocente(docente_4);
        disciplina_4.addDocenteResponsavel(docente_4); disciplina_1.addOutroDocente(docente_5);
        disciplina_5.addDocenteResponsavel(docente_5); disciplina_1.addOutroDocente(docente_1);
        
        // criar algumas datas   (int ano, int mes, int dia, int horaInicio, int horaFim)
        Data uma = new Data(2017,1,1,13,14);
        Data duas = new Data(2017,1,1,14,15);
        Data tres = new Data(2017,1,1,15,16);
        Data quatro = new Data(2017,1,1,16,17);
        Data cinco = new Data(2017,1,1,17,18);
        
        // adicionar exames a disciplinas
        disciplina_1.addExame(uma, sala_1);
        disciplina_2.addExame(duas, sala_2);
        disciplina_3.addExame(tres, sala_3);
        disciplina_4.addExame(quatro, sala_4);
        disciplina_5.addExame(cinco, sala_5);
        
    }
    
}
