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


    /////////////////////////////////////////////////////////////
    // POST FACTORY
    /////////////////////////////////////////////////////////////
    public static void testeCriacaoPostFactory() throws Exception {
        String erro_msgs[] = {
            "Houve um problema criando o PostVideo pelo postFactory! Nao retornou PostVideo quando deveria!",
            "Houve um problema criando o PostFoto pelo postFactory! Nao retornou PostFoto quando deveria!",
            "Ha um problema no postFactory! Deveria ter dado erro ao mandar um tipo invalido!"
        };

        // Postagem valida de PostVideo
        Postavel postagem_video = PostavelFactory.getPostavel("POSTVIDEO");
        if (postagem_video.getClass() != PostVideo.class)
            throw new Exception(erro_msgs[0]);
        System.out.println("[PostVideo] " + postagem_video);
        // Postagem valida de PostFoto
        Postavel postagem_foto = PostavelFactory.getPostavel("POSTFOTO");
        if (postagem_foto.getClass() != PostFoto.class)
            throw new Exception(erro_msgs[1]);
        System.out.println("[PostFoto] " + postagem_foto);

        // Postagem invalida
        try {
            Postavel postagem_invalida = PostavelFactory.getPostavel("POSTTEXTO");
            throw new Exception(erro_msgs[2]);
        } catch (Exception e) {
            System.out.println("[Criando um tipo invalido] Houve um erro: " + e.getMessage());
        }
    }



    /////////////////////////////////////////////////////////////
    // TESTES - MAIN
    /////////////////////////////////////////////////////////////
    public static void testePostFoto() throws Exception {
        String erro_msgs[] = {
            "Houve um problema, pois nao deveria ser possivel realizar uma postagem sem foto!",
            "Houve um problema, pois nao deveria ter problema em adicionar varias fotos na postagem de foto (entre 1 e 10)!",
            "Houve um problema, pois nao deveria ter problema em postar varias fotos (entre 1 e 10)!",
            "Houve um problema, pois nao deveria ser possivel postar acima de 10 fotos!"
        };
            
        Foto []fotos = {
            new Foto("viagem1.png", "960 DPI"),
            new Foto("viagem2.png", "960 DPI"),
            new Foto("viagem3.png", "960 DPI"),
            new Foto("viagem4.png", "960 DPI"),
            new Foto("viagem5.png", "960 DPI"),
            new Foto("viagem6.png", "960 DPI"),
            new Foto("viagem7.png", "960 DPI"),
            new Foto("viagem8.png", "960 DPI"),
            new Foto("viagem9.png", "960 DPI"),
            new Foto("viagem10.png", "960 DPI"),
            new Foto("viagem11.png", "960 DPI")
        };

        /////////////////////////////////
        // TESTE DE POSTAGEM SEM FOTO
        /////////////////////////////////
        PostFoto postagem_sem_foto = new PostFoto();
        if (!postagem_sem_foto.posta())
            System.out.println("[Tentativa de postagem sem foto] Erro: Nao eh possivel");
        else
            throw new Exception(erro_msgs[0]);

        /////////////////////////////////
        // TESTE DE POSTAGEM COM 5 FOTOS
        /////////////////////////////////
        System.out.println("\n[Postagem de 5 fotos]");
        PostFoto postagem_5_fotos = new PostFoto();
        postagem_5_fotos.comenta("Muito legal!");
        for (int i=0; i < 5; i++){
            if (!postagem_5_fotos.adicionaFoto(fotos[i]))
                throw new Exception(erro_msgs[1]);
        }
        if (!postagem_5_fotos.posta())
            throw new Exception(erro_msgs[2]);


        /////////////////////////////////
        // TESTE DE POSTAGEM COM 11 FOTOS
        /////////////////////////////////
        System.out.print("\n[Tentativa de postagem de 11 fotos] ");
        PostFoto postagem_11_fotos = new PostFoto();
        for (int i=0; i < 11; i++){
            if (!postagem_11_fotos.adicionaFoto(fotos[i]))
                throw new Exception(erro_msgs[1]);
        }
        
        if (!postagem_11_fotos.posta())
            System.out.println("Erro: Nao eh possivel");
        else
            throw new Exception(erro_msgs[3]);
    }
    public static void testePostVideo() throws Exception {
        String erro_msgs[] = {
            "Houve um problema, pois nao deveria ser possivel realizar uma postagem sem video!",
            "Houve um problema, pois nao deveria ter problema em postar tendo um video!"
        };
            
        Video video = new Video("viagem.mp4", 500);

        /////////////////////////////////
        // TESTE DE POSTAGEM SEM VIDEO
        /////////////////////////////////
        PostVideo postagem_sem_video = new PostVideo();
        if (!postagem_sem_video.posta())
            System.out.println("[Tentativa de postagem sem video] Erro: Nao eh possivel");
        else
            throw new Exception(erro_msgs[0]);

        /////////////////////////////////
        // TESTE DE POSTAGEM COM VIDEO
        /////////////////////////////////
        System.out.println("\n[Postagem com video]");
        PostVideo postagem_com_video = new PostVideo();
        postagem_com_video.adicionaVideo(video);
        if (!postagem_com_video.posta())
            throw new Exception(erro_msgs[1]);
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
        
        //////////////////////////////////////
        // TESTE CRIACAO POST FACTORY
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testeCriacaoPostFactory();
            System.out.println("[OK] Passou no teste de criacao de post factory");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de criacao de post factory porque: " + e.getMessage());
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////// TESTES GERAIS /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n[TESTES GERAIS]");
        System.out.println("\n");
        
        //////////////////////////////////////
        // TESTE POST FOTO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testePostFoto();
            System.out.println("[OK] Passou no teste de PostFoto");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de PostFoto porque: " + e.getMessage());
        }
        
        //////////////////////////////////////
        // TESTE POST VIDEO
        //////////////////////////////////////
        System.out.println("");
        try{
            Main.testePostVideo();
            System.out.println("[OK] Passou no teste de PostVideo");
        }
        catch (Exception e){
            System.out.println("[X] Nao passou no teste de PostVideo porque: " + e.getMessage());
        }
           



        System.out.println("\n");
    }

}
