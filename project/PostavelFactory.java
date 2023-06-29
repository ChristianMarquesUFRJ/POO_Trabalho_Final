/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Trabalho Prático
 */

package project;
public class PostavelFactory {
    public static Postavel getPostavel(String tipo) throws Exception{
        Postavel postagem;
        if(tipo.equals("POSTVIDEO")) {
            PostVideo postagem_video = new PostVideo();
            postagem = postagem_video;
        }
        else if(tipo.equals("POSTFOTO")) {
            PostFoto postagem_foto = new PostFoto();
            postagem = postagem_foto;
        }
        else
            throw new Exception("Este tipo de postagem ('"+ tipo +"') nao existe!");
        return postagem;
    }
}
