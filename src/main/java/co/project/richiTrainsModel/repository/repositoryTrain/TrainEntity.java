package co.project.richiTrainsModel.repository.repositoryTrain;

import co.edu.upb.estructuras1.linkedlist.doubly.LinkedList;
import co.project.richiTrainsModel.domainTrain.TipoTrain;
import co.project.richiTrainsModel.domainTrain.VagonEquipaje;
import co.project.richiTrainsModel.domainTrain.VagonPasajero;

public class TrainEntity {    
    private String name;
    private String referencia;
    private TipoTrain tipo;
    private boolean inRoad;
    private float kilometraje;
    private boolean isEnabled;
    private LinkedList<VagonPasajero> vagonesPasajeros;
    private LinkedList<VagonEquipaje> vagonesEquipaje;
    
    public TrainEntity(String name, String referencia, TipoTrain tipo, boolean inRoad, float kilometraje, boolean isEnabled) {
        this.name = name;
        this.referencia = referencia;
        this.tipo = tipo;
        this.inRoad = inRoad;
        this.kilometraje = kilometraje;
        this.isEnabled = isEnabled;
        this.vagonesPasajeros = new LinkedList<>();
        this.vagonesEquipaje = new LinkedList<>();
    }
    
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public TipoTrain getTipo() {
        return tipo;
    }

    public void setTipo(TipoTrain tipo) {
        this.tipo = tipo;
    }

    public LinkedList<VagonPasajero> getVagonesPasajeros() {
        return vagonesPasajeros;
    }

    public void setVagonesPasajeros(LinkedList<VagonPasajero> vagonesPasajeros) {
        this.vagonesPasajeros = vagonesPasajeros;
    }

    public LinkedList<VagonEquipaje> getVagonesEquipaje() {
        return vagonesEquipaje;
    }

    public void setVagonesEquipaje(LinkedList<VagonEquipaje> vagonesEquipaje) {
        this.vagonesEquipaje = vagonesEquipaje;
    }

    public boolean isInRoad() {
        return inRoad;
    }

    public void setInRoad(boolean enEstacion) {
        this.inRoad = enEstacion;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }


    
}
