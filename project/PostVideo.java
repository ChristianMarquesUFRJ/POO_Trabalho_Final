/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Trabalho Prático
 */

package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PostVideo implements Postavel{
    private Video video = null;
    private LocalDateTime data_postagem;
    private ArrayList<Comentario> lista_comentarios;
    private int qtde_fixados = 0;

    ///////////////////////////////
    // Construtores
    ///////////////////////////////
    public PostVideo(){
        this.lista_comentarios = new ArrayList<Comentario>();
    }

    ///////////////////////////////
    // Getts e Setts
    ///////////////////////////////
    public String getDataPostagem() {
        DateTimeFormatter padrao_formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return padrao_formatacao.format(this.data_postagem);
    }
    private void setDataPostagem() {
        this.data_postagem = LocalDateTime.now();
    }
    public Comentario getComentarios(int index) throws Exception {
        if (index >= this.getQtdeComentarios())
            throw new Exception("Nao existe o indice de comentario que foi tentado ser acessado.");
        return this.lista_comentarios.get(index);
    }
    public int getQtdeComentarios() {
        return this.lista_comentarios.size();
    }
    public int getQtdeFixados() {
        return this.qtde_fixados;
    }
    public Video getVideo(){
        return this.video;
    }

    ///////////////////////////////
    // adicionaVideo
    ///////////////////////////////
    public boolean adicionaVideo(Video video){
        // Se foi passado um video inexistente
        if (video == null)
            return false;
        this.video = video;
        return true;
    }

    ///////////////////////////////
    // comenta
    ///////////////////////////////
    public boolean comenta(String comentario_str){
        // System.out.println("COMENTA FOTO: " + comentario_str);
        Comentario comentario;
        try {
            comentario = new Comentario(comentario_str);
        } catch (Exception e) {
            // Caso seja enviado um comentario vazio
            return false;
        }
        // Se houver algum problema adicionando a foto na lista em tempo de execucao
        if (!this.lista_comentarios.add(comentario))
            return false;

        return true;
    }

    ///////////////////////////////
    // posta
    ///////////////////////////////
    public boolean posta() {
        // Nao tem video para postar
        if (this.video == null)
            return false;
        this.setDataPostagem();
        System.out.println(">>> POSTAGEM DE VIDEO [" + this.getDataPostagem() + "]");
        System.out.println("-------------------------------------------------------");
        System.out.println("\t\t\t\t\t" + this.toString());
        System.out.println("-------------------------------------------------------");
        return true;
    }

    ///////////////////////////////
    // toString
    ///////////////////////////////
    @Override
    public String toString(){
        String mensagem = "";

        // Video
        // mensagem += "\tVideo: ";
        if (this.video != null)
            mensagem += this.video + "\n";
        else
            mensagem += "<sem video>\n";

        // Lista de Comentarios
        mensagem += "\t\t\t\t\tComentarios: \n";
        if (!this.lista_comentarios.isEmpty())
            for (Comentario comentario : this.lista_comentarios)
                mensagem += "\t\t\t\t\t\t" + comentario + "\n";
        else
            mensagem += "\t\t\t\t\t\t<sem comentario>";

        return mensagem;
    }
}
