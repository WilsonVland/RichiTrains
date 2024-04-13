package co.project.richiTrainsModel.domainTrain;

public class TipoTrain {
    String marca;
    int cantMxVagones;

    public TipoTrain(String marca, int cantMxVagones) {
        this.marca = marca;
        this.cantMxVagones = cantMxVagones;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantMxVagones() {
        return cantMxVagones;
    }

    public void setCantMxVagones(int cantMxVagones) {
        this.cantMxVagones = cantMxVagones;
    }

    public String toString() {
        return "TipoTren{" +
                "marca='" + marca + '\'' +
                ", cantMxVagones=" + cantMxVagones +
                '}';
    }
}
