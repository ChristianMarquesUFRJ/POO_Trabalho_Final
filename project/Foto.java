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
        if (!this.validaURLRecurso(_url_recurso))
            throw new Exception("A foto nao pode ser criada porque a extensao nao eh valida!");
        else
            this.setUrlRecuso(_url_recurso);
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
    // resolucao
    //////////////////////////////////
    public String getResolucao() {
        return resolucao;
    }
    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }
}
