/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Trabalho Prático
 */

package project;

public abstract class Recurso {
    protected int ID;
    protected String url_recurso;
    private static int prox_ID = 0;
    
    //////////////////////////////////
    // Construtores
    //////////////////////////////////
    public Recurso() {
        this.ID = Recurso.prox_ID++;
    }

    //////////////////////////////////
    // recurso
    //////////////////////////////////
    public boolean validaURLRecurso(String str){
        return true;
    }
    public String getUrl_recurso() {
        return url_recurso;
    }
    public void setUrl_recurso(String url_recurso) {
        this.url_recurso = url_recurso;
    }

    //////////////////////////////////
    // id
    //////////////////////////////////
    public int getID() {
        return ID;
    }
}
