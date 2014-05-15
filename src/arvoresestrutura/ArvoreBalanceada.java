package arvoresestrutura;

public class ArvoreBalanceada {

    private NodoArvore raiz;

    public ArvoreBalanceada() {
        raiz = null;
    }

    public void insereArvore(int info) {
        NodoArvore nodo = new NodoArvore(info);
        if (raiz == null) {
            raiz = nodo;
        } else {
            NodoArvore temp = raiz;
            boolean inseriu = false;
            do {
                if (info < temp.getInfo()) {
                    if (temp.getEsquerda() == null) {
                        temp.setEsquerda(nodo);
                        inseriu = true;
                    } else {
                        temp = temp.getEsquerda();
                    }

                } else {
                    if (temp.getDireita() == null) {
                        temp.setDireita(nodo);
                        inseriu = true;
                    } else {
                        temp = temp.getDireita();
                    }
                }
            } while (!inseriu);
        }
    }

    public void calculaFB() {
        calculaFB_R(raiz);
    }

    private int calculaFB_R(NodoArvore r) {
        if (r != null) {
            int e = calculaFB_R(r.getEsquerda()) + 1;
            int d = calculaFB_R(r.getDireita()) + 1;
            r.setFB(d - e);
            return d > e ? d : e;
        } else {
            return 0;
        }
    }

    public void central() {
        centralR(raiz);
    }

    private void centralR(NodoArvore r) {
        if (r != null) {
            centralR(r.getEsquerda());
            System.out.println(" < " + r.getInfo() + " FB = " + r.getFB());
            centralR(r.getDireita());
        }
    }

    public void balanceamento() {
        NodoArvore pai = null;
        balanceamento(raiz, pai);

    }

    private NodoArvore balanceamento(NodoArvore r, NodoArvore p) {
        if (r.getFB() > -2 && r.getFB() < 2) {
            balanceamento(r.getEsquerda(), r);
            balanceamento(r.getDireita(), r);
        } else {
            if (r.getFB() > 0) {
                if (r.getDireita().getFB() > 0) {
                    //  giraesq
                } else {
                    // giradireitaesquerda 
                }
            } else {
                if (r.getEsquerda().getFB() > 0) {
                    //giradir
                } else {
                    //giradireitaesquerda
                }
            }
        }
        return r;
    }
    
    public  NodoArvore rotacaoDireita(NodoArvore p){
        NodoArvore q, temp;
        q = p.getEsquerda();
        temp = p.getDireita();
        q.setDireita(p);
        p.setEsquerda(temp);
        return q;
    }
    
    public  NodoArvore rotacaoEsquerda(NodoArvore p){
        NodoArvore q, temp;
        q = p.getDireita();
        temp = p.getEsquerda();
        q.setEsquerda(p);
        p.setDireita(temp);
        return q;
    }

    public static void main(String[] args) {
        ArvoreBalanceada a1 = new ArvoreBalanceada();
        a1.insereArvore(65);
        a1.insereArvore(85);
        a1.insereArvore(115);
        a1.insereArvore(45);
        a1.insereArvore(35);
        a1.insereArvore(25);
        a1.calculaFB();
        a1.central();

    }

}
