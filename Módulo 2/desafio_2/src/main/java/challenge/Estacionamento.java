package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {

        if (carro.getMotorista() == null) {
            throw new EstacionamentoException("Não deve ter carro autonomo");
        }

        if(carro.getMotorista().getIdade() < 18) {
            throw new EstacionamentoException("O motorista deve ser maior de idade");
        }

        if (carro.getMotorista().getPontos() > 20) {
            throw new EstacionamentoException("O motorista não deve ser maior 20 pontos");
        }

        if (carrosEstacionados.size() < 10) {
            carrosEstacionados.add(carro);
        } else if (carrosEstacionados.get(0).getMotorista().getIdade() > 55) {
            for (Carro car : carrosEstacionados) {
                if (car.getMotorista().getIdade() <= 55) {
                    carrosEstacionados.remove(car);
                    carrosEstacionados.add(carro);
                    return;
                }
            }
            throw new EstacionamentoException("Não deve ultrapassar a quantidade de carros");
        } else {
            carrosEstacionados.remove(carrosEstacionados.get(0));
            carrosEstacionados.add(carro);
        }

    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }
}
