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
    public Video(String url_recurso) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL");
        this.setUrlRecurso(url_recurso);
    }
    public Video(String url_recurso, String resolucao) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL E RESOLUCAO");
        this.setUrlRecurso(url_recurso);
        this.setDuracao(duracao);
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

    //////////////////////////////////
    // validaURLRecurso
    //////////////////////////////////
    @Override
    public boolean validaURLRecurso(String str){
        // System.out.println("VALIDA RECURSO EM VIDEO");
        String extensao = str.substring(str.length() - 4);
        // Garante que letras maiusculas nao vao atrapalhar na comparacao
        extensao = new String(extensao.toLowerCase());
        if ((extensao.equals(".mp4")) || (extensao.equals(".mov")) || (extensao.equals(".wmv")))
            return true;
        return false;
    }

    //////////////////////////////////
    // setUrlRecurso
    //////////////////////////////////
    @Override
    public void setUrlRecurso(String url_recurso) throws Exception {
        // System.out.println("SET URL VIDEO");
        if (!this.validaURLRecurso(url_recurso))
            throw new Exception("O video '" + url_recurso + "' nao pode ser criado porque a extensao nao eh valida!");
        this.url_recurso = url_recurso;
    }

    //////////////////////////////////
    // toString()
    //////////////////////////////////
    @Override
    public String toString(){
        return "Video: ID=" + this.getID() + " | Duracao: " + this.getDuracao() + " | URL: " + this.getUrlRecurso();
    }
}