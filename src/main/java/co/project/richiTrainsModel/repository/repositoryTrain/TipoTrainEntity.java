package co.project.richiTrainsModel.repository.repositoryTrain;

public class TipoTrainEntity {
    String marca;
    int cantMxVagones;

    public TipoTrainEntity(String marca, int cantMxVagones) {
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
}
