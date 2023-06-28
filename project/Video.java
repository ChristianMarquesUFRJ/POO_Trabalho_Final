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
    // validaURLRecurso
    //////////////////////////////////
    @Override
    public boolean validaURLRecurso(String str){
        String extensao = str.substring(str.length() - 4);
        System.out.println(extensao);
        return true;
    }

    //////////////////////////////////
    // frame_rate
    //////////////////////////////////
    public int getFrameRate() {
        return frame_rate;
    }
    public void setFrameRate(int frame_rate) {
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