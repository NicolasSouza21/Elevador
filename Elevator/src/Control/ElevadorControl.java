package Control;

import java.util.ArrayList;
import java.util.List;
import Model.ElevatorModel.Elevador;

public class ElevadorControl {
    private List<Elevador> elevadores;

    public ElevadorControl(int numeroElevadores, int numeroAndares) {
        this.elevadores = new ArrayList<>();
        for (int i = 0; i < numeroElevadores; i++) {
            elevadores.add(new Elevador(numeroAndares));
        }
    }

    public List<Elevador> getElevadores() {
        return elevadores;
    }

    public void chamarElevador(int numeroElevador, int destino) {
        if (numeroElevador >= 0 && numeroElevador < elevadores.size()) {
            elevadores.get(numeroElevador).chamar(destino);
        } else {
            System.out.println("Número de elevador inválido");
        }
    }

    public void exibirEstadoElevadores() {
        for (int i = 0; i < elevadores.size(); i++) {
            Elevador elevador = elevadores.get(i);
            System.out.println("Elevador " + i + ": Andar Atual - " + elevador.getAndarAtual() +
                    ", Em Movimento - " + elevador.isEmMovimento() +
                    ", Chamadas Pendentes - " + elevador.getChamadasPendentes());
        }
    }

    public int getNumeroElevadores() {
        return elevadores.size();  // Correção do método para retornar o número de elevadores
    }

    // Método adicionado para corrigir o erro
    public void exibirEstadoGeral() {
        System.out.println("Estado Geral dos Elevadores:");
        exibirEstadoElevadores();
    }

    public static void main(String[] args) {
        ElevadorControl elevadorControl = new ElevadorControl(2, 10); // Substitua 2 e 10 pelos valores desejados
        elevadorControl.exibirEstadoGeral(); // Exemplo de chamada para exibir o estado geral
    }
}
