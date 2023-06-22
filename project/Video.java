/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Trabalho Prático
 */

package project;

public class Video extends Recurso{
    private int frame_rate;
    private int duracao;

    //////////////////////////////////
    // Construtores
    //////////////////////////////////
    public Video() {
    }

    //////////////////////////////////
    // frame_rate
    //////////////////////////////////
    public int getFrame_rate() {
        return frame_rate;
    }
    public void setFrame_rate(int frame_rate) {
        this.frame_rate = frame_rate;
    }
    //////////////////////////////////
    // duracao
    //////////////////////////////////
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}