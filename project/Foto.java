/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Trabalho Prático
 */

package project;

public class Foto extends Recurso{
    private String resolucao;

    //////////////////////////////////
    // Construtores
    //////////////////////////////////
    public Foto() {
    }
    public Foto(String _url_recurso) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL");
        this.setUrlRecurso(_url_recurso);
    }
    public Foto(String _url_recurso, String _resolucao) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL E RESOLUCAO");
        this.setUrlRecurso(_url_recurso);
        this.setResolucao(_resolucao);
    }

    //////////////////////////////////
    // resolucao
    //////////////////////////////////
    public String getResolucao() {
        return resolucao;
    }
    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    //////////////////////////////////
    // validaURLRecurso
    //////////////////////////////////
    @Override
    public boolean validaURLRecurso(String str){
        // System.out.println("VALIDA RECURSO EM FOTO");
        String extensao = str.substring(str.length() - 4);
        // Garante que letras maiusculas nao vao atrapalhar na comparacao
        extensao = new String(extensao.toLowerCase());
        if ((extensao.equals(".jpg")) || (extensao.equals(".png")) || (extensao.equals(".bmp")))
            return true;
        return false;
    }

    //////////////////////////////////
    // setUrlRecurso
    //////////////////////////////////
    @Override
    public void setUrlRecurso(String url_recurso) throws Exception {
        // System.out.println("SET URL FOTO");
        if (!this.validaURLRecurso(url_recurso))
            throw new Exception("A foto '" + url_recurso + "' nao pode ser criada porque a extensao nao eh valida!");
        this.url_recurso = url_recurso;
    }

    //////////////////////////////////
    // toString()
    //////////////////////////////////
    @Override
    public String toString(){
        return "Foto: ID=" + this.getID() + " | Resolucao: " + this.getResolucao() + " | URL: " + this.getUrlRecurso();
    }
}
