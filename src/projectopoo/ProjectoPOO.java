/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        List<Notas> notas = new ArrayList<>();
        List<Sala> salasList = new ArrayList<>();
        
        
        
        loadData(alunosList, cursosList, datasList, disciplinasList, 
                docentesList, examesEspeciaisList, examesNormaisList, 
                examesRecursoList, naoDocentesList, notas, salasList);
        
        
        
        saveData(alunosList, cursosList, datasList, disciplinasList, 
                docentesList, examesEspeciaisList, examesNormaisList, 
                examesRecursoList, naoDocentesList, notas, salasList);
        
    }
    
    static void loadData(List<Aluno> alunosList, List<Curso> cursosList, List<Data> datasList, List<Disciplina> disciplinasList, 
                         List<Docente> docentesList, List<ExameEspecial> examesEspeciaisList,
                         List<ExameNormal> examesNormaisList, List<ExameRecurso> examesRecursoList,
                         List<NaoDocente> naoDocentesList, List<Notas> notas, List<Sala> salasList){
        
        
        cursosList = loadCursos(cursosList);                        System.out.println("cursosList " + cursosList);
        disciplinasList = loadDisciplinas(disciplinasList);         System.out.println("disciplinasList " + disciplinasList);
        
        alunosList = loadAlunos(alunosList,cursosList.get(0),disciplinasList);  System.out.println("alunosList " + alunosList);
        salasList = loadSalas(salasList);                                       System.out.println("salasList " + salasList);
        docentesList = loadDocentes(docentesList);                              System.out.println("docentesList " + docentesList);
        datasList = loadDatas(datasList);                                       System.out.println("datasList " + datasList);
        
        // atribuir docentes a disciplinas
        disciplinasList.get(0).addDocenteResponsavel(docentesList.get(0)); disciplinasList.get(0).addOutroDocente(docentesList.get(1));
        disciplinasList.get(1).addDocenteResponsavel(docentesList.get(1)); disciplinasList.get(1).addOutroDocente(docentesList.get(2));
        disciplinasList.get(2).addDocenteResponsavel(docentesList.get(2)); disciplinasList.get(2).addOutroDocente(docentesList.get(3));
        disciplinasList.get(3).addDocenteResponsavel(docentesList.get(3)); disciplinasList.get(3).addOutroDocente(docentesList.get(4));
        disciplinasList.get(4).addDocenteResponsavel(docentesList.get(4)); disciplinasList.get(4).addOutroDocente(docentesList.get(0));
        
        
        // adicionar exames a disciplinas
        disciplinasList.get(0).addExame(datasList.get(0), salasList.get(0));
        disciplinasList.get(1).addExame(datasList.get(1), salasList.get(1));
        disciplinasList.get(2).addExame(datasList.get(2), salasList.get(2));
        disciplinasList.get(3).addExame(datasList.get(3), salasList.get(3));
        disciplinasList.get(4).addExame(datasList.get(4), salasList.get(4));
    }
    
    static List<Aluno> loadAlunos(List<Aluno> alunos, Curso curso, List<Disciplina> disciplinasList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Alunos.bin"))) {
                alunos = (List<Aluno>)ois.readObject();
            }
        }catch(IOException e){
            System.out.println(e);
            
            try{
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Alunos.bin"))) {
                    alunos = new ArrayList<>();
                    Aluno aluno_1 = new Aluno("Aluno_1", "1@aluno.com", 1, curso, 2, "normal", disciplinasList); alunos.add(aluno_1);
                    Aluno aluno_2 = new Aluno("Aluno_2", "2@aluno.com", 2, curso, 2, "normal", disciplinasList); alunos.add(aluno_2);
                    Aluno aluno_3 = new Aluno("Aluno_3", "3@aluno.com", 3, curso, 2, "normal", disciplinasList); alunos.add(aluno_3);
                    Aluno aluno_4 = new Aluno("Aluno_4", "4@aluno.com", 4, curso, 2, "normal", disciplinasList); alunos.add(aluno_4);
                    Aluno aluno_5 = new Aluno("Aluno_5", "5@aluno.com", 5, curso, 2, "normal", disciplinasList); alunos.add(aluno_5);
                    
                    
                    oos.writeObject(alunos);
                }
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return alunos;
    }
    
    static List<Curso> loadCursos(List<Curso> cursos){
        cursos = new ArrayList<>();
        try{
            List<Curso> aux;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cursos.bin"))) {
                aux = (List<Curso>)ois.readObject();
                cursos.addAll(aux);
            }
        }catch(IOException e){
            System.out.println(e);
            
            try{
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cursos.bin"))) {
                    Curso curso_1 = new Curso("LEI", 3, "Licenciatura"); cursos.add(curso_1);
                    Curso curso_2 = new Curso("MEI", 2, "Mestrado");     cursos.add(curso_2);
                    Curso curso_3 = new Curso("LDM", 3, "Licenciatura"); cursos.add(curso_3);
                    
                    oos.writeObject(cursos);
                    oos.close();
                }
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return cursos;
    }
    
    static List<Disciplina> loadDisciplinas(List<Disciplina> disciplinas){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Disciplinas.bin"));
            disciplinas = (List<Disciplina>)ois.readObject();
            ois.close();
        }catch(IOException e){
            System.out.println(e);
            
            try{
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Disciplinas.bin"))) {
                    disciplinas = new ArrayList<>();
                    // Cria disciplinasList
                    Disciplina disciplina_1 = new Disciplina("Disciplina_1"); disciplinas.add(disciplina_1);
                    Disciplina disciplina_2 = new Disciplina("Disciplina_2"); disciplinas.add(disciplina_2);
                    Disciplina disciplina_3 = new Disciplina("Disciplina_3"); disciplinas.add(disciplina_3);
                    Disciplina disciplina_4 = new Disciplina("Disciplina_4"); disciplinas.add(disciplina_4);
                    Disciplina disciplina_5 = new Disciplina("Disciplina_5"); disciplinas.add(disciplina_5);
                    
                    oos.writeObject(disciplinas);
                    oos.close();
                }
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return disciplinas;
    }
    
    static List<Sala> loadSalas(List<Sala> salas){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Salas.bin"))) {
                salas = (List<Sala>)ois.readObject();
            }
        }catch(IOException e){
            System.out.println(e);
            
            try{
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Salas.bin"))) {
                    salas = new ArrayList<>();
                    // cria salas de aulas (String departamento, String numeroSala,int numeroLugares)
                    Sala sala_1 = new Sala("Dei", "Sala_1",20); salas.add(sala_1);
                    Sala sala_2 = new Sala("Dei", "Sala_2",20); salas.add(sala_2);
                    Sala sala_3 = new Sala("Dei", "Sala_3",20); salas.add(sala_3);
                    Sala sala_4 = new Sala("Dei", "Sala_4",20); salas.add(sala_4);
                    Sala sala_5 = new Sala("Dei", "Sala_5",20); salas.add(sala_5);
                    
                    
                    
                    oos.writeObject(salas);
                    oos.close();
                }
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return salas;
    }
    
    static List<Docente> loadDocentes(List<Docente> docentes){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Docentes.bin"));
            docentes = (List<Docente>)ois.readObject();
            ois.close();
        }catch(IOException e){
            System.out.println(e);
            
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Docentes.bin"));
                
                docentes = new ArrayList<>();
                
                //cria docentes (String nome, String email, int numero, String categoria, String areaInvestigacao)
                Docente docente_1 = new Docente("Docente_1", "1@Docente.com", 1, "associado", "engenharia de software"); docentes.add(docente_1);
                Docente docente_2 = new Docente("Docente_2", "2@Docente.com", 2, "associado", "engenharia de software"); docentes.add(docente_2);
                Docente docente_3 = new Docente("Docente_3", "3@Docente.com", 3, "associado", "engenharia de software"); docentes.add(docente_3);
                Docente docente_4 = new Docente("Docente_4", "4@Docente.com", 4, "associado", "engenharia de software"); docentes.add(docente_4);
                Docente docente_5 = new Docente("Docente_5", "5@Docente.com", 5, "associado", "engenharia de software"); docentes.add(docente_5);
                
                
        
                oos.writeObject(docentes);
                oos.close();
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return docentes;
    }
    
    static List<Data> loadDatas(List<Data> datas){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Datas.bin"));
            datas = (List<Data>)ois.readObject();
            ois.close();
        }catch(IOException e){
            System.out.println(e);
            
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Datas.bin"));
                
                datas = new ArrayList<>();
                // criar algumas datas   (int ano, int mes, int dia, int horaInicio, int horaFim)
                Data uma = new Data(2017,1,1,13,14); datas.add(uma);
                Data duas = new Data(2017,1,1,14,15);datas.add(duas);
                Data tres = new Data(2017,1,1,15,16);datas.add(tres);
                Data quatro = new Data(2017,1,1,16,17);datas.add(quatro);
                Data cinco = new Data(2017,1,1,17,18);datas.add(cinco);
                
                oos.writeObject(datas);
                oos.close();
            }catch(IOException ee){
                System.out.println("Erro: " + e);
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return datas;
    }
    
    static void saveData(List<Aluno> alunosList, List<Curso> cursosList, List<Data> datasList, List<Disciplina> disciplinasList, 
                         List<Docente> docentesList, List<ExameEspecial> examesEspeciaisList,
                         List<ExameNormal> examesNormaisList, List<ExameRecurso> examesRecursoList,
                         List<NaoDocente> naoDocentesList, List<Notas> notas, List<Sala> salasList){
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
