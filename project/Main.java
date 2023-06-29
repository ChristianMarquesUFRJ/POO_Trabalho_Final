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

    /////////////////////////////////////////////////////////////
    // POST FOTO
    /////////////////////////////////////////////////////////////
    public static void testeAdicionaFoto() throws Exception {
        String erro_msgs[] = {
            "Adicao da foto na lista eh invalido por ter passado um endereco invalido!",
            "Controle da quantidade de fotos esta invalida!",
            "A foto adicionada possui elementos diferente dos enviados!",
            "Nao houve erro ao adicionar uma foto invalida!"
        };
        System.out.println("[Teste de adicionar fotos]");

        // Adicao valida
        Foto []foto_valida = {
            new Foto("pipoca.png", "300 PPI"),
            new Foto("pipoca.png", "600 PPI")};
        PostFoto postagem_valida = new PostFoto();
        for (int i=0; i < foto_valida.length; i++){
            // Erro de adicao da foto na lista
            if (!postagem_valida.adicionaFoto(foto_valida[i]))
                throw new Exception(erro_msgs[0]);
            // Erro no quantitativo de fotos
            if (postagem_valida.getQtdeFotos() != i+1)
                throw new Exception(erro_msgs[1]);
            Foto foto_obj_valia = postagem_valida.getFotoLista(i);
            // Erro na comparacao de elementos das fotos (URL e resolucao)
            if (!foto_obj_valia.equals(foto_valida[i]))
                throw new Exception(erro_msgs[2]);
            // Visualizacao dos dados validos
            System.out.println("[Foto valida " + (i+1) + "] " + foto_valida[i]);
        }
        System.out.println("[PostFoto valida]  " + postagem_valida);

        // Adicao invalida
        Foto foto_invalida = (Foto) null;
        PostFoto postagem_invalida = new PostFoto();
        // Nao deu erro de adicao da foto na lista
        if (postagem_invalida.adicionaFoto(foto_invalida))
            throw new Exception(erro_msgs[3]);
        // Visualizacao dos dados invalidos
        System.out.print("[Foto invalida] ");
        System.out.println(foto_invalida);
        System.out.print("[PostFoto invalida]");
        System.out.println(postagem_invalida);
    }
   
    public static void testeComentaFoto() throws Exception {
        String erro_msgs[] = {
            "Adicao da foto na lista eh invalido por ter passado um endereco invalido!",
            "Controle da quantidade de fotos esta invalida!",
            "O indice acessado do vetor de teste de comentarios esta invalido! ",
            "Na tentativa de inserir um comentario invalido nao houve problema!"
        };
        String comentarios_str[] = {
            "Comentario 1",
            "Comentario 2",
            "Comentario 3",
            "Comentario 4",
            "Comentario 5",
            ""
        };
        System.out.println("[Teste de comentar em fotos]");

        Foto foto_valida = new Foto("pipoca.png", "300 PPI");
        PostFoto postagem = new PostFoto();
        postagem.adicionaFoto(foto_valida);

        // Adicao valida
        for (int i = 0; i < comentarios_str.length-1; i++){
            // Validacao de adicao de comentario
            if (!postagem.comenta(comentarios_str[i]))
                throw new Exception(erro_msgs[0]);
            // Validacao da quantidade inserida
            if (postagem.getQtdeComentarios() != i+1)
                throw new Exception(erro_msgs[1]);
            // Visualizacao dos dados individuais validos
            System.out.print("[Comentario valido] ");
            try {
                System.out.println(postagem.getComentarios(i));
            } catch (Exception e) {
                throw new Exception(erro_msgs[2] + e.getMessage());
            }
        }
        System.out.println("[PostFoto valida]  " + postagem);

        // Adicao invalida
        System.out.println("[Comentario invalido] '" + comentarios_str[comentarios_str.length-1] + "'");
        if (postagem.comenta(comentarios_str[comentarios_str.length-1]))
            throw new Exception(erro_msgs[3]);
        System.out.println("[PostFoto invalida]  " + postagem);
    } 
   
    public static void testeExcluiFoto() throws Exception {
        String erro_msgs[] = {
            "Nao conseguiu excluir uma foto que deveria poder excluir: ",
            "Conseguiu excluir uma foto que nao existia na postagem: "
        };
        System.out.println("[Teste de excluir fotos]");

        Foto []fotos = {
            new Foto("pipoca.png", "300 PPI"),
            new Foto("pipoca.png", "600 PPI"),
            new Foto("pipoca.png", "900 PPI")};
            PostFoto postagem = new PostFoto();
        for (int i=0; i < fotos.length; i++){
            postagem.adicionaFoto(fotos[i]);
            System.out.println("[Foto " + (i+1) + " adicionada] " + fotos[i]);
        }
            
        // Exclusao valida
        if (!postagem.excluiFoto(fotos[1]))
            throw new Exception(erro_msgs[0] + fotos[1]);
        System.out.println("[PostFoto valida]  " + postagem);

        // Exclusao invalida (que nao foi incluida na postagem)
        Foto foto_invalida = new Foto("pipoca.png", "10 PPI");
        // Nao deu erro de exclusao da foto na lista
        if (postagem.excluiFoto(foto_invalida))
            throw new Exception(erro_msgs[1] + foto_invalida);
        // Visualizacao dos dados invalidos
        System.out.print("[Foto invalida] ");
        System.out.println(foto_invalida);
        System.out.print("[PostFoto invalida]");
        System.out.println(postagem);
    } 


    /////////////////////////////////////////////////////////////
    // POST VIDEO
    /////////////////////////////////////////////////////////////
    public static void testeAdicionaVideo() throws Exception {
        String erro_msgs[] = {
            "Nao foi possivel inserir o video!",
            "A foto adicionada possui elementos diferente dos enviados!",
            "Nao houve erro ao adicionar uma foto invalida!"
        };
        System.out.println("[Teste de adicionar video]");

        // Adicao valida
        Video []videos_validos = {
            new Video("pipoca.mp4", 500),
            new Video("pipoca.wmv", 800)};
        PostVideo postagem_valida = new PostVideo();
        for (int i=0; i < videos_validos.length; i++){
            // Erro de adicao do video
            if (!postagem_valida.adicionaVideo(videos_validos[i]))
                throw new Exception(erro_msgs[0]);
            Video video_obj_valido = postagem_valida.getVideo();
            // Erro na comparacao de elementos dos videos (URL e duracao)
            if (!video_obj_valido.equals(videos_validos[i]))
                throw new Exception(erro_msgs[1]);
            // Visualizacao dos dados validos
            System.out.println("[Video valido " + (i+1) + "] " + videos_validos[i]);
        }
        System.out.println("[PostVideo valido]  " + postagem_valida);

        // Adicao invalida
        Video video_invalido = (Video) null;
        PostVideo postagem_invalida = new PostVideo();
        // Nao deu erro de adicao do video
        if (postagem_invalida.adicionaVideo(video_invalido))
            throw new Exception(erro_msgs[2]);
        // Visualizacao dos dados invalidos
        System.out.print("[Video invalido] ");
        System.out.println(video_invalido);
        System.out.print("[PostVideo invalido]");
        System.out.println(postagem_invalida);
    }
   
    public static void testeComentaVideo() throws Exception {
        String erro_msgs[] = {
            "Houve um problema adicionando o comentario valido!",
            "Controle da quantidade de comentarios esta invalido!",
            "O indice acessado do vetor de teste de comentarios esta invalido! ",
            "Na tentativa de inserir um comentario invalido nao houve problema!"
        };
        String comentarios_str[] = {
            "Comentario 1",
            "Comentario 2",
            "Comentario 3",
            "Comentario 4",
            "Comentario 5",
            ""
        };
        System.out.println("[Teste de comentar em fotos]");

        PostVideo postagem = new PostVideo();
        postagem.adicionaVideo(new Video("pipoca.mp4", 100));

        // Adicao valida
        for (int i = 0; i < comentarios_str.length-1; i++){
            // Validacao de adicao de comentario
            if (!postagem.comenta(comentarios_str[i]))
                throw new Exception(erro_msgs[0]);
            // Validacao da quantidade inserida
            if (postagem.getQtdeComentarios() != i+1)
                throw new Exception(erro_msgs[1]);
            // Visualizacao dos dados individuais validos
            System.out.print("[Comentario valido] ");
            try {
                System.out.println(postagem.getComentarios(i));
            } catch (Exception e) {
                throw new Exception(erro_msgs[2] + e.getMessage());
            }
        }
        System.out.println("[PostVideo valido]  " + postagem);

        // Adicao invalida
        System.out.println("[Comentario invalido] '" + comentarios_str[comentarios_str.length-1] + "'");
        if (postagem.comenta(comentarios_str[comentarios_str.length-1]))
            throw new Exception(erro_msgs[3]);
        System.out.println("[PostVideo invalido]  " + postagem);
    } 




    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////// MAIN /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////// TESTES UNITARIOS DE FUNCIONAMENTO /////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("[TESTES UNITARIOS]");

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
        
        //////////////////////////////////////
        // TESTE ADICIONA FOTO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeAdicionaFoto();
            System.out.println("[OK] Passou no teste de adicao de fotos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de adicao de fotos porque: " + e.getMessage());
        }
        
        //////////////////////////////////////
        // TESTE COMENTA FOTO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeComentaFoto();
            System.out.println("[OK] Passou no teste de comentario em fotos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de comentario em fotos porque: " + e.getMessage());
        }
        
        //////////////////////////////////////
        // TESTE EXCLUI FOTO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeExcluiFoto();
            System.out.println("[OK] Passou no teste de exclusao de fotos");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de exclusao de fotos porque: " + e.getMessage());
        }
        
        //////////////////////////////////////
        // TESTE ADICIONA VIDEO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeAdicionaVideo();
            System.out.println("[OK] Passou no teste de adicao de video");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de adicao de video porque: " + e.getMessage());
        }
        
        //////////////////////////////////////
        // TESTE COMENTA VIDEO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeComentaVideo();
            System.out.println("[OK] Passou no teste de comentario em video");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de comentario em video porque: " + e.getMessage());
        }
           



        System.out.println("\n");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////// TESTES GERAIS /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // System.out.println("\n[TESTES GERAIS]");
        // System.out.println("\n");
    }

}
