public class CarrosCompactos extends CarroEletrico{
    private double tmCarga;

    public CarrosCompactos(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, 200);
        this.tmCarga = 4.0;
    }

    public double getTmCarga() {
        return tmCarga;
    }

    public void setTmCarga(double tmCarga) {
        this.tmCarga = tmCarga;
    }

    


}