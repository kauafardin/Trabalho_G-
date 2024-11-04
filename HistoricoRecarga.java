import java.time.LocalDateTime;

public class HistoricoRecarga {
    private LocalDateTime dataHora;
    private String eletroposto; // Nome ou ID do eletroposto
    private double energiaRecarregada; // Energia em kWh ou km
    private CarroEletrico carro; // Referência ao carro que foi recarregado

    public HistoricoRecarga(LocalDateTime dataHora, String eletroposto, double energiaRecarregada, CarroEletrico carro) {
        this.dataHora = dataHora;
        this.eletroposto = eletroposto;
        this.energiaRecarregada = energiaRecarregada;
        this.carro = carro;
    }

    // Métodos getters para acessar as informações
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getEletroposto() {
        return eletroposto;
    }

    public double getEnergiaRecarregada() {
        return energiaRecarregada;
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    @Override
    public String toString() {
        return "Data e Hora: " + dataHora + ", Eletroposto: " + eletroposto + 
               ", Energia Recarregada: " + energiaRecarregada + 
               " km, Carro: " + carro.getModelo(); 
    }
}
