package arvoresestrutura;

public class NodoArvore {

    private int info;
    private int fb;
    private NodoArvore esquerda;
    private NodoArvore direita;

    public NodoArvore(int info) {
        this.info = info;
    }

    public int getFB() {
        return fb;
    }

    public void setFB(int fb) {
        this.fb = fb;
    }

    public NodoArvore getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NodoArvore esquerda) {
        this.esquerda = esquerda;
    }

    public NodoArvore getDireita() {
        return direita;
    }

    public void setDireita(NodoArvore direita) {
        this.direita = direita;
    }

    public int getInfo() {
        return info;
    }

}
