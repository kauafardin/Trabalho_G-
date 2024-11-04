import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CarroEletrico{
    private Scanner scanner;
    protected int id;
    protected String marca;
    protected String modelo;
    protected int anoFabricacao;
    protected double capacidadeBateria;
    protected double autonomiaMax;
    private List<CarroEletrico> veiculos;
    

    public CarroEletrico(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomiaMax) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.capacidadeBateria = capacidadeBateria;
        this.autonomiaMax = autonomiaMax;
        this.veiculos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(double capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public double getAutonomia() {
        return autonomiaMax;
    }

    public void setAutonomia(double autonomiaMax) {
        this.autonomiaMax = autonomiaMax;
    }

    public List<CarroEletrico> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<CarroEletrico> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return " ID: " + id + "\n Marca: " + marca + "\n Modelo: " + modelo + "\n Ano: " + anoFabricacao
                + "\n Capacidade: " + capacidadeBateria + " kWh\n Autonomia: " + autonomiaMax + " km\n";
    }

     // Métodos para gerenciar veículos
     public void adicionarVeiculos(CarroEletrico carro) {
        if (veiculos.isEmpty()){
            System.out.println("Não há veículos na frota!");
            veiculos.add(carro);
            System.out.println("Veículo " + carro.getModelo() + " adicionado à frota!");
        } else{
            for (CarroEletrico veiculo : veiculos) {
                if (veiculo.getId() == carro.getId()) {
                    System.out.println("Erro: Já existe um veículo com o ID " + carro.getId());
                    return;
                }
            }
            veiculos.add(carro);
            System.out.println("Veículo " + carro.getModelo() + " adicionado à frota!");
        }
    }

    public void removerVeiculos(int id) {
        CarroEletrico carroRemover = null;
        for (CarroEletrico carro : veiculos) {
            if (carro.getId() == id) {
                carroRemover = carro;
                break;
            }
        }
        if (carroRemover != null) {
            veiculos.remove(carroRemover);
            System.out.println("Veículo " + carroRemover.getModelo() + " retirado da frota!");
        } else {
            System.out.println("Erro: Carro não encontrado na frota.");
        }
    }

    public void listarFrota() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos na frota!");
        } else {
            System.out.println("Veículos: ");
            for (CarroEletrico carro : veiculos) {
                System.out.println(carro.toString());
            }
        }
    }

    // Métodos para gerenciar a frota
    public void gerenciarFrota() {
        while (true) {
            try {
                System.out.println("\n### MENU GERENCIAMENTO DE FROTA ###");
                System.out.println("1 - Adicionar Veículo");
                System.out.println("2 - Remover Veículo");
                System.out.println("3 - Listar Veículos");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
    
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
    
                switch (opcao) {
                    case 1:
                        System.out.println("Digite os detalhes do veículo: ");
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Ano de Fabricação: ");
                        int anoFabricacao = scanner.nextInt();
                        System.out.print("Capacidade da Bateria (kWh): ");
                        double capacidadeBateria = scanner.nextDouble();
    
                        // Escolha do tipo de carro e definição da autonomia
                        System.out.println("Escolha o tipo de carro: ");
                        System.out.println("1 - Compacto (Autonomia: 200 km)");
                        System.out.println("2 - Sedan (Autonomia: 400 km)");
                        System.out.println("3 - SUV (Autonomia: 500 km)");
    
                        int tipoCarro = scanner.nextInt();
                        double autonomiaMax;
    
                        switch (tipoCarro) {
                            case 1:
                                autonomiaMax = 200;
                                break;
                            case 2:
                                autonomiaMax = 400;
                                break;
                            case 3:
                                autonomiaMax = 500;
                                break;
                            default:
                                System.out.println("Tipo de carro inválido. Usando autonomia padrão de 200 km.");
                                autonomiaMax = 200;
                                break;
                        }
    
                        CarroEletrico novoCarro = new CarroEletrico(id, marca, modelo, anoFabricacao, capacidadeBateria, autonomiaMax);
                        adicionarVeiculos(novoCarro); 
                        break;
                    case 2:
                        System.out.print("Digite o ID do veículo a ser removido: ");
                        int idRemover = scanner.nextInt();
                        removerVeiculos(idRemover);
                        break;
                    case 3:
                        listarFrota();
                        break;
                    case 0:
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