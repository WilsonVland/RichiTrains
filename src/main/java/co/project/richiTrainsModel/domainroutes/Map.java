package co.project.richiTrainsModel.domainroutes;

import co.edu.upb.estructuras1.graphs.Grafo;
import co.edu.upb.estructuras1.linkedlist.Singly.LinkedList;

public class Map {

    Grafo<Station> map = new Grafo<>();

   private Station stationA = new Station("A");
   private Station stationB = new Station("B");
   private Station stationC = new Station("C");
   private Station stationD = new Station("D");
   private Station stationE = new Station("E");
   private Station stationF = new Station("F");
   private Station stationG = new Station("G");
   private Station stationH = new Station("H");
   private Station stationI = new Station("I");
   private Station stationJ = new Station("J");
   private Station stationK = new Station("K");
    
    
    public Map(){

        map.nuevoNode(stationA);
        map.nuevoNode(stationB);
        map.nuevoNode(stationC);
        map.nuevoNode(stationD);
        map.nuevoNode(stationE);
        map.nuevoNode(stationF);
        map.nuevoNode(stationG);
        map.nuevoNode(stationH);
        map.nuevoNode(stationI);
        map.nuevoNode(stationJ);
        map.nuevoNode(stationK);
        
        map.nuevoArco(stationB, stationA, 30);
        map.nuevoArco(stationA, stationF, 50);
        map.nuevoArco(stationA, stationD, 50);
        map.nuevoArco(stationA, stationC, 40);
        map.nuevoArco(stationF, stationG, 80);
        map.nuevoArco(stationG, stationH, 30);
        map.nuevoArco(stationF, stationE, 65);
        map.nuevoArco(stationD, stationE, 20);
        map.nuevoArco(stationC, stationI, 80);
        map.nuevoArco(stationC, stationJ, 120);
        map.nuevoArco(stationC, stationK, 110);
    }
    
    public Grafo<Station> getMap() {
        return map;
    }

    public void setMap(Grafo<Station> map) {
        this.map = map;
    }

    public Station getStationA() {
        return stationA;
    }
    
    public void setStationA(Station stationA) {
        this.stationA = stationA;
    }
    
    public Station getStationB() {
        return stationB;
    }
    
    public void setStationB(Station stationB) {
        this.stationB = stationB;
    }
    
    public Station getStationC() {
        return stationC;
    }
    
    public void setStationC(Station stationC) {
        this.stationC = stationC;
    }
    
    public Station getStationD() {
        return stationD;
    }
    
    public void setStationD(Station stationD) {
        this.stationD = stationD;
    }
    
    public Station getStationE() {
        return stationE;
    }
    
    public void setStationE(Station stationE) {
        this.stationE = stationE;
    }
    
    public Station getStationF() {
        return stationF;
    }
    
    public void setStationF(Station stationF) {
        this.stationF = stationF;
    }
    
    public Station getStationG() {
        return stationG;
    }
    
    public void setStationG(Station stationG) {
        this.stationG = stationG;
    }
    
    public Station getStationH() {
        return stationH;
    }
    
    public void setStationH(Station stationH) {
        this.stationH = stationH;
    }
    
    public Station getStationI() {
        return stationI;
    }
    
    public void setStationI(Station stationI) {
        this.stationI = stationI;
    }
    
    public Station getStationJ() {
        return stationJ;
    }
    
    public void setStationJ(Station stationJ) {
        this.stationJ = stationJ;
    }
    
    public Station getStationK() {
        return stationK;
    }
    
    public void setStationK(Station stationK) {
        this.stationK = stationK;
    }

    public LinkedList<Station> getEfectiveRoute(Station start, Station end){
        return map.menorRecorridoNodes(map, start, end);
    }

    public float getKmRoute(Station start, Station end){
        return map.minDistanciaPeso(map, start, end);
    }
    
    public LinkedList<Station> buildRoute(LinkedList<Station> stations){
        return stations;
    }
}
