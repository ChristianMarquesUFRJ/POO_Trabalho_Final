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
    public Foto(String url_recurso) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL");
        try {
            this.setUrlRecurso(url_recurso);
        } catch (Exception e) {
            throw new Exception("A foto nao pode ser criada. " + e.getMessage());
        }
    }
    public Foto(String url_recurso, String resolucao) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL E RESOLUCAO");
        this(url_recurso);
        try {
            this.setResolucao(resolucao);
        } catch (Exception e) {
            throw new Exception("A foto nao pode ser criada. " + e.getMessage());
        }
    }

    //////////////////////////////////
    // resolucao
    //////////////////////////////////
    public String getResolucao() {
        return resolucao;
    }
    public void setResolucao(String resolucao) throws Exception {
        // System.out.println("SET RESOLUCAO FOTO");
        try {
            this.validaResolucao(resolucao);
        } catch (Exception e) {
            throw new Exception("A resolucao '" + resolucao + "' nao eh valida. " + e.getMessage());
        }
        this.resolucao = resolucao.toUpperCase();
    }

    //////////////////////////////////
    // validaURLRecurso
    //////////////////////////////////
    @Override
    public boolean validaURLRecurso(String str){
        // System.out.println("VALIDA URL EM FOTO");
        String extensao = str.substring(str.length() - 4);
        // Garante que letras maiusculas nao vao atrapalhar na comparacao
        extensao = new String(extensao.toLowerCase());
        if ((extensao.equals(".jpg")) || (extensao.equals(".png")) || (extensao.equals(".bmp")))
            return true;
        return false;
    }

    public void validaResolucao(String resolucao) throws Exception{
        // System.out.println("VALIDA RESOLUCAO EM FOTO");
        String resolucao_unidade = "";
        String[] resolucao_split = resolucao.split(" ", 2);
        // Teste do valor numerico da resolucao
        try{
            Integer.parseInt(resolucao_split[0]);
        }
        catch (Exception e){
            throw new Exception("Nao foi passado o valor numerico da resolucao!");
        }
        // Garante que letras maiusculas nao vao atrapalhar na comparacao
        resolucao_unidade = new String(resolucao_split[1].toUpperCase());
        if ((!resolucao_unidade.equals("PPI")) && (!resolucao_unidade.equals("DPI")))
            throw new Exception("Nao foi passada a unidade correta da resolucao ['PPI' ou 'DPI']!");
    }

    //////////////////////////////////
    // setUrlRecurso
    //////////////////////////////////
    @Override
    public void setUrlRecurso(String url_recurso) throws Exception {
        // System.out.println("SET URL FOTO");
        if (!this.validaURLRecurso(url_recurso))
            throw new Exception("A URL '" + url_recurso + "' possui extensao invalida!");
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
