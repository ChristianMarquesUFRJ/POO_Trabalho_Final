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
    public Recurso(String url_recurso) throws Exception {
        // System.out.println("CONTRUTOR DE RECURSO COM URL");
        try{
            this.setUrlRecurso(url_recurso);
        }
        catch (Exception e){
            throw new Exception("O recurso nao pode ser criado!" + e.getMessage());
        }
        this.ID = Recurso.prox_ID++;
    }

    //////////////////////////////////
    // recurso
    //////////////////////////////////
    public boolean validaURLRecurso(String str) throws Exception{
        // System.out.println("VALIDA RECURSO EM RECURSO");
        return true;
    }
    public String getUrlRecurso() {
        return url_recurso;
    }
    public void setUrlRecurso(String url_recurso) throws Exception {
        // System.out.println("SET URL RECURSO");
        this.url_recurso = url_recurso;
    }

    //////////////////////////////////
    // id
    //////////////////////////////////
    public int getID() {
        return ID;
    }
}
