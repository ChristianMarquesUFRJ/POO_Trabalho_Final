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

public class Comentario {
    private LocalDateTime data;
    private boolean fixado = false;
    private int tamanho;
    private String texto;

    /////////////////////////////////////
    // Construtores
    /////////////////////////////////////
    public Comentario(String texto) throws Exception{
        try{
            this.setTexto(texto);
        }
        catch (Exception e){
            throw new Exception("O comentario '" + texto + "' nao pode ser criado. " + e.getMessage());
        }
        this.setDataComentario();
        this.setTamanho();
    }
    public Comentario(String texto, boolean fixado) throws Exception{
        this(texto);
        this.setFixado(fixado);
    }

    /////////////////////////////////////
    // data
    /////////////////////////////////////
    public LocalDateTime getData() {
        return data;
    }
    private void setDataComentario() {
        this.data = LocalDateTime.now();
    }

    /////////////////////////////////////
    // fixado
    /////////////////////////////////////
    public boolean isFixado() {
        return fixado;
    }
    public void setFixado(boolean fixado) {
        this.fixado = fixado;
    }
    
    /////////////////////////////////////
    // tamanho
    /////////////////////////////////////
    public int getTamanho() {
        return tamanho;
    }
    private void setTamanho(){
        this.tamanho = this.getTexto().length();
    }

    
    /////////////////////////////////////
    // texto
    /////////////////////////////////////
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) throws Exception {
        if (texto.equals(new String("")))
            throw new Exception("Texto nao pode estar vazio!");
        this.texto = texto;
    }

    
    /////////////////////////////////////
    // toString
    /////////////////////////////////////
    @Override
    public String toString(){
        return "Comentario " + (this.isFixado()?"":"nao") + " fixado: Data: " + this.getData() + " | Caracteres: " + this.getTamanho() + " |  Texto: '" + this.getTexto() + "'";
    }
}
