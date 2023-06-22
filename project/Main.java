/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Trabalho Prático
 */

package project;
/////////////////////////////////////////////////////////////////////////////
// COMANDO DE EXECUCAO
// javac .\project\*.java; java project.Main; rm .\project\*.class
/////////////////////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        Foto foto1 = new Foto();
        Foto foto2 = new Foto();
        Video video1 = new Video();
        Video video2 = new Video();
        System.out.println("FOTO ID: " + foto1.getID());
        System.out.println("FOTO ID: " + foto2.getID());
        System.out.println("VIDEO ID: " + video1.getID());
        System.out.println("VIDEO ID: " + video2.getID());
    }
}
