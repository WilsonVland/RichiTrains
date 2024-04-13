package co.project.richiTrainsModel.domainTrain;

import co.edu.upb.estructuras1.linkedlist.doubly.LinkedList;
import co.project.richiTrainsModel.domainTicket.Ticket;

public class VagonPasajero extends Vagon {
    int cantidadPremium;
    int cantidadEstandar;
    int cantidadEjecutivo;
    LinkedList<Ticket> pasajeros;

    public VagonPasajero( int idVagon, int cantidadPremium, int cantidadEstandar, int cantidadEjecutivo) {
        super(idVagon);
        this.cantidadPremium = cantidadPremium;
        this.cantidadEstandar = cantidadEstandar;
        this.cantidadEjecutivo = cantidadEjecutivo;
        this.pasajeros = new LinkedList<>();
    }

    public int getCantidadPremium() {
        return cantidadPremium;
    }

    public void setCantidadPremium(int cantidadPremium) {
        this.cantidadPremium = cantidadPremium;
    }

    public int getCantidadEstandar() {
        return cantidadEstandar;
    }

    public void setCantidadEstandar(int cantidadEstandar) {
        this.cantidadEstandar = cantidadEstandar;
    }

    public int getCantidadEjecutivo() {
        return cantidadEjecutivo;
    }

    public void setCantidadEjecutivo(int cantidadEjecutivo) {
        this.cantidadEjecutivo = cantidadEjecutivo;
    }
}
