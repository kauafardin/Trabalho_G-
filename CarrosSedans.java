public class CarrosSedans extends CarroEletrico {
    private double tmCarga;

    public CarrosSedans(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, 400);
        this.tmCarga = 6.0; // Tempo médio de carga de 6 horas para Carros Sedans
    }

    public double getTmCarga() {
        return tmCarga;
    }

    public void setTmCarga(double tmCarga) {
        this.tmCarga = tmCarga;
    }
}