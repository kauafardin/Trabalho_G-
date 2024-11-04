
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoFrota {
    private Scanner scanner;
    private CarroEletrico carro;
    private Motorista motorista;
    private Eletroposto eletroposto;
    private Viagem viagem;
    private List<CarroEletrico> veiculos;
    private List<Motorista> motoristas;
    private List<Eletroposto> eletropostos;
  

    public GerenciamentoFrota() {
        this.scanner = new Scanner(System.in); // Inicialização do scanner
        this.carro = new CarroEletrico(0, "", "", 0, 0, 0); // Inicializa a frota
        this.motorista = new Motorista("", 0, 0, ""); // Inicializa o motorista
        this.eletroposto = new Eletroposto(0, "", 0,0); // Inicializa o eletroposto
        this.viagem = new Viagem(motorista, carro, "", 0.0, motoristas, veiculos, eletropostos); // Inicializa a viagem

    }
    // Método para interação do usuário
    public void interagirComUsuario() {
        while (true) {
            try {
                System.out.println("\n### MENU DO SISTEMA DE GESTÃO ###");
                System.out.println("1 - Gerenciar Frota");
                System.out.println("2 - Gerenciar Motoristas");
                System.out.println("3 - Gerenciar Eletropostos");
                System.out.println("4 - Iniciar Viagem");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        carro.gerenciarFrota();
                        break;
                    case 2:
                        motorista.gerenciarMotoristas();
                        break;
                    case 3:
                        eletroposto.gerenciarEletropostos();
                        break;
                    case 4:
                        viagem.iniciarViagem();
                        break;
                    case 0:
                        System.out.println("Encerrando o programa.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, escolha uma opção numérica.");
                scanner.nextLine(); // Limpar a entrada inválida
            }
        }
    }
}
