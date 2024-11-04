public class SUVEletrico extends CarroEletrico{
    private double tmCarga;

    public SUVEletrico(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, 500);
        this.tmCarga = 8.0;
    }

    public double getTmCarga() {
        return tmCarga;
    }

    public void setTmCarga(double tmCarga) {
        this.tmCarga = tmCarga;
    }

}