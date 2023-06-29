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

public class PostFoto implements Postavel{
    private int qtde_fotos;
    private LocalDateTime data_postagem;
    private int qtde_fixados = 0;
    private String localizacao;
    private ArrayList<Foto> fotos;
    private ArrayList<Comentario> listaComentarios;


    ///////////////////////////////
    // Construtores
    ///////////////////////////////
    public PostFoto(){
        this.fotos = new ArrayList<Foto>();
        this.listaComentarios = new ArrayList<Comentario>();
    }

    ///////////////////////////////
    // Getts e Setts
    ///////////////////////////////
    public int getQtdeFotos() {
        return this.qtde_fotos;
    }
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
        return this.listaComentarios.get(index);
    }
    public int getQtdeComentarios() {
        return this.listaComentarios.size();
    }
    public int getQtdeFixados() {
        return this.qtde_fixados;
    }
    public String getLocalizacao() {
        return this.localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public Foto getFotoLista(int index){
        return this.fotos.get(index);
    }


    ///////////////////////////////
    // adicionaFoto
    ///////////////////////////////
    public boolean adicionaFoto(Foto foto){
        // Se foi passada uma foto inexistente
        if (foto == null)
            return false;
        // this.fotos = new ArrayList<Foto>();
        // Se houver algum problema adicionando a foto na lista em tempo de execucao
        if (!this.fotos.add(foto))
            return false;
        this.qtde_fotos++;
        return true;
    }

    ///////////////////////////////
    // excluiFoto
    ///////////////////////////////
    public boolean excluiFoto(Foto foto){
        // Se houver algum problema adicionando a foto na lista em tempo de execucao
        if (!this.fotos.remove(foto))
            return false;
        this.qtde_fotos--;
        return true;
    }

    ///////////////////////////////
    // comenta
    ///////////////////////////////
    @Override
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
        if (!this.listaComentarios.add(comentario))
            return false;

        return true;
    }

    ///////////////////////////////
    // posta
    ///////////////////////////////
    @Override
    public boolean posta() {
        if ((this.getQtdeFotos() == 0) || (this.getQtdeFotos() > 10))
            return false;
        this.setDataPostagem();
        return true;
    }

    ///////////////////////////////
    // toString
    ///////////////////////////////
    @Override
    public String toString(){
        String mensagem = "";

        // Lista de Fotos
        mensagem += "\tFotos: \n";
        if (!this.fotos.isEmpty())
            for (Foto foto : this.fotos)
                mensagem += "\t\t\t\t\t\t" + foto + "\n";
        else
            mensagem += "\t\t\t\t\t\t<sem foto>\n";

        // Lista de Comentarios
        mensagem += "\t\t\t\t\tComentarios: \n";
        // System.out.println(">>>> " + this.listaComentarios);
        if (!this.listaComentarios.isEmpty())
            for (Comentario comentario : this.listaComentarios)
                mensagem += "\t\t\t\t\t\t" + comentario + "\n";
        else
            mensagem += "\t\t\t\t\t\t<sem comentario>";

        return mensagem;
    }
}