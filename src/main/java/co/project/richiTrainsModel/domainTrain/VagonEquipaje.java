package co.project.richiTrainsModel.domainTrain;

public class VagonEquipaje extends Vagon {
    float pesoTotal;
    int cantidadMaletas;

    public VagonEquipaje (int idVagon, float pesoTotal, int cantidadMaletas) {
        super(idVagon); // Add this line to invoke the super constructor
        this.pesoTotal = pesoTotal;
        this.cantidadMaletas = cantidadMaletas;
    }

    public float getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(float pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }
}
