import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Eletroposto {
    private int id;
    private String localizacao;
    private int vagasCarregamento;
    private double TMCarregamento;
    private Scanner scanner;
    private List<Eletroposto> eletropostos;
    private List<HistoricoRecarga> historicoRecargas; // Lista para armazenar o histórico


    public Eletroposto(int id, String localizacao, int vagasCarregamento, double TMCarregamento){
        this.id = id;
        this.localizacao = localizacao;
        this.vagasCarregamento = vagasCarregamento;
        this.TMCarregamento = TMCarregamento;
        this.scanner = new Scanner(System.in);
        this.eletropostos = new ArrayList<>();
        this.historicoRecargas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getvagasCarregamento() {
        return vagasCarregamento;
    }

    public void setvagasCarregamento(int vagasCarregamento) {
        this.vagasCarregamento = vagasCarregamento;
    }

    public double getTMCarregamento() {
        return TMCarregamento;
    }

    public void setTMCarregamento(double tMCarregamento) {
        TMCarregamento = tMCarregamento;
    }

    public List<Eletroposto> getEletropostos() {
        return eletropostos;
    }

    public void setEletropostos(List<Eletroposto> eletropostos) {
        this.eletropostos = eletropostos;
    }

    @Override
    public String toString() {
        return " ID: " + id + "\n Local: " + localizacao + "\n Vagas disponíveis: " + vagasCarregamento +
               "\n Tempo médio de carregamento: " + TMCarregamento + " horas\n";
    }

    public void ocuparVaga() {
        if (vagasCarregamento > 0) {
            vagasCarregamento--;
        }
    }

    public void liberarVaga() {
        vagasCarregamento++;
    }

    // Métodos para gerenciar eletropostos
    public void registrarEletroposto() {
        try {
            System.out.println("Digite o ID do eletroposto:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.println("Digite a localização do eletroposto:");
            String localizacao = scanner.nextLine();
            System.out.println("Quantas vagas:");
            int vagasCarregamento = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.println("Digite o tempo de carregamento:");
            double TMCarregamento = scanner.nextDouble();

            Eletroposto eletroposto = new Eletroposto(id, localizacao, vagasCarregamento, TMCarregamento);
            for (Eletroposto e : eletropostos) {
                if (e.getId() == eletroposto.getId()) {
                    System.out.println("Erro: Já existe um eletroposto com o ID " + eletroposto.getId());
                    return;
                }
            }

            eletropostos.add(eletroposto);
            System.out.println("Eletroposto " + eletroposto.getId() + " registrado!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite valores corretos.");
            scanner.nextLine(); // Limpar a entrada inválida
        }
    }

    public void consultarEletropostosDisponiveis() {
        System.out.println("Digite a localização para consultar eletropostos:");
        String localizacao = scanner.nextLine();
        boolean encontrado = false;
        if (eletropostos.isEmpty()) {
            System.out.println("Não há eletropostos registrados!");
        } else {
            for (Eletroposto eletroposto : eletropostos) {
                if (eletroposto.getLocalizacao().equals(localizacao)) {
                    System.out.println("Eletropostos Disponíveis: \n" + eletroposto.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum eletroposto encontrado no local " + localizacao + ".");
            }
        }
    }

    public void recarregar(CarroEletrico carro) {
        double autonomiaAtual = carro.getAutonomia();
        double capacidadeBateria = carro.getCapacidadeBateria();
        double cargaNecessaria = capacidadeBateria - autonomiaAtual;
    
        if (cargaNecessaria <= 0) {
            System.out.println("O veículo já está totalmente carregado.");
            return;
        }
    
        // Aqui, ajustamos a autonomia do carro diretamente
        double cargaEfetiva = Math.min(cargaNecessaria, capacidadeBateria);
        carro.setAutonomia(autonomiaAtual + cargaEfetiva); // Atualiza a autonomia diretamente
        System.out.println("Carro recarregado com sucesso em " + localizacao + ". Autonomia aumentada em " + cargaEfetiva + " km.");

        // Adiciona o histórico de recarga
        HistoricoRecarga historico = new HistoricoRecarga(LocalDateTime.now(), localizacao, cargaEfetiva, carro);
        historicoRecargas.add(historico);
    }

    public List<HistoricoRecarga> getHistoricoRecargas() {
        return historicoRecargas;
    }
    
    // Métodos para gerenciar eletropostos
    public void gerenciarEletropostos() {
        while (true) {
            System.out.println("\n### MENU GERENCIAMENTO DE ELETROPOSTOS ###");
            System.out.println("1 - Registrar Eletroposto");
            System.out.println("2 - Consultar Eletropostos Disponíveis");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    registrarEletroposto();
                    break;
                case 2:
                    consultarEletropostosDisponiveis();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}