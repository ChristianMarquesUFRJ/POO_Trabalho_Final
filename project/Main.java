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
        System.out.println("[Teste de contador de recursos]");

        Foto foto1 = new Foto();
        Foto foto2 = new Foto();
        Video video1 = new Video();
        Video video2 = new Video();

        // Verificacoes dos IDs
        System.out.println(foto1);
        if (foto1.getID() != 0)
            throw new Exception(erro_msgs[0]);
        System.out.println(foto2);
        if (foto2.getID() != 1)
            throw new Exception(erro_msgs[0]);
        System.out.println(video1);
        if (video1.getID() != 2)
            throw new Exception(erro_msgs[0]);
        System.out.println(video2);
        if (video2.getID() != 3)
            throw new Exception(erro_msgs[0]);
    }

    public static void testeExtensaoFoto() throws Exception{
        String erro_msgs[] = {
            "Extensao que deveria estar valida, esta dando erro!",
            "Extensao que deveria estar dando erro, esta valida!"
        };
        System.out.println("[Teste de extensao de foto]");

        // Valida
        try {
            Foto foto_valida = new Foto("foto_pipoca.png");
            System.out.println("[Criando uma foto valida] " + foto_valida);
        } catch (Exception e) {
            throw new Exception(erro_msgs[0] + e.getMessage());
        }
        // Invalida
        try {
            Foto foto_invalida = new Foto("foto_pipoca.txt");
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println(">>> Houve um erro: " + e.getMessage());
        }
    }

    public static void testeResolucaoFoto() throws Exception{
        String erro_msgs[] = {
            "Resolucao que deveria estar valida, esta dando erro!",
            "Resolucao que deveria estar dando erro, esta valida!"
        };
        System.out.println("[Teste de resolucao de foto]");
        
        // Valida
        try {
            Foto foto_valida = new Foto("foto_pipoca.png", "100 PPI");
            System.out.println("[Criando uma foto valida] " + foto_valida);
        } catch (Exception e) {
            throw new Exception(erro_msgs[0] + e.getMessage());
        }
        // Invalida pelo numero
        try {
            Foto foto_invalida_numero = new Foto("foto_pipoca.png", "dez PPI");
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println(">>> Houve um erro: " + e.getMessage());
        }
        // Invalida pela unidade
        try {
            Foto foto_invalida_unidade = new Foto("foto_pipoca.png", "10 PX");
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
        System.out.println("");
        try{
            Main.testeContadorRecursos();
            System.out.println("[OK] Passou no teste de Contador de recursos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de Contador de recursos porque: " + e.getMessage());
        }

        //////////////////////////////////////
        // TESTE EXTENSAO DE FOTO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeExtensaoFoto();
            System.out.println("[OK] Passou no teste da verificacao das extensoes de fotos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste da verificacao das extensoes de fotos porque: " + e.getMessage());
        }

        //////////////////////////////////////
        // TESTE RESOLUCAO DE FOTO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeResolucaoFoto();
            System.out.println("[OK] Passou no teste da verificacao da resolucao de fotos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste da verificacao da resolucao de fotos porque: " + e.getMessage());
        }
    }
}
