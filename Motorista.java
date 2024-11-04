import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Motorista {
    private String nome;
    private int id;
    private int cnh;
    private String nivelExperiencia;
    private Scanner scanner;
    private List<Motorista> motoristas;
    
    public Motorista(String nome, int id, int cnh, String nivelExperiencia) {
        this.nome = nome;
        this.id = id;
        this.cnh = cnh;
        this.nivelExperiencia = nivelExperiencia;
        this.scanner = new Scanner(System.in);
        this.motoristas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCnh() {
        return cnh;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    @Override
    public String toString(){
        return " Nome: " + nome + "\n ID: " + id + "\n CNH: " + cnh + "\n Nível de Experiência: " + nivelExperiencia + "\n";
    }
    
    // Métodos para gerenciar motoristas
    public void cadastrarMotorista() {
        try {
            System.out.println("Digite o nome do motorista:");
            String nome = scanner.nextLine();
            System.out.println("Digite o ID do motorista:");
            int id = scanner.nextInt();
            System.out.println("Digite a CNH do motorista:");
            int cnh = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.println("Digite o nível de experiência [iniciante, intermediário, avançado]:");
            String nivelExperiencia = scanner.nextLine();

            Motorista motorista = new Motorista(nome, id, cnh, nivelExperiencia);

            for (Motorista m : motoristas) {
                if (m.getId() == motorista.getId()) {
                    System.out.println("Erro: Já existe um motorista com o ID " + motorista.getId());
                    return;
                }
            }

            motoristas.add(motorista);
            System.out.println("Motorista " + motorista.getNome() + " cadastrado!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite valores corretos.");
            scanner.nextLine(); // Limpar a entrada inválida
        }
    }

    public void listarMotoristas() {
        if (motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados!");
        } else {
            System.out.println("Motoristas: ");
            for (Motorista motorista : motoristas) {
                System.out.println(motorista);
            }
        }
    }

    // Métodos para gerenciar motoristas
    public void gerenciarMotoristas() {
        while (true) {
            System.out.println("\n### MENU GERENCIAMENTO DE MOTORISTAS ###");
            System.out.println("1 - Cadastrar Motorista");
            System.out.println("2 - Listar Motoristas");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarMotorista();
                    break;
                case 2:
                    listarMotoristas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}