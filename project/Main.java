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
    public static void testeContadorRecursos() throws Exception{
        String erro_msgs[] = {"Contagem de ID invalida!"};
        Foto foto1 = new Foto();
        Foto foto2 = new Foto();
        Video video1 = new Video();
        Video video2 = new Video();
        // Verificacoes dos IDs
        System.out.println("FOTO ID: " + foto1.getID());
        if (foto1.getID() != 0)
            throw new Exception(erro_msgs[0]);
        System.out.println("FOTO ID: " + foto2.getID());
        if (foto2.getID() != 1)
            throw new Exception(erro_msgs[0]);
        System.out.println("VIDEO ID: " + video1.getID());
        if (video1.getID() != 2)
            throw new Exception(erro_msgs[0]);
        System.out.println("VIDEO ID: " + video2.getID());
        if (video2.getID() != 3)
            throw new Exception(erro_msgs[0]);
    }

    public static void testeExtensaoFoto() throws Exception{
        String erro_msgs[] = {
            "Extensao que deveria estar valida, esta dando erro!",
            "Extensao que deveria estar dando erro, esta valida!"
        };
        // Valida
        try {
            Foto foto_valida = new Foto("img.png");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(erro_msgs[0]);
        }
        // Invalida
        try {
            Foto foto_invalida = new Foto("img.txt");
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println(">>> Houve um erro: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        System.out.println("\n[TESTES UNITARIOS]");

        //////////////////////////////////////
        // TESTE CONTADOR DE RECURSOS
        //////////////////////////////////////
        try{
            Main.testeContadorRecursos();
            System.out.println(">> Passou no teste de Contador de recursos");
        }
        catch (Exception e){
            System.out.println(">> Nao passou no teste de Contador de recursos porque: " + e.getMessage());
        }

        //////////////////////////////////////
        // TESTE CONTADOR DE RECURSOS
        //////////////////////////////////////
        try{
            Main.testeExtensaoFoto();
            System.out.println(">> Passou no teste da verificacao das extensoes de fotos");
        }
        catch (Exception e){
            System.out.println(">> Nao passou no teste da verificacao das extensoes de fotos porque: " + e.getMessage());
        }
    }
}
