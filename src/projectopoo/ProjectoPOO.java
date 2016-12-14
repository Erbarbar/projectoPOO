/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
*/
/**
 *
 * Classe principal
 */
public class ProjectoPOO {
    
    private static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Aluno> alunosList = new ArrayList<>();                       //
        List<Curso> cursosList = new ArrayList<>();                  //
        List<Data> datasList = new ArrayList<>();                       //
        List<Disciplina> disciplinasList = new ArrayList<>();       //
        List<Docente> docentesList = new ArrayList<>();                 //
        List<ExameEspecial> examesEspeciaisList = new ArrayList<>();
        List<ExameNormal> examesNormaisList = new ArrayList<>();
        List<ExameRecurso> examesRecursoList = new ArrayList<>();
        List<NaoDocente> naoDocentesList = new ArrayList<>();
        List<Notas> notas = new ArrayList<>();
        List<Sala> salasList = new ArrayList<>();                       //
        
        
        cursosList          = loadCursos(cursosList);                       
        disciplinasList     = loadDisciplinas(disciplinasList);     
        alunosList          = loadAlunos(alunosList);  
        salasList           = loadSalas(salasList);                                      
        docentesList        = loadDocentes(docentesList);                            
        datasList           = loadDatas(datasList);                                      
        examesEspeciaisList = loadExamesEspeciais(examesEspeciaisList);
        examesRecursoList   = loadExamesRecurso(examesRecursoList);
        examesNormaisList   = loadExamesNormais(examesNormaisList);
        naoDocentesList     = loadNaoDocentes(naoDocentesList);
        notas               = loadNotas(notas);
        
        
        
        int menu = 0;
        int readInt;
        String readString;
        while(true){
            try{
                switch(menu){
                    case 0: 

                        System.out.println("\t\tHOME\n");

                        System.out.println("1) Curso");
                        System.out.println("2) Disciplinas");
                        System.out.println("3) Pessoas");
                        System.out.println("4) Salas");
                        System.out.println("5) Exames");
                        System.out.println("6) Notas");

                        readInt = input.nextInt();input.nextLine();
                        
                        if(readInt >= 1 && readInt <= 6)
                            menu = readInt;

                        break;
                            case 01: // Curso
                                System.out.println("Insira o nome do curso: ");
                                readString = input.nextLine();
                                String nomeCurso = readString;
                                System.out.println("Insira a duracao do curso: ");
                                readInt = input.nextInt();input.nextLine();
                                int duracaoCurso = readInt;
                                System.out.println("Insira o grau do curso: ");
                                readString = input.nextLine();
                                String grau = readString;
                                
                                Curso aux = new Curso(nomeCurso,duracaoCurso,grau);
                                cursosList.add(aux);
                                
                                
                                
                                System.out.println("Curso criado:" );
                                System.out.println(aux.toString());
                                
                                updateCursos(cursosList);
                                
                                menu = 0;
                                
                                break;
                            case 02: // Disciplinas
                                System.out.println("Insira o nome da disciplina: ");
                                readString = input.nextLine();
                                String nomeDisciplinas = readString;
                                System.out.println("Insira a duracao do curso: ");
                                readInt = input.nextInt();input.nextLine();
                                int duracao = readInt;
                                System.out.println("Insira o grau do curso: ");
                                readString = input.nextLine();
                                //String grau = readString;
                                
                                //Curso aux = new Curso(nome,duracao,grau);
                                //cursosList.add(aux);
                                
                                
                                
                                System.out.println("Curso criado:" );
                                //System.out.println(aux.toString());
                                
                                updateCursos(cursosList);
                                
                                menu = 0;
                                break;
                            case 03: // Pessoas


                                System.out.println("\t\tPESSOAS\n");

                                System.out.println("1) Alunos");
                                System.out.println("2) Docentes");
                                System.out.println("3) Nao Docentes");
                                
                                readInt = input.nextInt();
                                input.nextLine();
                                
                                if(readInt >= 1 && readInt <= 3)
                                    menu = 30+readInt;
                                
                                break;
                                    case 31: // Alunos

                                        break;
                                    case 32: // Docentes

                                        break;
                                    case 33: // Nao Docentes

                                        break;
                            case 04: // Salas

                                break;
                            case 05: // Exames
                                System.out.println("\t\tEXAMES\n");

                                System.out.println("1) Epoca Normal");
                                System.out.println("2) Epoca Recurso");
                                System.out.println("3) Epoca Especial");
                                
                                readInt = input.nextInt();
                                input.nextLine();
                                if(readInt >= 1 && readInt <= 3)
                                    menu = 50+readInt;
                                break;
                                    case 51: // Normal

                                        break;
                                    case 52: // Recurso

                                        break;
                                    case 53: // Especial

                                        break;
                            case 06: // notas

                                break;
                    default:break;
                }
            }catch(NumberFormatException e){
                System.out.println(e);
            }
        }
        
        
        /*
        saveData(alunosList, cursosList, datasList, disciplinasList, 
                docentesList, examesEspeciaisList, examesNormaisList, 
                examesRecursoList, naoDocentesList, notas, salasList);
        */
    }

    
    
    
    static List<Aluno> loadAlunos(List<Aluno> alunosList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Alunos.bin"))) {
                alunosList = (List<Aluno>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateAlunos(alunosList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return alunosList;
    }
    static void updateAlunos(List<Aluno> alunosList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Alunos.bin"));
            oos.writeObject(alunosList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findAluno(List<Aluno> alunosList, int numeroAluno){
        int i=0;
        for(Aluno a : alunosList){
            if(a.numeroAluno == numeroAluno)
                return i;
            i++;
        }
        return -1;
    }
    
    static List<Curso> loadCursos(List<Curso> cursosList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cursos.bin"))) {
                cursosList = (List<Curso>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateCursos(cursosList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return cursosList;
    }
    static void updateCursos(List<Curso> cursosList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cursos.bin"));
            oos.writeObject(cursosList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findCurso(List<Curso> cursosList, String nome){
        int i=0;
        for(Curso c : cursosList){
            if(c.nome.equals(nome))
                return i;
            i++;
        }
        return -1;
    }
    
    static List<Data> loadDatas(List<Data> datasList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Datas.bin"))) {
                datasList = (List<Data>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateDatas(datasList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return datasList;
    }
    static void updateDatas(List<Data> datasList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Datas.bin"));
            oos.writeObject(datasList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findData(List<Data> datasList, int ano, int mes, int dia, int horaInicio, int horaFim){
        int i = 0;
        for(Data d : datasList){
            if(d.ano == ano && d.mes == mes && d.dia == dia && d.horaInicio == horaInicio && d.horaFim == horaFim)
                return i;
            i++;
        }
        return -1;
    }
    
    static List<Disciplina> loadDisciplinas(List<Disciplina> disciplinasList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Disciplinas.bin"))) {
                disciplinasList = (List<Disciplina>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateDisciplinas(disciplinasList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return disciplinasList;
    }
    static void updateDisciplinas(List<Disciplina> disciplinasList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Disciplinas.bin"));
            oos.writeObject(disciplinasList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findDisciplina(List<Disciplina> disciplinasList, String nome){
        int i = 0;
        for(Disciplina d : disciplinasList){
            if(d.nome.equals(nome))
                return i;
            i++;
        }
        return -1;
    }
    
    static List<Docente> loadDocentes(List<Docente> docentesList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Docentes.bin"))) {
                docentesList = (List<Docente>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateDocentes(docentesList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return docentesList;
    }
    static void updateDocentes(List<Docente> docentesList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Docentes.bin"));
            oos.writeObject(docentesList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findDocente(List<Docente> docentesList, int numeroMecanografico){
        int i = 0;
        for(Docente d : docentesList){
            if(d.numeroMecanografico==numeroMecanografico)
                return i;
            i++;
        }
        return -1;
    }
    
    static List<ExameEspecial> loadExamesEspeciais(List<ExameEspecial> examesEspeciaisList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ExamesEspeciais.bin"))) {
                examesEspeciaisList = (List<ExameEspecial>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateExamesEspeciais(examesEspeciaisList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return examesEspeciaisList;
    }
    static void updateExamesEspeciais(List<ExameEspecial> examesEspeciaisList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesEspeciais.bin"));
            oos.writeObject(examesEspeciaisList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findExameEspecial(List<ExameEspecial> examesEspeciaisList, String nomeDisciplina){
        int i = 0;
        for(ExameEspecial es : examesEspeciaisList){
            if(es.disciplina.nome.equals(nomeDisciplina))
                return i;
            i++;
        }
        return -1;
    }
    
    static List<ExameNormal> loadExamesNormais(List<ExameNormal> examesNormaisList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ExamesNormais.bin"))) {
                examesNormaisList = (List<ExameNormal>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateExamesNormais(examesNormaisList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return examesNormaisList;
    }
    static void updateExamesNormais(List<ExameNormal> examesNormaisList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesNormais.bin"));
            oos.writeObject(examesNormaisList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findExameNormal(List<ExameNormal> examesNormaisList, String nomeDisciplina){
        int i = 0;
        for(ExameNormal en : examesNormaisList){
            if(en.disciplina.nome.equals(nomeDisciplina))
                return i;
            i++;
        }
        return -1;
    }
    
    static List<ExameRecurso> loadExamesRecurso(List<ExameRecurso> examesRecursoList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ExamesRecurso.bin"))) {
                examesRecursoList = (List<ExameRecurso>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateExamesRecurso(examesRecursoList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return examesRecursoList;
    }
    static void updateExamesRecurso(List<ExameRecurso> examesRecursoList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesRecurso.bin"));
            oos.writeObject(examesRecursoList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findExameRecurso(List<ExameRecurso> examesRecursoList, String nomeDisciplina){
        int i = 0;
        for(ExameRecurso er : examesRecursoList){
            if(er.disciplina.nome.equals(nomeDisciplina))
                return i;
            i++;
        }
        return -1;
    }
    
    static List<NaoDocente> loadNaoDocentes(List<NaoDocente> naoDocentesList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NaoDocentes.bin"))) {
                naoDocentesList = (List<NaoDocente>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateNaoDocentes(naoDocentesList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return naoDocentesList;
    }
    static void updateNaoDocentes(List<NaoDocente> naoDocentesList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NaoDocentes.bin"));
            oos.writeObject(naoDocentesList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findNaoDocente(List<NaoDocente> naoDocentesList, int numeroMecanografico){
        int i = 0;
        for(NaoDocente nd : naoDocentesList){
            if(nd.numeroMecanografico == numeroMecanografico)
                return i;
            i++;
        }
        return -1;
    }
    
    static List<Notas> loadNotas(List<Notas> notasList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Notas.bin"))) {
                notasList = (List<Notas>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateNotas(notasList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return notasList;
    }
    static void updateNotas(List<Notas> notasList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Notas.bin"));
            oos.writeObject(notasList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findNotas(List<Notas> notasList, int numeroAluno){
        int i = 0;
        for(Notas n : notasList){
            if(n.aluno.numeroAluno == numeroAluno)
                return i;
            i++;
        }
        return -1;
    }
    
    static List<Sala> loadSalas(List<Sala> salasList){
        try{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Salas.bin"))) {
                salasList = (List<Sala>)ois.readObject();
                ois.close();
            }
        }catch(IOException e){
            System.out.println(e);
            
            updateSalas(salasList);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return salasList;
    }
    static void updateSalas(List<Sala> salasList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Salas.bin"));
            oos.writeObject(salasList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int findSala(List<Sala> salasList, String departamento, String numeroSala){
        int i = 0;
        for(Sala s : salasList){
            if(s.departamento.equals(departamento) && s.numeroSala.equals(numeroSala))
                return i;
            i++;
        }
        return -1;
    }
    
    
    static void saveData(List<Aluno> alunosList, List<Curso> cursosList, List<Data> datasList, List<Disciplina> disciplinasList, 
                         List<Docente> docentesList, List<ExameEspecial> examesEspeciaisList,
                         List<ExameNormal> examesNormaisList, List<ExameRecurso> examesRecursoList,
                         List<NaoDocente> naoDocentesList, List<Notas> notas, List<Sala> salasList){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Alunos.bin"));
            oos.writeObject(alunosList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cursos.bin"));
            oos.writeObject(cursosList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Datas.bin"));
            oos.writeObject(datasList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Disciplinas.bin"));
            oos.writeObject(disciplinasList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Docentes.bin"));
            oos.writeObject(docentesList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesEspeciais.bin"));
            oos.writeObject(examesEspeciaisList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesNormais.bin"));
            oos.writeObject(examesNormaisList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExamesRecurso.bin"));
            oos.writeObject(examesRecursoList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NaoDocentes.bin"));
            oos.writeObject(naoDocentesList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Salas.bin"));
            oos.writeObject(salasList);
            oos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    
}
