import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Viagem {
    private Motorista motorista;
    private CarroEletrico carro;
    private String destino;
    private double kilometragem;
    private Scanner scanner;
    private List<Viagem> viagens;
    private List<Motorista> motoristas; 
    private List<CarroEletrico> veiculos; 
    private List<Eletroposto> eletropostos; 
    private Eletroposto eletroposto;

    public Viagem(Motorista motorista, CarroEletrico carro, String destino, double kilometragem, 
                  List<Motorista> motoristas, List<CarroEletrico> veiculos, List<Eletroposto> eletropostos) {
        this.motorista = motorista;
        this.carro = carro;
        this.destino = destino;
        this.kilometragem = kilometragem;
        this.scanner = new Scanner(System.in);
        this.viagens = new ArrayList<>();
        this.motoristas = motoristas; // Atribui a lista recebida
        this.veiculos = veiculos; // Atribui a lista recebida
        this.eletropostos = eletropostos; // Atribui a lista recebida
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    public void setCarro(CarroEletrico carro) {
        this.carro = carro;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(double kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String toString() {
        return "Motorista: " + motorista.getNome() + " Kilometragem: " + kilometragem +
               " Veículo utilizado: " + carro.getModelo() + " Destino: " + destino + "\n";
    }

    public void iniciarViagem() {
        try {
            System.out.print("Digite o ID do motorista: ");
            int idMotorista = scanner.nextInt();
            Motorista motoristaSelecionado = null;

            for (Motorista m : motorista.getMotoristas()) {
                if (m.getId() == idMotorista) {
                    motoristaSelecionado = m;
                    break;
                }
            }

            if (motoristaSelecionado == null) {
                System.out.println("Erro: Motorista não encontrado.");
                return;
            }

            System.out.print("Digite o ID do veículo: ");
            int idVeiculo = scanner.nextInt();
            CarroEletrico carroSelecionado = null;

            for (CarroEletrico c : carro.getVeiculos()) {
                if (c.getId() == idVeiculo) {
                    carroSelecionado = c;
                    break;
                }
            }

            if (carroSelecionado == null) {
                System.out.println("Erro: Veículo não encontrado.");
                return;
            }

            // Consumir a linha pendente após o `nextInt`
            scanner.nextLine(); 
            
            System.out.print("Digite o destino: ");
            String destino = scanner.nextLine();
            System.out.print("Digite a distância da viagem (em km): ");
            double distancia = scanner.nextDouble();

            // Verifica se a distância excede a autonomia do veículo
            if (distancia > carroSelecionado.getAutonomia()) {
                System.out.println("A distância excede a autonomia do veículo!");
                int recargasNecessarias = (int) Math.ceil(distancia / carroSelecionado.getAutonomia());

                System.out.println("Você precisará de " + recargasNecessarias + " recarga(s) para completar a viagem.");
                System.out.println("Eletropostos disponíveis:");
                for (Eletroposto e : eletroposto.getEletropostos()) {
                    System.out.println("ID: " + e.getId() + ", Localização: " + e.getLocalizacao());
                }

                for (int i = 0; i < recargasNecessarias; i++) {
                    System.out.print("Escolha o ID do eletroposto para recarga " + (i + 1) + ": ");
                    int idEletroposto = scanner.nextInt();
                    Eletroposto eletropostoEscolhido = null;

                    for (Eletroposto e : eletroposto.getEletropostos()) {
                        if (e.getId() == idEletroposto) {
                            eletropostoEscolhido = e;
                            break;
                        }
                    }

                    if (eletropostoEscolhido != null) {
                        eletropostoEscolhido.recarregar(carroSelecionado);
                    } else {
                        System.out.println("Eletroposto não encontrado. Viagem cancelada.");
                        return;
                    }
                }
            }

            carroSelecionado.setAutonomia(carroSelecionado.getAutonomia() - distancia);
            System.out.println("Viagem iniciada com sucesso pelo motorista " + motoristaSelecionado.getNome() +
                               " no veículo " + carroSelecionado.getModelo() + ". Distância: " + distancia + " km.");
            Viagem novaViagem = new Viagem(motoristaSelecionado, carroSelecionado, destino, distancia, motoristas, veiculos, eletropostos);
            viagens.add(novaViagem);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite valores corretos.");
            scanner.nextLine(); // Limpa a entrada
        }
    }
}
