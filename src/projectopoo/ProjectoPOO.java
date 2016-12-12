/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.io.*;
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
        
        List<Aluno> alunosList = new ArrayList<>();
        List<Curso> cursosList = new ArrayList<>();
        List<Data> datasList = new ArrayList<>();
        List<Disciplina> disciplinasList = new ArrayList<>();
        List<Docente> docentesList = new ArrayList<>();
        List<ExameEspecial> examesEspeciaisList = new ArrayList<>();
        List<ExameNormal> examesNormaisList = new ArrayList<>();
        List<ExameRecurso> examesRecursoList = new ArrayList<>();
        List<NaoDocente> naoDocentesList = new ArrayList<>();
        List<Sala> salasList = new ArrayList<>();
        
        
        
        loadData(alunosList, cursosList, datasList, disciplinasList, 
                docentesList, examesEspeciaisList, examesNormaisList, 
                examesRecursoList, naoDocentesList, salasList);
        
        
        
        saveData(alunosList, cursosList, datasList, disciplinasList, 
                docentesList, examesEspeciaisList, examesNormaisList, 
                examesRecursoList, naoDocentesList, salasList);
        
    }
    
    static void loadData(List<Aluno> alunosList, List<Curso> cursosList, List<Data> datasList, List<Disciplina> disciplinasList, 
                         List<Docente> docentesList, List<ExameEspecial> examesEspeciaisList,
                         List<ExameNormal> examesNormaisList, List<ExameRecurso> examesRecursoList,
                         List<NaoDocente> naoDocentesList, List<Sala> salasList){
        
        
        loadCursos(cursosList);
        loadDisciplinas(disciplinasList);
        loadAlunos(alunosList,cursosList.get(0),disciplinasList);
        
        
        
        // cria salas de aulas (String departamento, String numeroSala,int numeroLugares)
        Sala sala_1 = new Sala("Dei", "Sala_1",20); salasList.add(sala_1);
        Sala sala_2 = new Sala("Dei", "Sala_2",20); salasList.add(sala_2);
        Sala sala_3 = new Sala("Dei", "Sala_3",20); salasList.add(sala_3);
        Sala sala_4 = new Sala("Dei", "Sala_4",20); salasList.add(sala_4);
        Sala sala_5 = new Sala("Dei", "Sala_5",20); salasList.add(sala_5);
        
  
        //cria docentes (String nome, String email, int numero, String categoria, String areaInvestigacao)
        Docente docente_1 = new Docente("Docente_1", "1@Docente.com", 1, "associado", "engenharia de software"); docentesList.add(docente_1);
        Docente docente_2 = new Docente("Docente_2", "2@Docente.com", 2, "associado", "engenharia de software"); docentesList.add(docente_2);
        Docente docente_3 = new Docente("Docente_3", "3@Docente.com", 3, "associado", "engenharia de software"); docentesList.add(docente_3);
        Docente docente_4 = new Docente("Docente_4", "4@Docente.com", 4, "associado", "engenharia de software"); docentesList.add(docente_4);
        Docente docente_5 = new Docente("Docente_5", "5@Docente.com", 5, "associado", "engenharia de software"); docentesList.add(docente_5);
        
        // atribuir docentes a disciplinas
        disciplinasList.get(0).addDocenteResponsavel(docente_1); disciplinasList.get(0).addOutroDocente(docente_2);
        disciplinasList.get(1).addDocenteResponsavel(docente_2); disciplinasList.get(1).addOutroDocente(docente_3);
        disciplinasList.get(2).addDocenteResponsavel(docente_3); disciplinasList.get(2).addOutroDocente(docente_4);
        disciplinasList.get(3).addDocenteResponsavel(docente_4); disciplinasList.get(3).addOutroDocente(docente_5);
        disciplinasList.get(4).addDocenteResponsavel(docente_5); disciplinasList.get(4).addOutroDocente(docente_1);
        
        // criar algumas datas   (int ano, int mes, int dia, int horaInicio, int horaFim)
        Data uma = new Data(2017,1,1,13,14); datasList.add(uma);
        Data duas = new Data(2017,1,1,14,15);datasList.add(duas);
        Data tres = new Data(2017,1,1,15,16);datasList.add(tres);
        Data quatro = new Data(2017,1,1,16,17);datasList.add(quatro);
        Data cinco = new Data(2017,1,1,17,18);datasList.add(cinco);
        
        // adicionar exames a disciplinas
        disciplinasList.get(0).addExame(uma, sala_1);
        disciplinasList.get(1).addExame(duas, sala_2);
        disciplinasList.get(2).addExame(tres, sala_3);
        disciplinasList.get(3).addExame(quatro, sala_4);
        disciplinasList.get(4).addExame(cinco, sala_5);
    }
    
    static void loadAlunos(List<Aluno> alunos, Curso curso, List<Disciplina> disciplinasList){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Alunos.bin"));
            alunos = (List<Aluno>)ois.readObject();
            ois.close();
        }catch(IOException e){
            System.out.println(e);
            
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Alunos.bin"));
                
                alunos = new ArrayList<>();
                Aluno aluno_1 = new Aluno("Aluno_1", "1@aluno.com", 1, curso, 2, "normal", disciplinasList); alunos.add(aluno_1);
                Aluno aluno_2 = new Aluno("Aluno_2", "2@aluno.com", 2, curso, 2, "normal", disciplinasList); alunos.add(aluno_2);
                Aluno aluno_3 = new Aluno("Aluno_3", "3@aluno.com", 3, curso, 2, "normal", disciplinasList); alunos.add(aluno_3);
                Aluno aluno_4 = new Aluno("Aluno_4", "4@aluno.com", 4, curso, 2, "normal", disciplinasList); alunos.add(aluno_4);
                Aluno aluno_5 = new Aluno("Aluno_5", "5@aluno.com", 5, curso, 2, "normal", disciplinasList); alunos.add(aluno_5);
        
        
                oos.writeObject(alunos);
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    static void loadCursos(List<Curso> cursos){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cursos.bin"));
            cursos = (List<Curso>)ois.readObject();
            ois.close();
        }catch(IOException e){
            System.out.println(e);
            
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cursos.bin"));
                cursos = new ArrayList<>();
                Curso curso_1 = new Curso("LEI", 3, "Licenciatura"); cursos.add(curso_1);
                Curso curso_2 = new Curso("MEI", 2, "Mestrado");     cursos.add(curso_2);
                Curso curso_3 = new Curso("LDM", 3, "Licenciatura"); cursos.add(curso_3);
        
                oos.writeObject(cursos);
                System.out.println("\n Criou cursos.bin \n");
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    static void loadDisciplinas(List<Disciplina> disciplinas){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Disciplinas.bin"));
            disciplinas = (List<Disciplina>)ois.readObject();
            ois.close();
        }catch(IOException e){
            System.out.println(e);
            
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Disciplinas.bin"));
                
                disciplinas = new ArrayList<>();
                // Cria disciplinasList
                Disciplina disciplina_1 = new Disciplina("Disciplina_1"); disciplinas.add(disciplina_1);
                Disciplina disciplina_2 = new Disciplina("Disciplina_2"); disciplinas.add(disciplina_2);
                Disciplina disciplina_3 = new Disciplina("Disciplina_3"); disciplinas.add(disciplina_3);
                Disciplina disciplina_4 = new Disciplina("Disciplina_4"); disciplinas.add(disciplina_4);
                Disciplina disciplina_5 = new Disciplina("Disciplina_5"); disciplinas.add(disciplina_5);
        
                oos.writeObject(disciplinas);
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    static void saveData(List<Aluno> alunosList, List<Curso> cursosList, List<Data> datasList, List<Disciplina> disciplinasList, 
                         List<Docente> docentesList, List<ExameEspecial> examesEspeciaisList,
                         List<ExameNormal> examesNormaisList, List<ExameRecurso> examesRecursoList,
                         List<NaoDocente> naoDocentesList, List<Sala> salasList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Alunos.bin"));
            oos.writeObject(alunosList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cursos.bin"));
            oos.writeObject(cursosList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Datas.bin"));
            oos.writeObject(datasList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Disciplinas.bin"));
            oos.writeObject(disciplinasList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Docentes.bin"));
            oos.writeObject(docentesList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesEspeciais.bin"));
            oos.writeObject(examesEspeciaisList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesNormais.bin"));
            oos.writeObject(examesNormaisList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesRecurso.bin"));
            oos.writeObject(examesRecursoList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NaoDocentes.bin"));
            oos.writeObject(naoDocentesList);
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Salas.bin"));
            oos.writeObject(salasList);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
}
