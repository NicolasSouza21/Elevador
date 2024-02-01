package Model;

import java.util.ArrayList;
import java.util.List;

public class ElevatorModel {
    public static class Elevador {
    private int numeroAndares;
    private int andarAtual;
    private boolean emMovimento;
    private List<Integer> chamadasPendentes;

    public Elevador(int numeroAndares) {
        this.numeroAndares = numeroAndares;
        this.andarAtual = 0;  // Térreo
        this.emMovimento = false;
        this.chamadasPendentes = new ArrayList<>();
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public boolean isEmMovimento() {
        return emMovimento;
    }

    public List<Integer> getChamadasPendentes() {
        return chamadasPendentes;
    }

    public void chamar(int destino) {
        if (destino >= 0 && destino < numeroAndares && !chamadasPendentes.contains(destino)) {
            chamadasPendentes.add(destino);
            if (!emMovimento) {
                mover();
            }
        } else {
            System.out.println("Chamada inválida para o andar " + destino);
        }
    }

    private void mover() {
        emMovimento = true;
        while (!chamadasPendentes.isEmpty()) {
            int proximoAndar = chamadasPendentes.remove(0);
            System.out.println("Elevador em movimento para o andar " + proximoAndar);
            andarAtual = proximoAndar;
        }
        emMovimento = false;
        System.out.println("Elevador chegou ao andar " + andarAtual);
    }

    public static Elevador Elevador(int numeroAndares2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Elevador'");
    }

   
}

    
}
