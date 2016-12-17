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
        List<Notas> notasList = new ArrayList<>();
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
        notasList           = loadNotas(notasList);
        
        
        
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
                        System.out.println("7) Listar Exames");
                        System.out.println("8) Sair");

                        readInt = input.nextInt();input.nextLine();
                        
                        if(readInt >= 1 && readInt <= 6)
                            menu = readInt;
                        if(readInt == 8){
                            saveData(alunosList, cursosList, datasList, disciplinasList, docentesList,  examesEspeciaisList, examesNormaisList,  examesRecursoList,naoDocentesList,  notasList,  salasList);
                            return;
                        }

                        break;
                            case 01: // Curso
                                System.out.println("Insira o nome do curso: ");
                                readString = input.nextLine();
                                String nomeCurso = readString;
                                System.out.println("Insira a duracao do curso: ");
                                readInt = input.nextInt();input.nextLine();
                                int duracao = readInt;
                                System.out.println("Insira o grau do curso: ");
                                readString = input.nextLine();
                                String grau = readString;
                                
                                Curso aux = new Curso(nomeCurso,duracao,grau);
                                cursosList.add(aux);
                                
                                
                                
                                System.out.println("Curso criado:" );
                                System.out.println(aux.toString());
                                
                                updateCursos(cursosList);
                                
                                menu = 0;
                                
                                break;
                                
                            case 02:
                                // Disciplinas
                                System.out.println("1) Insira o nome da disciplina");
                                System.out.println("2) Atribuir Docente Responsavel");
                                System.out.println("3) Atribuir outros Docentes");
                                System.out.println("4) Atribuir Aluno");
                                System.out.println("0) Voltar");
                                readInt = input.nextInt();
                                input.nextLine();
                                
                                if(readInt >= 1 && readInt <= 4)
                                    menu = 20+readInt;
                         
                                break;
                                    case 21:
                                        System.out.println("Qual o nome da disciplina");
                                        readString = input.nextLine();
                                        String nomeDisciplina21 = readString;
                                        Disciplina aux1 = new Disciplina(nomeDisciplina21);
                                        disciplinasList.add(aux1);
                                        
                                        
                                         System.out.println("Disciplina criada:" );
                                         System.out.println(aux1.toString());

                                        updateDisciplinas(disciplinasList);

                                        menu = 0;

                                        break;
                                    case 22:
                                        
                                        System.out.println("Diga o nome da disciplina para atribuicao docente");
                                         readString = input.nextLine();
                                         String nomeDisciplina22 = readString;
                                         int indiceDisciplina22 = findDisciplina(disciplinasList,nomeDisciplina22);
                                         if (indiceDisciplina22 == -1){
                                             menu = 2;
                                             System.out.println("nao encntrado");
                                             break;
                                         }
                                         
                                         System.out.println("Qualo numero mecanografico do docente");
                                         readInt = input.nextInt();input.nextLine();
                                         int numeroDocente22 = readInt;
                                         int indiceDocente22 = findDocente(docentesList,numeroDocente22);
                                         
                                         if (indiceDocente22 == -1){
                                             menu = 2;
                                             System.out.println("nao encntrado");
                                             break;
                                         }
                                         docentesList.get(indiceDocente22).addDisciplina(disciplinasList.get(indiceDisciplina22));
                                         disciplinasList.get(indiceDisciplina22).addDocenteResponsavel(docentesList.get(indiceDocente22));
                                         
                                         System.out.println("docente adicionado");
                                         updateDisciplinas(disciplinasList);
                                         updateDocentes(docentesList);
                                        
                                         menu=0;
                                      
                                        break;
                                    case 23:
                                        System.out.println("Diga o nome da disciplina para atribuicao docente");
                                         readString = input.nextLine();
                                         String nomeDisciplina23 = readString;
                                         int indiceDisciplina23 = findDisciplina(disciplinasList,nomeDisciplina23);
                                         if (indiceDisciplina23 == -1){
                                             menu = 2;
                                             System.out.println("nao encntrado");
                                             break;
                                         }
                                        
                                        
                                        System.out.println("Qual o numero mecanografico de outros docentes");
                                         readInt = input.nextInt();input.nextLine();
                                         int numeroDocente23 = readInt;
                                         int indiceDocente23 = findDocente(docentesList,numeroDocente23);
                                    
                                         
                                         if (indiceDocente23 == -1){
                                             menu = 0;
                                             System.out.println("nao encntrado");
                                             break;
                                         }
                                         docentesList.get(indiceDocente23).addDisciplina(disciplinasList.get(indiceDisciplina23));
                                         disciplinasList.get(indiceDisciplina23).addDocenteResponsavel(docentesList.get(indiceDocente23));
                                         
                                         System.out.println(" outro docente adicionado");
                                         updateDisciplinas(disciplinasList);
                                         updateDocentes(docentesList);
                                        
                                         menu=0;
                                        
                                        
                                        break;
                                    case 24:
                                            System.out.println("Diga o nome da disciplina para atribuicao do aluno");
                                            readString = input.nextLine();
                                            String nomeDisciplina24 = readString;
                                            int indiceDisciplina24 = findDisciplina(disciplinasList,nomeDisciplina24);
                                             if (indiceDisciplina24 == -1){
                                             menu = 2;
                                             System.out.println("nao encntrado");
                                             break;
                                         }
                                        
                                        
                                        System.out.println("Qual o numero do aluno?");
                                         readInt = input.nextInt();input.nextLine();
                                         int numeroAluno24 = readInt;
                                         int indiceAluno24 = findAluno(alunosList,numeroAluno24);
                                         if (indiceAluno24 == -1){
                                             menu = 0;
                                             System.out.println("nao encntrado");
                                             break;
                                         }
                                         
                                         alunosList.get(indiceAluno24).addDisciplinas(disciplinasList.get(indiceAluno24));
                                         disciplinasList.get(indiceDisciplina24).addDocenteResponsavel(docentesList.get(indiceAluno24));
                                         
                                         System.out.println(" Aluno adicionado");
                                         updateDisciplinas(disciplinasList);
                                         updateAlunos(alunosList);
                                        
                                         menu=0;
                                         break;
                                    
                                    
                                
                            case 03: // Pessoas


                                System.out.println("\t\tPESSOAS\n");

                                System.out.println("1) Alunos");
                                System.out.println("2) Docentes");
                                System.out.println("3) Nao Docentes");
                                System.out.println("0) Voltar");
                                
                                readInt = input.nextInt();
                                input.nextLine();
                                
                                if(readInt >= 1 && readInt <= 3)
                                    menu = 30+readInt;
                                if(readInt == 0)
                                    menu = 0;
                                
                                break;
                                    case 31: // Alunos
                                        System.out.println("Qual onome do aluno:");
                                        readString = input.nextLine();
                                        String nomeAluno31 = readString;
                                        System.out.println("Qual o email do aluno");
                                        readString = input.nextLine();
                                        String emailAluno31 = readString;
                                        System.out.println("Qual o numero do aluno:");
                                        int numeroAluno31 = input.nextInt();input.nextLine();
                                        System.out.println("Qual é o seu Curso");
                                        readString= input.nextLine();
                                        String nomeCurso31 = readString;
                                        
                                        
                                        int indiceCurso31 = findCurso(cursosList,nomeCurso31);
                                        if (indiceCurso31 == -1){
                                            menu=0;
                                            System.out.println("curso nao encontrado");
                                            break;
                                        }
                                        System.out.println("Qual o seu ano");
                                        int anoAluno31 = input.nextInt();input.nextLine();
                                        System.out.println("Qual o seu regime (normal,TE,atleta,DA,Erasmos)");
                                        String regimeAluno31 = input.nextLine();
                                        Aluno aux31 = new Aluno(nomeAluno31,emailAluno31,numeroAluno31,cursosList.get(indiceCurso31),anoAluno31,regimeAluno31);
                                        alunosList.add(aux31);
                                     
                                         System.out.println("ALuno Adicionado:" );
                                         System.out.println(aux31.toString());

                                        updateAlunos(alunosList);
                                  
                                        break;
                                    case 32: // Docentes
                                        System.out.println("Qual onome do docente:");
                                        readString = input.nextLine();
                                        String nomeDocente32 = readString;
                                        System.out.println("Qual o email do docente");
                                        readString = input.nextLine();
                                        String emailDocente32 = readString;
                                        System.out.println("Qual o seu numeroMecanografico");
                                        int numeromecanograficoDocente32 = input.nextInt();input.nextLine();
                                        System.out.println("Qual a sua categoria:");
                                        String categoriaDocente32 = input.nextLine();
                                        System.out.println("Qual é a sua Area de investigacao");
                                        readString= input.nextLine();
                                        String areaDocente32 = readString;
                                        
                                        Docente aux32 = new Docente(nomeDocente32,emailDocente32,numeromecanograficoDocente32,categoriaDocente32,areaDocente32);
                                        docentesList.add(aux32);
                                       
                                        System.out.println("Docente Adicionado:" );
                                        System.out.println(aux32.toString());

                                        updateDocentes(docentesList);
                                        
                                        break;
                                    case 33: // Nao Docentes
                                        System.out.println("Qual onome do nao docente:");
                                        String nomeNaoDocente33 = input.nextLine();
                                        
                                        System.out.println("Qual o email do nao docente");
                                        String emailNaoDocente33 = input.nextLine();
                                        
                                        System.out.println("Qual o seu numeroMecanografico");
                                        int numeromecanograficoNaoDocente33 = input.nextInt();input.nextLine();
                                        
                                        System.out.println("Qual a sua categoria:");
                                        String categoriaNaoDocente33 = input.nextLine();
                                        
                                        System.out.println("Qual é o seu cargo");
                                        String cargonaoDocente33 = input.nextLine();
                                        
                                        NaoDocente aux33 = new NaoDocente(nomeNaoDocente33,emailNaoDocente33,numeromecanograficoNaoDocente33,categoriaNaoDocente33,cargonaoDocente33);
                                        naoDocentesList.add(aux33);
                                       
                                        System.out.println("Docente Adicionado:" );
                                        System.out.println(aux33.toString());

                                        updateDocentes(docentesList);
                                        break;
                            case 04: // Salas
                                System.out.println("Departamento:");
                                String departamentoSala4 = input.nextLine();
                                
                                System.out.println("Numero da sala:");
                                String numeroSala4 = input.nextLine();
                                
                                System.out.println("Numero de lugares:");
                                int lugaresSala4 = input.nextInt();input.nextLine();
                                
                                Sala aux4 = new Sala(departamentoSala4,numeroSala4,lugaresSala4);
                                salasList.add(aux4);
                                
                                System.out.println("Sala Adicionada:" );
                                System.out.println(aux4.toString());
                                
                                updateSalas(salasList);

                                break;
                            case 05: // Exames
                                System.out.println("\t\tEXAMES\n");
                                
                                System.out.println("1) Epoca Normal");
                                System.out.println("2) Epoca Recurso");
                                System.out.println("3) Epoca Especial");
                                System.out.println("0) Voltar");
                                
                                readInt = input.nextInt();
                                input.nextLine();
                                if(readInt >= 1 && readInt <= 3)
                                    menu = 50+readInt;
                                if(readInt == 0)
                                    menu = 0;
                                break;
                                    case 51: // Normal
                                        System.out.println("1) Novo exame normal");
                                        System.out.println("2) Adicionar data");
                                        System.out.println("3) Adicionar sala");
                                        System.out.println("4) Adicionar docente responsavel");
                                        System.out.println("5) Adicionar vigilante");
                                        System.out.println("6) Inscrever aluno");
                                        System.out.println("0) Voltar");
                                        
                                        readInt = input.nextInt();input.nextLine();
                                        if(readInt >= 1 && readInt <= 6)
                                            menu = 510 + readInt;
                                        if(readInt == 0)
                                            menu = 5;
                                        break;
                                            case 511: //  Novo exame normal
                                                System.out.println("Disciplina do exame:");
                                                String disciplina511 = input.nextLine();
                                                
                                                int indexDisciplina511 = findDisciplina(disciplinasList,disciplina511);
                                                if(indexDisciplina511 == -1){
                                                    System.out.println("Nao encontrada");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                ExameNormal aux511 = new ExameNormal(disciplinasList.get(indexDisciplina511));
                                                examesNormaisList.add(aux511);
                                                
                                                System.out.println("Adicionado exame normal");
                                                System.out.println(aux511.toString());
                                                
                                                updateExamesNormais(examesNormaisList);
                                                
                                                menu = 51;
                                                
                                                break;
                                            case 512: // data
                                                System.out.println("Disciplina do exame:");
                                                String disciplina512 = input.nextLine();
                                                
                                                int indexExameNormal512 = findExameNormal(examesNormaisList,disciplina512);
                                                if(indexExameNormal512 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Ano:");
                                                int ano512 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Mes:");
                                                int mes512 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Dia:");
                                                int dia512 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Hora de inicio:");
                                                int hotaInicio512 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Hora de fim:");
                                                int horaFim512 = input.nextInt();input.nextLine();
                                                
                                                int dataIndex512 = findData(datasList,ano512,mes512,dia512,hotaInicio512,horaFim512);
                                                if(dataIndex512 == -1){
                                                    Data auxData512 = new Data(ano512,mes512,dia512,hotaInicio512,horaFim512);
                                                    datasList.add(auxData512);
                                                    dataIndex512 = findData(datasList,ano512,mes512,dia512,hotaInicio512,horaFim512);
                                                    updateDatas(datasList);
                                                }
                                                
                                                examesNormaisList.get(indexExameNormal512).changeData(datasList.get(dataIndex512));
                                                System.out.println("Alterada a data");
                                                
                                                updateExamesNormais(examesNormaisList);
                                                
                                                menu = 51;
                                                
                                                break;
                                            case 513://sala
                                                System.out.println("Disciplina do exame:");
                                                String disciplina513 = input.nextLine();
                                                
                                                int indexExameNormal513 = findExameNormal(examesNormaisList,disciplina513);
                                                if(indexExameNormal513 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Departamento da sala");
                                                String departamentoSala513 = input.nextLine();
                                                
                                                System.out.println("Numero da sala");
                                                String numeroSala513 = input.nextLine();
                                                
                                                int indexSala513 = findSala(salasList,departamentoSala513,numeroSala513);
                                                if(indexSala513 == -1){
                                                    System.out.println("Sala nao encontrada");
                                                    menu = 0;
                                                    break;
                                                }
                                                examesNormaisList.get(indexExameNormal513).addSala(salasList.get(indexSala513));
                                                
                                                System.out.println("Sala adicionada com sucesso!");
                                                
                                                updateExamesNormais(examesNormaisList);
                                                
                                                menu = 51;

                                                break;
                                            case 514://docente responsavel
                                                System.out.println("Disciplina do exame:");
                                                String disciplina514 = input.nextLine();
                                                
                                                int indexExameNormal514 = findExameNormal(examesNormaisList,disciplina514);
                                                if(indexExameNormal514 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero mecanografico do docente responsavel:");
                                                int numeroMecanograficoDocente514 = input.nextInt();input.nextLine();
                                                
                                                int indexDocente514 = findDocente(docentesList,numeroMecanograficoDocente514);
                                                if(indexDocente514 == -1){
                                                    System.out.println("Docente nao encontrado!");
                                                    menu = 0;
                                                }
                                                
                                                examesNormaisList.get(indexExameNormal514).addDocenteResponsavel(docentesList.get(indexDocente514));
                                                docentesList.get(indexDocente514).addExame(examesNormaisList.get(indexExameNormal514));
                                                
                                                System.out.println("Docente responsavel adicionado com sucesso");
                                                
                                                updateExamesNormais(examesNormaisList);
                                                updateDocentes(docentesList);
                                                
                                                menu = 51;

                                                break;
                                            case 515://Adicionar vigilante
                                                System.out.println("Disciplina do exame:");
                                                String disciplina515 = input.nextLine();
                                                
                                                int indexExameNormal515 = findExameNormal(examesNormaisList,disciplina515);
                                                if(indexExameNormal515 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero mecanografico do vigilante:");
                                                int numeroMecanograficoDocente515 = input.nextInt();input.nextLine();
                                                
                                                int indexDocente515 = findDocente(docentesList,numeroMecanograficoDocente515);
                                                if(indexDocente515 >= 0){
                                                    examesNormaisList.get(indexExameNormal515).addVigilanteDocente(docentesList.get(indexDocente515));
                                                    docentesList.get(indexDocente515).addExame(examesNormaisList.get(indexExameNormal515));

                                                    System.out.println("Docente vigilante adicionado a lista de vigilantes com sucesso");

                                                    updateExamesNormais(examesNormaisList);
                                                    updateDocentes(docentesList);
                                                    menu = 51;
                                                    break;
                                                    
                                                }
                                                indexDocente515 = findNaoDocente(naoDocentesList,numeroMecanograficoDocente515);
                                                if(indexDocente515 >= 0){
                                                    examesNormaisList.get(indexExameNormal515).addVigilanteNaoDocente(naoDocentesList.get(indexDocente515));
                                                    docentesList.get(indexDocente515).addExame(examesNormaisList.get(indexExameNormal515));

                                                    System.out.println("Nao docente adicionado a lista de vigilantes com sucesso");

                                                    updateExamesNormais(examesNormaisList);
                                                    updateNaoDocentes(naoDocentesList);
                                                    menu = 51;
                                                    break;
                                                    
                                                }
                                                System.out.println("Nao encontrado o funcionario");
                                                menu = 51;
                                                
                                            case 516://Inscrever aluno
                                                System.out.println("Disciplina do exame:");
                                                String disciplina516 = input.nextLine();
                                                
                                                int indexExameNormal516 = findExameNormal(examesNormaisList,disciplina516);
                                                if(indexExameNormal516 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero do aluno:");
                                                int numeroAluno516 = input.nextInt();input.nextLine();
                                                
                                                int indexAluno514 = findAluno(alunosList,numeroAluno516);
                                                if(indexAluno514 == -1){
                                                    System.out.println("Aluno nao encontrado!");
                                                    menu = 0;
                                                }
                                                
                                                examesNormaisList.get(indexExameNormal516).addDocenteResponsavel(docentesList.get(indexAluno514));
                                                alunosList.get(indexAluno514).addExame(examesNormaisList.get(indexExameNormal516));
                                                
                                                System.out.println("Aluno inscrito no exame com sucesso");
                                                
                                                updateExamesNormais(examesNormaisList);
                                                updateAlunos(alunosList);
                                                
                                                menu = 51;
                                                

                                                break;
                                    case 52: // Recurso
                                        System.out.println("1) Novo exame de recurso");
                                        System.out.println("2) Adicionar data");
                                        System.out.println("3) Adicionar sala");
                                        System.out.println("4) Adicionar docente responsavel");
                                        System.out.println("5) Adicionar vigilante");
                                        System.out.println("6) Inscrever aluno");
                                        System.out.println("0) Voltar");
                                        
                                        readInt = input.nextInt();input.nextLine();
                                        if(readInt >= 1 && readInt <= 6)
                                            menu = 520 + readInt;
                                        if(readInt == 0)
                                            menu = 5;
                                        break;
                                            case 521:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina521 = input.nextLine();
                                                
                                                int indexDisciplina521 = findDisciplina(disciplinasList,disciplina521);
                                                if(indexDisciplina521 == -1){
                                                    System.out.println("Nao encontrada");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                ExameRecurso aux521 = new ExameRecurso(disciplinasList.get(indexDisciplina521));
                                                examesRecursoList.add(aux521);
                                                
                                                System.out.println("Adicionado exame de recurso");
                                                System.out.println(aux521.toString());
                                                
                                                updateExamesRecurso(examesRecursoList);
                                                
                                                menu = 52;
                                                

                                                break;
                                            case 522:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina522 = input.nextLine();
                                                
                                                int indexExameRecurso522 = findExameRecurso(examesRecursoList,disciplina522);
                                                if(indexExameRecurso522 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Ano:");
                                                int ano522 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Mes:");
                                                int mes522 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Dia:");
                                                int dia522 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Hora de inicio:");
                                                int hotaInicio522 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Hora de fim:");
                                                int horaFim522 = input.nextInt();input.nextLine();
                                                
                                                int dataIndex522 = findData(datasList,ano522,mes522,dia522,hotaInicio522,horaFim522);
                                                if(dataIndex522 == -1){
                                                    Data auxData522 = new Data(ano522,mes522,dia522,hotaInicio522,horaFim522);
                                                    datasList.add(auxData522);
                                                    dataIndex522 = findData(datasList,ano522,mes522,dia522,hotaInicio522,horaFim522);
                                                    updateDatas(datasList);
                                                }
                                                
                                                examesRecursoList.get(indexExameRecurso522).changeData(datasList.get(dataIndex522));
                                                System.out.println("Alterada a data");
                                                
                                                updateExamesRecurso(examesRecursoList);
                                                
                                                menu = 52;
                                                

                                                break;
                                            case 523:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina523 = input.nextLine();
                                                
                                                int indexExameRecurso523 = findExameRecurso(examesRecursoList,disciplina523);
                                                if(indexExameRecurso523 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Departamento da sala");
                                                String departamentoSala523 = input.nextLine();
                                                
                                                System.out.println("Numero da sala");
                                                String numeroSala523 = input.nextLine();
                                                
                                                int indexSala523 = findSala(salasList,departamentoSala523,numeroSala523);
                                                if(indexSala523 == -1){
                                                    System.out.println("Sala nao encontrada");
                                                    menu = 0;
                                                    break;
                                                }
                                                examesRecursoList.get(indexExameRecurso523).addSala(salasList.get(indexSala523));
                                                
                                                System.out.println("Sala adicionada com sucesso!");
                                                
                                                updateExamesRecurso(examesRecursoList);
                                                
                                                menu = 52;

                                                break;
                                            case 524:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina524 = input.nextLine();
                                                
                                                int indexExameRecursol524 = findExameRecurso(examesRecursoList,disciplina524);
                                                if(indexExameRecursol524 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero mecanografico do docente responsavel:");
                                                int numeroMecanograficoDocente524 = input.nextInt();input.nextLine();
                                                
                                                int indexDocente524 = findDocente(docentesList,numeroMecanograficoDocente524);
                                                if(indexDocente524 == -1){
                                                    System.out.println("Docente nao encontrado!");
                                                    menu = 0;
                                                }
                                                
                                                examesRecursoList.get(indexExameRecursol524).addDocenteResponsavel(docentesList.get(indexDocente524));
                                                docentesList.get(indexDocente524).addExame(examesRecursoList.get(indexExameRecursol524));
                                                
                                                System.out.println("Docente responsavel adicionado com sucesso");
                                                
                                                updateExamesRecurso(examesRecursoList);
                                                updateDocentes(docentesList);
                                                
                                                menu = 52;

                                                break;
                                            case 525:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina525 = input.nextLine();
                                                
                                                int indexExameRecurso525 = findExameRecurso(examesRecursoList,disciplina525);
                                                if(indexExameRecurso525 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero mecanografico do vigilante:");
                                                int numeroMecanograficoDocente525 = input.nextInt();input.nextLine();
                                                
                                                int indexDocente525 = findDocente(docentesList,numeroMecanograficoDocente525);
                                                if(indexDocente525 >= 0){
                                                    examesRecursoList.get(indexExameRecurso525).addVigilanteDocente(docentesList.get(indexDocente525));
                                                    docentesList.get(indexDocente525).addExame(examesRecursoList.get(indexExameRecurso525));

                                                    System.out.println("Docente vigilante adicionado a lista de vigilantes com sucesso");

                                                    updateExamesRecurso(examesRecursoList);
                                                    updateDocentes(docentesList);
                                                    
                                                    menu = 52;
                                                    break;
                                                }
                                                indexDocente515 = findNaoDocente(naoDocentesList,numeroMecanograficoDocente525);
                                                if(indexDocente515 >= 0){
                                                    examesRecursoList.get(indexExameRecurso525).addVigilanteNaoDocente(naoDocentesList.get(indexDocente525));
                                                    docentesList.get(indexDocente525).addExame(examesRecursoList.get(indexExameRecurso525));

                                                    System.out.println("Nao docente adicionado a lista de vigilantes com sucesso");

                                                    updateExamesRecurso(examesRecursoList);
                                                    updateNaoDocentes(naoDocentesList);
                                                    
                                                    menu = 52;
                                                    break;
                                                }
                                                System.out.println("Nao encontrado o funcionario");
                                                menu = 52;

                                                break;
                                            case 526:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina526 = input.nextLine();
                                                
                                                int indexExameRecurso526 = findExameRecurso(examesRecursoList,disciplina526);
                                                if(indexExameRecurso526 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero do aluno:");
                                                int numeroAluno526 = input.nextInt();input.nextLine();
                                                
                                                int indexAluno524 = findAluno(alunosList,numeroAluno526);
                                                if(indexAluno524 == -1){
                                                    System.out.println("Aluno nao encontrado!");
                                                    menu = 0;
                                                }
                                                
                                                examesRecursoList.get(indexExameRecurso526).addDocenteResponsavel(docentesList.get(indexAluno524));
                                                alunosList.get(indexAluno524).addExame(examesRecursoList.get(indexExameRecurso526));
                                                
                                                System.out.println("Aluno inscrito no exame com sucesso");
                                                
                                                updateExamesRecurso(examesRecursoList);
                                                updateAlunos(alunosList);
                                                
                                                menu = 52;

                                                break;
                                    case 53: // Especial
                                        System.out.println("1) Novo exame especial");
                                        System.out.println("2) Adicionar data");
                                        System.out.println("3) Adicionar sala");
                                        System.out.println("4) Adicionar docente responsavel");
                                        System.out.println("5) Adicionar vigilante");
                                        System.out.println("6) Inscrever aluno");
                                        System.out.println("0) Voltar");
                                        
                                        readInt = input.nextInt();input.nextLine();
                                        if(readInt >= 1 && readInt <= 6)
                                            menu = 530 + readInt;
                                        if(readInt == 0)
                                            menu = 5;
                                        break;
                                            case 531:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina531 = input.nextLine();
                                                
                                                int indexDisciplina531 = findDisciplina(disciplinasList,disciplina531);
                                                if(indexDisciplina531 == -1){
                                                    System.out.println("Nao encontrada");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                ExameEspecial aux531 = new ExameEspecial(disciplinasList.get(indexDisciplina531));
                                                examesEspeciaisList.add(aux531);
                                                
                                                System.out.println("Adicionado exame de recurso");
                                                System.out.println(aux531.toString());
                                                
                                                updateExamesEspeciais(examesEspeciaisList);
                                                
                                                menu = 53;

                                                break;
                                            case 532:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina532 = input.nextLine();
                                                
                                                int indexExameEspecial532 = findExameEspecial(examesEspeciaisList,disciplina532);
                                                if(indexExameEspecial532 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Ano:");
                                                int ano532 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Mes:");
                                                int mes532 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Dia:");
                                                int dia532 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Hora de inicio:");
                                                int hotaInicio532 = input.nextInt();input.nextLine();
                                                
                                                System.out.println("Hora de fim:");
                                                int horaFim532 = input.nextInt();input.nextLine();
                                                
                                                int dataIndex532 = findData(datasList,ano532,mes532,dia532,hotaInicio532,horaFim532);
                                                if(dataIndex532 == -1){
                                                    Data auxData532 = new Data(ano532,mes532,dia532,hotaInicio532,horaFim532);
                                                    datasList.add(auxData532);
                                                    dataIndex532 = findData(datasList,ano532,mes532,dia532,hotaInicio532,horaFim532);
                                                    updateDatas(datasList);
                                                }
                                                
                                                examesEspeciaisList.get(indexExameEspecial532).changeData(datasList.get(dataIndex532));
                                                System.out.println("Alterada a data");
                                                
                                                updateExamesEspeciais(examesEspeciaisList);
                                                
                                                menu = 53;

                                                break;
                                            case 533:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina533 = input.nextLine();
                                                
                                                int indexExameEspecial533 = findExameEspecial(examesEspeciaisList,disciplina533);
                                                if(indexExameEspecial533 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Departamento da sala");
                                                String departamentoSala533 = input.nextLine();
                                                
                                                System.out.println("Numero da sala");
                                                String numeroSala533 = input.nextLine();
                                                
                                                int indexSala533 = findSala(salasList,departamentoSala533,numeroSala533);
                                                if(indexSala533 == -1){
                                                    System.out.println("Sala nao encontrada");
                                                    menu = 0;
                                                    break;
                                                }
                                                examesEspeciaisList.get(indexExameEspecial533).addSala(salasList.get(indexSala533));
                                                
                                                System.out.println("Sala adicionada com sucesso!");
                                                
                                                updateExamesEspeciais(examesEspeciaisList);
                                                
                                                menu = 53;

                                                break;
                                            case 534:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina534 = input.nextLine();
                                                
                                                int indexExameEspecial534 = findExameEspecial(examesEspeciaisList,disciplina534);
                                                if(indexExameEspecial534 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero mecanografico do docente responsavel:");
                                                int numeroMecanograficoDocente534 = input.nextInt();input.nextLine();
                                                
                                                int indexDocente534 = findDocente(docentesList,numeroMecanograficoDocente534);
                                                if(indexDocente534 == -1){
                                                    System.out.println("Docente nao encontrado!");
                                                    menu = 0;
                                                }
                                                
                                                examesEspeciaisList.get(indexExameEspecial534).addDocenteResponsavel(docentesList.get(indexDocente534));
                                                docentesList.get(indexDocente534).addExame(examesEspeciaisList.get(indexExameEspecial534));
                                                
                                                System.out.println("Docente responsavel adicionado com sucesso");
                                                
                                                updateExamesEspeciais(examesEspeciaisList);
                                                updateDocentes(docentesList);
                                                
                                                menu = 53;

                                                break;
                                            case 535:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina535 = input.nextLine();
                                                
                                                int indexExameEspecial535 = findExameEspecial(examesEspeciaisList,disciplina535);
                                                if(indexExameEspecial535 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero mecanografico do vigilante:");
                                                int numeroMecanograficoDocente535 = input.nextInt();input.nextLine();
                                                
                                                int indexDocente535 = findDocente(docentesList,numeroMecanograficoDocente535);
                                                if(indexDocente535 >= 0){
                                                    examesEspeciaisList.get(indexExameEspecial535).addVigilanteDocente(docentesList.get(indexDocente535));
                                                    docentesList.get(indexDocente535).addExame(examesEspeciaisList.get(indexExameEspecial535));

                                                    System.out.println("Docente vigilante adicionado a lista de vigilantes com sucesso");

                                                    updateExamesEspeciais(examesEspeciaisList);
                                                    updateDocentes(docentesList);
                                                    
                                                    menu = 53;
                                                    break;
                                                }
                                                indexDocente535 = findNaoDocente(naoDocentesList,numeroMecanograficoDocente535);
                                                if(indexDocente535 >= 0){
                                                    examesEspeciaisList.get(indexExameEspecial535).addVigilanteNaoDocente(naoDocentesList.get(indexDocente535));
                                                    docentesList.get(indexDocente535).addExame(examesEspeciaisList.get(indexExameEspecial535));

                                                    System.out.println("Nao docente adicionado a lista de vigilantes com sucesso");

                                                    updateExamesEspeciais(examesEspeciaisList);
                                                    updateNaoDocentes(naoDocentesList);
                                                    
                                                    menu = 53;
                                                    break;
                                                }
                                                System.out.println("Nao encontrado o funcionario");
                                                menu = 53;

                                                break;
                                            case 536:
                                                System.out.println("Disciplina do exame:");
                                                String disciplina536 = input.nextLine();
                                                
                                                int indexExameEspecial526 = findExameEspecial(examesEspeciaisList,disciplina536);
                                                if(indexExameEspecial526 == -1){
                                                    System.out.println("Nao encontrado o exame");
                                                    menu = 0;
                                                    break;
                                                }
                                                
                                                System.out.println("Numero do aluno:");
                                                int numeroAluno536 = input.nextInt();input.nextLine();
                                                
                                                int indexAluno534 = findAluno(alunosList,numeroAluno536);
                                                if(indexAluno534 == -1){
                                                    System.out.println("Aluno nao encontrado!");
                                                    menu = 0;
                                                }
                                                
                                                if(alunosList.get(indexAluno534).addExameEspecial(examesEspeciaisList.get(indexExameEspecial526))){
                                                    examesEspeciaisList.get(indexExameEspecial526).addDocenteResponsavel(docentesList.get(indexAluno534));
                                                    System.out.println("Aluno inscrito no exame com sucesso");

                                                    updateExamesEspeciais(examesEspeciaisList);
                                                    updateAlunos(alunosList);
                                                }
                                                
                                                
                                                menu = 53;

                                                break;
                            case 06: // notas

                                break;
                            case 07: // informacoes exames
                                System.out.println("1) Listar Exames – Epoca, disciplina, data, hora, duracao, sala, numero de vigilantes convocados e de alunos inscritos");
                                System.out.println("2) Listar alunos inscritos num exame e classificacoes obtidas, caso existam");
                                System.out.println("3) Listar exames em que um aluno está inscrito e classificações obtidas, caso existam");
                                System.out.println("4) Listar docentes e funcionários associados a um exame");
                                System.out.println("5) Listar exames em que um docente ou funcionário está envolvido");
                                System.out.println("6) Listar notas de um exame");
                                System.out.println("0) Voltar");
                                
                                readInt = input.nextInt();input.nextLine();
                                if(readInt >= 1 && readInt <= 6)
                                    menu = 70+readInt;
                                if(readInt == 0)
                                    menu = 0;
                                break;
                                    case 71: // Listar Exames – Epoca, disciplina, data, hora, duracao, sala, numero de vigilantes convocados e de alunos inscritos
                                        for(ExameNormal en : examesNormaisList){
                                            // prepara o display das salas
                                            String salasString = "";
                                            for(Sala s : en.salas){
                                                String salaStringAux = s.numeroSala + ", ";
                                                salasString = salasString.concat(salaStringAux);
                                            }
                                            // conta o numero de vigilantes e o de alunos
                                            int numeroAlunos = 0, numeroVigilantes = 0;
                                            for(Aluno a: en.alunosInscritos)
                                                numeroAlunos++;
                                            for(Docente d: en.listaVigilantesDocentes)
                                                numeroVigilantes++;
                                            for(NaoDocente nd: en.listaVigilantesNaoDocentes)
                                                numeroVigilantes++;
                                            
                                            System.out.println("Epoca: Normal" +
                                                               " Disciplina: " + en.disciplina.nome + 
                                                               " Data: " + en.data.ano+"-"+en.data.mes+"/"+en.data.dia +
                                                               " Hora: " + en.data.horaInicio +
                                                               " Duracao (em minutos): " + en.data.minutos +
                                                               " Sala: " + salasString +
                                                               " Numero de vigilantes convocados: "+ numeroVigilantes +
                                                               " Numero de alunos inscritos: " + numeroAlunos);
                                        }
                                        for(ExameRecurso er: examesRecursoList){
                                            // prepara o display das salas
                                            String salasString = "";
                                            for(Sala s : er.salas){
                                                String salaStringAux = s.numeroSala + ", ";
                                                salasString = salasString.concat(salaStringAux);
                                            }
                                            // conta o numero de vigilantes e o de alunos
                                            int numeroAlunos = 0, numeroVigilantes = 0;
                                            for(Aluno a: er.alunosInscritos)
                                                numeroAlunos++;
                                            for(Docente d: er.listaVigilantesDocentes)
                                                numeroVigilantes++;
                                            for(NaoDocente nd: er.listaVigilantesNaoDocentes)
                                                numeroVigilantes++;
                                            
                                            System.out.println("Epoca: Recurso" +
                                                               " Disciplina: " + er.disciplina.nome + 
                                                               " Data: " + er.data.ano+"-"+er.data.mes+"/"+er.data.dia +
                                                               " Hora: " + er.data.horaInicio +
                                                               " Duracao (em minutos): " + er.data.minutos +
                                                               " Sala: " + salasString +
                                                               " Numero de vigilantes convocados: "+ numeroVigilantes +
                                                               " Numero de alunos inscritos: " + numeroAlunos);
                                        }
                                        for(ExameEspecial es: examesEspeciaisList){
                                            // prepara o display das salas
                                            String salasString = "";
                                            for(Sala s : es.salas){
                                                String salaStringAux = s.numeroSala + ", ";
                                                salasString = salasString.concat(salaStringAux);
                                            }
                                            // conta o numero de vigilantes e o de alunos
                                            int numeroAlunos = 0, numeroVigilantes = 0;
                                            for(Aluno a: es.alunosInscritos)
                                                numeroAlunos++;
                                            for(Docente d: es.listaVigilantesDocentes)
                                                numeroVigilantes++;
                                            for(NaoDocente nd: es.listaVigilantesNaoDocentes)
                                                numeroVigilantes++;
                                            
                                            System.out.println("Epoca: Especial" +
                                                               " Disciplina: " + es.disciplina.nome + 
                                                               " Data: " + es.data.ano+"-"+es.data.mes+"/"+es.data.dia +
                                                               " Hora: " + es.data.horaInicio +
                                                               " Duracao (em minutos): " + es.data.minutos +
                                                               " Sala: " + salasString +
                                                               " Numero de vigilantes convocados: "+ numeroVigilantes +
                                                               " Numero de alunos inscritos: " + numeroAlunos);
                                        }
                                        break;
                                    case 72: // Listar alunos inscritos num exame e classificacoes obtidas, caso existam
                                        System.out.println("1) Epoca normal");
                                        System.out.println("2) Epoca recurso");
                                        System.out.println("3) Epoca especial");
                                        System.out.println("0) Voltar");
                                        
                                        readInt = input.nextInt(); input.nextLine();
                                        if(readInt == 0){
                                            menu = 0;
                                            break;
                                        }
                                        if(readInt >=1 && readInt <= 3)
                                            menu = 720 + readInt;
                                        break;
                                            case 721: // normal
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina721 = input.nextLine();
                                                
                                                int indiceExame721 = findExameNormal(examesNormaisList,disciplina721);
                                                if(indiceExame721 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 72;
                                                    break;
                                                }
                                                int linha721 = 0;
                                                int indiceNota721;
                                                String displayNota721 = "Nao lancada"; // se nao encontrar a nota
                                                for(Aluno a : examesNormaisList.get(indiceExame721).alunosInscritos){
                                                    linha721++;
                                                    
                                                    indiceNota721 = findNotas(notasList,a,examesNormaisList.get(indiceExame721));
                                                    if(indiceNota721 >=0)// encontra a nota
                                                        displayNota721 = Float.toString(notasList.get(indiceNota721).classificacao);
                                                    
                                                    System.out.println(linha721 + ")"+
                                                                      " Nome: " + a.nome +
                                                                      " Nota: " + displayNota721);
                                                }
                                                break;
                                            case 722: // recurso
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina722 = input.nextLine();
                                                
                                                int indiceExame722 = findExameRecurso(examesRecursoList,disciplina722);
                                                if(indiceExame722 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 72;
                                                    break;
                                                }
                                                int linha722 = 0;
                                                int indiceNota722;
                                                String displayNota722 = "Nao lancada"; // se nao encontrar a nota
                                                for(Aluno a : examesRecursoList.get(indiceExame722).alunosInscritos){
                                                    linha722++;
                                                    
                                                    indiceNota722 = findNotas(notasList,a,examesRecursoList.get(indiceExame722));
                                                    if(indiceNota722 >=0)// encontra a nota
                                                        displayNota722 = Float.toString(notasList.get(indiceNota722).classificacao);
                                                    
                                                    System.out.println(linha722 + ")"+
                                                                      " Nome: " + a.nome +
                                                                      " Nota: " + displayNota722);
                                                }

                                                break;
                                            case 723: // especial
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina723 = input.nextLine();
                                                
                                                int indiceExame723 = findExameEspecial(examesEspeciaisList,disciplina723);
                                                if(indiceExame723 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 72;
                                                    break;
                                                }
                                                int linha723 = 0;
                                                int indiceNota723;
                                                String displayNota723 = "Nao lancada"; // se nao encontrar a nota
                                                for(Aluno a : examesEspeciaisList.get(indiceExame723).alunosInscritos){
                                                    linha723++;
                                                    
                                                    indiceNota723 = findNotas(notasList,a,examesEspeciaisList.get(indiceExame723));
                                                    if(indiceNota723 >=0)// encontra a nota
                                                        displayNota723 = Float.toString(notasList.get(indiceNota723).classificacao);
                                                    
                                                    System.out.println(linha723 + ")"+
                                                                      " Nome: " + a.nome +
                                                                      " Nota: " + displayNota723);
                                                }

                                                break;
                                    case 73: // Listar exames em que um aluno está inscrito e classificações obtidas, caso existam
                                        System.out.println("Numero do aluno");
                                        int numeroAluno73 = input.nextInt(); input.nextLine();
                                        int indexAluno73 = findAluno(alunosList,numeroAluno73);
                                        if(indexAluno73 == -1){
                                            System.out.println("Aluno nao encontrado");
                                            menu = 7;
                                        }
                                        int linha73 = 0;
                                        String epoca73 = "";
                                        String nota73 = "Nao lancada";
                                        // porcura todos os exames do aluno
                                        for(Exame e :alunosList.get(indexAluno73).exames){
                                            
                                            if(e instanceof  ExameNormal){       // normais
                                                ExameNormal en = (ExameNormal)e;
                                                epoca73 = "normal";
                                                for(Notas n : en.notas){ // procura dentro das notas desse exame
                                                    if(n.aluno == alunosList.get(indexAluno73)){ 
                                                        nota73 = Float.toString(n.classificacao);// a nota do aluno
                                                    }
                                                }
                                            }
                                            else if(e instanceof  ExameRecurso){ // recurso
                                                ExameRecurso er = (ExameRecurso)e;
                                                epoca73 = "recurso";
                                                for(Notas n : er.notas){ // procura dentro das notas desse exame
                                                    if(n.aluno == alunosList.get(indexAluno73)){ 
                                                        nota73 = Float.toString(n.classificacao);// a nota do aluno
                                                    }
                                                }
                                            }
                                            else if(e instanceof  ExameEspecial){ // especiais
                                                ExameEspecial en = (ExameEspecial)e;
                                                epoca73 = "especial";
                                                for(Notas n : en.notas){ // procura dentro das notas desse exame
                                                    if(n.aluno == alunosList.get(indexAluno73)){ 
                                                        nota73 = Float.toString(n.classificacao);// a nota do aluno
                                                    }
                                                }
                                            }
                                            System.out.println(linha73 + ")" +
                                                              " Disciplina: " + e.disciplina.nome +
                                                              " Epoca: " + epoca73 +
                                                              " Nota: " + nota73);
                                        }
                                        menu = 7;
                                        break;
                                    case 74: // Listar docentes e funcionários associados a um exame
                                        System.out.println("1) Epoca normal");
                                        System.out.println("2) Epoca recurso");
                                        System.out.println("3) Epoca especial");
                                        System.out.println("0) Voltar");
                                        
                                        readInt = input.nextInt(); input.nextLine();
                                        if(readInt == 0){
                                            menu = 0;
                                            break;
                                        }
                                        if(readInt >=1 && readInt <= 3)
                                            menu = 740 + readInt;
                                        
                                        break;
                                            case 741: // normal
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina741 = input.nextLine();
                                                
                                                int indiceExame741 = findExameNormal(examesNormaisList,disciplina741);
                                                if(indiceExame741 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 74;
                                                    break;
                                                }
                                                int linha741 = 0;
                                                for(Docente d : examesNormaisList.get(indiceExame741).listaVigilantesDocentes){
                                                    linha741++;
                                                    System.out.println(linha741 + ")" +
                                                                      " Titulo: Docente" +
                                                                      " Nome: " + d.nome +
                                                                      " Numero mecanografico: " + d.numeroMecanografico +
                                                                      " Categoria: " + d.categoria + 
                                                                      " Area de investigacao" + d.areaInvestigacao);
                                                }
                                                linha741 = 0;
                                                for(NaoDocente nd : examesNormaisList.get(indiceExame741).listaVigilantesNaoDocentes){
                                                    linha741++;
                                                    System.out.println(linha741 + ")" +
                                                                      " Titulo: Nao Docente" +
                                                                      " Nome: " + nd.nome +
                                                                      " Numero mecanografico: " + nd.numeroMecanografico +
                                                                      " Categoria: " + nd.categoria + 
                                                                      " Cargo" + nd.cargo);
                                                }
                                                menu = 74;
                                                break;
                                            case 742: // recurso
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina742 = input.nextLine();
                                                
                                                int indiceExame742 = findExameRecurso(examesRecursoList,disciplina742);
                                                if(indiceExame742 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 74;
                                                    break;
                                                }
                                                int linha742 = 0;
                                                for(Docente d : examesRecursoList.get(indiceExame742).listaVigilantesDocentes){
                                                    linha742++;
                                                    System.out.println(linha742 + ")" +
                                                                      " Titulo: Docente" +
                                                                      " Nome: " + d.nome +
                                                                      " Numero mecanografico: " + d.numeroMecanografico +
                                                                      " Categoria: " + d.categoria + 
                                                                      " Area de investigacao" + d.areaInvestigacao);
                                                }
                                                linha742 = 0;
                                                for(NaoDocente nd : examesRecursoList.get(indiceExame742).listaVigilantesNaoDocentes){
                                                    linha742++;
                                                    System.out.println(linha742 + ")" +
                                                                      " Titulo: Nao Docente" +
                                                                      " Nome: " + nd.nome +
                                                                      " Numero mecanografico: " + nd.numeroMecanografico +
                                                                      " Categoria: " + nd.categoria + 
                                                                      " Cargo" + nd.cargo);
                                                }
                                                menu = 74;
                                                break;
                                            case 743: // especial
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina743 = input.nextLine();
                                                
                                                int indiceExame743 = findExameEspecial(examesEspeciaisList,disciplina743);
                                                if(indiceExame743 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 74;
                                                    break;
                                                }
                                                int linha743 = 0;
                                                for(Docente d : examesEspeciaisList.get(indiceExame743).listaVigilantesDocentes){
                                                    linha743++;
                                                    System.out.println(linha743 + ")" +
                                                                      " Titulo: Docente" +
                                                                      " Nome: " + d.nome +
                                                                      " Numero mecanografico: " + d.numeroMecanografico +
                                                                      " Categoria: " + d.categoria + 
                                                                      " Area de investigacao" + d.areaInvestigacao);
                                                }
                                                linha743 = 0;
                                                for(NaoDocente nd : examesEspeciaisList.get(indiceExame743).listaVigilantesNaoDocentes){
                                                    linha743++;
                                                    System.out.println(linha743 + ")" +
                                                                      " Titulo: Nao Docente" +
                                                                      " Nome: " + nd.nome +
                                                                      " Numero mecanografico: " + nd.numeroMecanografico +
                                                                      " Categoria: " + nd.categoria + 
                                                                      " Cargo" + nd.cargo);
                                                }
                                                menu = 74;
                                                break;
                                        
                                    case 75: // Listar exames em que um docente ou funcionário está envolvido
                                        System.out.println("Numero mecanografico do funcionario");
                                        int numeroFuncionario75 = input.nextInt(); input.nextLine();
                                        
                                        int indiceFuncionario75 = findDocente(docentesList,numeroFuncionario75);
                                        if(indiceFuncionario75 >= 0 ){ // se encontrou
                                            String epoca75 = "";
                                            int linha75 = 0;
                                            for(Exame e : docentesList.get(indiceFuncionario75).exames){
                                                linha75++;
                                                if(e instanceof ExameNormal)
                                                    epoca75 = "normal";
                                                if(e instanceof ExameRecurso)
                                                    epoca75 = "recurso";
                                                if(e instanceof ExameEspecial)
                                                    epoca75 = "especial";
                                                System.out.println(linha75 + ")" +
                                                                 " Disciplina: " + e.disciplina.nome +
                                                                 " Epoca: " + epoca75 +
                                                                 " Data: " + e.data.ano + "/" + e.data.mes + "/" + e.data.dia);
                                            }
                                            menu = 7;
                                            break;
                                        }
                                        indiceFuncionario75 = findNaoDocente(naoDocentesList,numeroFuncionario75);
                                        if(indiceFuncionario75 >= 0 ){ // se encontrou
                                            String epoca75 = "";
                                            int linha75 = 0;
                                            for(Exame e : naoDocentesList.get(indiceFuncionario75).exames){
                                                linha75++;
                                                if(e instanceof ExameNormal)
                                                    epoca75 = "normal";
                                                if(e instanceof ExameRecurso)
                                                    epoca75 = "recurso";
                                                if(e instanceof ExameEspecial)
                                                    epoca75 = "especial";
                                                System.out.println(linha75 + ")" +
                                                                 " Disciplina: " + e.disciplina.nome +
                                                                 " Epoca: " + epoca75 +
                                                                 " Data: " + e.data.ano + "/" + e.data.mes + "/" + e.data.dia);
                                            }
                                            menu = 7;
                                            break;
                                        }
                                        
                                        System.out.println("Nao foi encontrado esse funcionario");
                                        
                                        break;
                                    case 76: // Listar notas de um exame
                                        System.out.println("1) Epoca normal");
                                        System.out.println("2) Epoca recurso");
                                        System.out.println("3) Epoca especial");
                                        System.out.println("0) Voltar");
                                        
                                        readInt = input.nextInt(); input.nextLine();
                                        if(readInt == 0){
                                            menu = 0;
                                            break;
                                        }
                                        if(readInt >=1 && readInt <= 3)
                                            menu = 760 + readInt;
                                        
                                        break;
                                            case 761: // normal
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina761 = input.nextLine();
                                                
                                                int indiceExame761 = findExameNormal(examesNormaisList,disciplina761);
                                                if(indiceExame761 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 76;
                                                    break;
                                                }
                                                int linha761 = 0;
                                                for(Notas n : examesNormaisList.get(indiceExame761).notas){
                                                    linha761++;
                                                    
                                                    System.out.println(linha761 + ") " +
                                                                     " Nome: " + n.aluno.nome +
                                                                     " Numero: " + n.aluno.numeroAluno +
                                                                     " Nota: " + n.classificacao);
                                                }
                                                menu = 7;

                                                break;
                                            case 762: // recurso
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina762 = input.nextLine();
                                                
                                                int indiceExame762 = findExameRecurso(examesRecursoList,disciplina762);
                                                if(indiceExame762 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 76;
                                                    break;
                                                }
                                                
                                                int linha762 = 0;
                                                for(Notas n : examesRecursoList.get(indiceExame762).notas){
                                                    linha762++;
                                                    
                                                    System.out.println(linha762 + ") " +
                                                                     " Nome: " + n.aluno.nome +
                                                                     " Numero: " + n.aluno.numeroAluno +
                                                                     " Nota: " + n.classificacao);
                                                }
                                                menu = 7;

                                                break;
                                            case 763: // especial
                                                System.out.println("Qual a disciplina do exame:");
                                                String disciplina763 = input.nextLine();
                                                
                                                int indiceExame763 = findExameEspecial(examesEspeciaisList,disciplina763);
                                                if(indiceExame763 == -1){
                                                    System.out.println("Exame nao encontrado");
                                                    menu = 76;
                                                    break;
                                                }
                                                
                                                int linha763 = 0;
                                                for(Notas n : examesEspeciaisList.get(indiceExame763).notas){
                                                    linha763++;
                                                    
                                                    System.out.println(linha763 + ") " +
                                                                     " Nome: " + n.aluno.nome +
                                                                     " Numero: " + n.aluno.numeroAluno +
                                                                     " Nota: " + n.classificacao);
                                                }
                                                menu = 7;

                                                break;
                    default:break;
                }
            }catch(NumberFormatException e){
                System.out.println(e);
            }
        }  
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
    static int findNotas(List<Notas> notasList, Aluno aluno, Exame exame){
        int i = 0;
        for(Notas n : notasList){
            if(n.aluno.numeroAluno == aluno.numeroAluno && n.exame == exame)
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
