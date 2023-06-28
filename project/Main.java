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
    /////////////////////////////////////////////////////////////
    // RECURSO
    /////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////
    // FOTO
    /////////////////////////////////////////////////////////////
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
            System.out.println("[Criando uma foto invalida] Houve um erro: " + e.getMessage());
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
            System.out.println("[Criando uma foto invalida] Houve um erro: " + e.getMessage());
        }
        // Invalida pela unidade
        try {
            Foto foto_invalida_unidade = new Foto("foto_pipoca.png", "10 PX");
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println("[Criando uma foto invalida] Houve um erro: " + e.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////
    // VIDEO
    /////////////////////////////////////////////////////////////
    public static void testeExtensaoVideo() throws Exception{
        String erro_msgs[] = {
            "Extensao que deveria estar valida, esta dando erro!",
            "Extensao que deveria estar dando erro, esta valida!"
        };
        System.out.println("[Teste de extensao de video]");

        // Valida
        try {
            Video video_valido = new Video("video_pipoca.mp4");
            System.out.println("[Criando um video valido] " + video_valido);
        } catch (Exception e) {
            throw new Exception(erro_msgs[0] + e.getMessage());
        }
        // Invalida
        try {
            Video video_invalido = new Video("video_pipoca.png");
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println("[Criando um video invalido] Houve um erro: " + e.getMessage());
        }
    }

    public static void testeDuracao() throws Exception{
        String erro_msgs[] = {
            "Duracao que deveria estar valida, esta dando erro!",
            "Duracao que deveria estar dando erro, esta valida!"
        };
        System.out.println("[Teste de duracao de video]");
        
        // Valida
        try {
            Video video_valido = new Video("video_pipoca.mp4", 50);
            System.out.println("[Criando um video valido] " + video_valido);
        } catch (Exception e) {
            throw new Exception(erro_msgs[0] + e.getMessage());
        }
        // Invalido por ser negativo
        try {
            Video video_invalido = new Video("video_pipoca.mp4", -50);
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println("[Criando um video invalido] Houve um erro: " + e.getMessage());
        }
        // Invalida pela duracao ser igual a zero
        try {
            Video video_invalido = new Video("video_pipoca.mp4", 0);
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println("[Criando um video invalido] Houve um erro: " + e.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////
    // COMENTARIO
    /////////////////////////////////////////////////////////////
    public static void testeCriacaoComentario() throws Exception{
        String erro_msgs[] = {
            "Comentario que deveria estar valido, esta dando erro!",
            "Comentario que deveria estar dando erro, esta valido!"
        };
        System.out.println("[Teste de criacao de comentario]");
        
        // Valido
        try {
            Comentario comentario_valido = new Comentario("Muito bom!");
            System.out.println("[Criando um comentario valido] " + comentario_valido);
        } catch (Exception e) {
            throw new Exception(erro_msgs[0] + e.getMessage());
        }
        // Invalido por estar vazio
        try {
            Comentario comentario_invalido = new Comentario("");
            throw new Exception(erro_msgs[1]);
        } catch (Exception e) {
            System.out.println("[Criando um comentario invalido] Houve um erro: " + e.getMessage());
        }
    }

    public static void testeFixacaoComentario() throws Exception{
        String erro_msgs[] = {
            "Comentario que comecou nao fixado, permanece nao fixado apos mandar ele ser fixo!",
            "Comentario que comecou fixado, permanece fixado apos mandar ele ser nao fixo!"
        };
        System.out.println("[Teste de fixacao de comentario]");
        Comentario comentario_nao_fixado = new Comentario("Comentario inicialmente nao fixado", false);
        Comentario comentario_fixado = new Comentario("Comentario inicialmente fixado", true);

        // Passando comentario inicialmente nao fixado para fixado
        comentario_nao_fixado.setFixado(true);
        System.out.println("[Fixando comentario] " + comentario_nao_fixado);
        if (!comentario_nao_fixado.isFixado())
            throw new Exception(erro_msgs[0]);

        // Passando comentario inicialmente fixado para nao fixado
        comentario_fixado.setFixado(false);
        System.out.println("[Desfixando comentario] " + comentario_fixado);
        if (comentario_fixado.isFixado())
            throw new Exception(erro_msgs[1]);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////// MAIN /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////// TESTES UNITARIOS DE FUNCIONAMENTO /////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

        //////////////////////////////////////
        // TESTE EXTENSAO DE VIDEO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeExtensaoVideo();
            System.out.println("[OK] Passou no teste da verificacao das extensoes de videos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste da verificacao das extensoes de videos porque: " + e.getMessage());
        }

        //////////////////////////////////////
        // TESTE DURACAO DE VIDEO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeDuracao();
            System.out.println("[OK] Passou no teste da verificacao da duracao de videos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste da verificacao da duracao de videos porque: " + e.getMessage());
        }
        
        //////////////////////////////////////
        // TESTE CRIACAO COMENTARIO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeCriacaoComentario();
            System.out.println("[OK] Passou no teste da criacao do comentarios");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste da criacao do comentarios porque: " + e.getMessage());
        }
        
        //////////////////////////////////////
        // TESTE FIXAR COMENTARIO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeFixacaoComentario();
            System.out.println("[OK] Passou no teste de fixacao de comentarios");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de fixacao de comentarios porque: " + e.getMessage());
        }

        System.out.println("\n");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////// TESTES GERAIS /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // System.out.println("\n[TESTES GERAIS]");
        // System.out.println("\n");
    }
}
