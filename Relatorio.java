
import java.util.List;
 
public class Relatorio {
    private List<CarroEletrico> veiculos;
    private List<Viagem> viagens;
    private List<HistoricoRecarga> historicoRecargas;

    public void autonomiaInferior(){
        if (veiculos.isEmpty()){
            System.out.println("Não há veículos na frota!");
        } else {
            for (CarroEletrico carro : veiculos){
                if ((carro.getAutonomia()/carro.getCapacidadeBateria())*100 < 20 ){
                    System.out.println(carro.toString());
                }
            }
        }
    }

    public void viagensMotoristas(String nomeMotorista){
        if (viagens.isEmpty()){
            System.out.println("Não há motoristas cadastrados!");
        } else {
            for (Viagem viagem : viagens){
                if (viagem.getMotorista().getNome().equals(nomeMotorista)){
                    System.out.println(viagem.toString());
                    System.out.println();
                }
            }
        }
    }

    public void consultarViagem(int id){
        if (historicoRecargas.isEmpty()){
            System.out.println("Não há recargas!");
        }else {
            for (HistoricoRecarga recarga : historicoRecargas){
                if (recarga.getCarro().getId() == id){
                    System.out.println(recarga.toString());
                    System.out.println();
                }
            }
        }
    }

    public void consultarMautencao(int id){
        if (historicoRecargas.isEmpty()){
            System.out.println("Não há recargas!");
        }else {
            for (HistoricoRecarga recarga : historicoRecargas){
                if (recarga.getCarro().getId() == id){
                    System.out.println(recarga.toString());
                    System.out.println();
                }
            }
        }
    }
}
