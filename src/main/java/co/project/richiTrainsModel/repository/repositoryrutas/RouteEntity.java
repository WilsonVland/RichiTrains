package co.project.richiTrainsModel.repository.repositoryrutas;

import co.edu.upb.estructuras1.linkedlist.Singly.LinkedList;
import co.project.richiTrainsModel.domainTrain.Train;
import co.project.richiTrainsModel.domainroutes.Station;

public class RouteEntity {
    
    private Train train;
    private String id;
    private LinkedList<Station> recorrido;
    private float kmRecorrido;
    private Station inicio;
    private Station fin;

    public RouteEntity(Train train, String id, LinkedList<Station> recorrido, float kmRecorrido, Station inicio,
            Station fin) {
        this.train = train;
        this.id = id;
        this.recorrido = recorrido;
        this.kmRecorrido = kmRecorrido;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LinkedList<Station> getRecorrido() {
        return recorrido;
    }
    public void setRecorrido(LinkedList<Station> recorrido) {
        this.recorrido = recorrido;
    }
    public float getKmRecorrido() {
        return kmRecorrido;
    }
    public void setKmRecorrido(float kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }
    public Station getInicio() {
        return inicio;
    }
    public void setInicio(Station inicio) {
        this.inicio = inicio;
    }
    public Station getFin() {
        return fin;
    }
    public void setFin(Station fin) {
        this.fin = fin;
    }
}
