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
        this.novoRecursoValidado();
    }
    public Video(String url_recurso) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL");
        try {
            this.setUrlRecurso(url_recurso);
        } catch (Exception e) {
            throw new Exception("O video pode ser criado. " + e.getMessage());
        }
        this.novoRecursoValidado();
    }
    public Video(String url_recurso, int duracao) throws Exception{
        // System.out.println("CONTRUTOR DE FOTO COM URL E RESOLUCAO");
        try {
            this.setUrlRecurso(url_recurso);
        } catch (Exception e) {
            throw new Exception("O video nao pode ser criado. " + e.getMessage());
        }
        try {
            this.setDuracao(duracao);
        } catch (Exception e) {
            throw new Exception("O video nao pode ser criado. " + e.getMessage());
        }
        this.novoRecursoValidado();
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
    public void setDuracao(int duracao) throws Exception {
        if (duracao < 0)
            throw new Exception("Duracao nao pode ser negativa!");
        else if (duracao == 0)
            throw new Exception("Duracao igual a zero nao eh valido!");
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

    //////////////////////////////////
    // equals()
    //////////////////////////////////
    @Override
    public boolean equals(Object obj){
        // Se nao forem da mesma classe
        if (obj.getClass() != Video.class)
            return false;
        Video video = (Video) obj;
        // Se a resolucao for diferente
        if (this.getDuracao() != video.getDuracao())
            return false;
        // Se a URL for diferente
        if (!this.getUrlRecurso().equals(video.getUrlRecurso()))
            return false;
        return true;
    }
}