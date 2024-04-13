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
        map.nuevoArco(stationA, stationB, 30);

        map.nuevoArco(stationF, stationG, 80);
        map.nuevoArco(stationF, stationA, 50);
        map.nuevoArco(stationF, stationE, 65);

        map.nuevoArco(stationG, stationH, 30);
        map.nuevoArco(stationG, stationF, 80);

        map.nuevoArco(stationD, stationE, 20);
        map.nuevoArco(stationD, stationA, 50);

        map.nuevoArco(stationE, stationD, 20);
        map.nuevoArco(stationE, stationF, 65);

        map.nuevoArco(stationC, stationI, 80);
        map.nuevoArco(stationC, stationJ, 120);
        map.nuevoArco(stationC, stationK, 110);
        map.nuevoArco(stationC, stationA, 40);

        map.nuevoArco(stationH, stationG, 30);

        map.nuevoArco(stationI, stationC, 80);
        map.nuevoArco(stationI, stationG, 145);

        map.nuevoArco(stationJ, stationC, 120);

        map.nuevoArco(stationK, stationC, 110);
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
// me da la ruta mas efectiva entre dos estaciones
    public LinkedList<Station> getEfectiveRoute(Station start, Station end){
        return map.menorRecorridoNodes(map, start, end);
    }
// me da los km minimo entre dos estaciones
    public float getKmRoute(Station start, Station end){
        return map.minDistanciaPeso(map, start, end);
    }
// me construye la ruta mas efectiva que pase en base a la lista de estaciones por las que el admin requiere que pase
    public LinkedList<Station> buildRoute(LinkedList<Station> stations){
        LinkedList<Station> route = new LinkedList<>();

        // Verificar si se proporcionaron al menos dos estaciones
        if (stations.size() < 2) {
            System.out.println("Se deben proporcionar al menos dos estaciones.");
            return route;
        }

        for (int i = 0; i < stations.size() - 1; i++) {
            Station startStation = stations.get(i);
            Station endStation = stations.get(i + 1);

            // Verificar si se encontraron las estaciones
            if (!map.contains(startStation) || !map.contains(endStation)) {
                System.out.println("Una o ambas estaciones no existen en el mapa.");
                return route;
            }

            // Calcular la ruta más corta entre las estaciones actuales utilizando el método menorRecorridoNodes()
            LinkedList<Station> shortestPathNodes = map.menorRecorridoNodes(map, startStation, endStation);

            // Agregar las estaciones de la ruta al resultado final
            addStationsToRouteWithoutTheLast(route, shortestPathNodes); // Excluir la última estación
        }

        // Agregar la última estación a la ruta final
        route.add(stations.peekLast());

        return route;
    }
//metodo usado para el metodo de arriba
    private void addStationsToRouteWithoutTheLast(LinkedList<Station> route, LinkedList<Station> stations) {
        for (int i = 0; i < stations.size() - 1; i++) {
            route.add(stations.get(i));
        }
    }
// me calcula la distancia total minima entre una lista de estaciones que el administrador requiere que pase
    public float calculateTotalDistance(LinkedList<Station> stations) {
        float totalDistance = 0.0f;
    
        // Verificar si se proporcionaron al menos dos estaciones
        if (stations.size() < 2) {
            System.out.println("Se deben proporcionar al menos dos estaciones.");
            return totalDistance;
        }
    
        for (int i = 0; i < stations.size() - 1; i++) {
            Station startStation = stations.get(i);
            Station endStation = stations.get(i + 1);
    
            // Verificar si se encontraron las estaciones
            if (!map.contains(startStation) || !map.contains(endStation)) {
                System.out.println("Una o ambas estaciones no existen en el mapa.");
                return totalDistance;
            }
    
            // Calcular la distancia entre las estaciones actuales
            float distance = map.minDistanciaPeso(map, startStation, endStation);
    
            // Agregar la distancia al total
            totalDistance += distance;
        }
    
        return totalDistance;
    }
    

    public static void main(String[] args) {
        Map routesMap = new Map();

        Station origin = routesMap.getStationI();
        Station destination = routesMap.getStationH();

        float shortestDistance = routesMap.getKmRoute(origin, destination);
        System.out.println("La distancia más corta entre " + origin.getNombre() + " y " +
                destination.getNombre() + " es: " + shortestDistance + " km");

        LinkedList<Station> shortestPathStations = routesMap.getEfectiveRoute(origin, destination);

        int i = 1;
        while (!shortestPathStations.isEmpty()) {
            System.out.println("Estacion "+ i);
            System.out.println(shortestPathStations.poll().getNombre()+"\n");
            i++;
        }

        LinkedList<Station> routesByAdmin = new LinkedList<>();
        routesByAdmin.add(routesMap.getStationI());
        routesByAdmin.add(routesMap.getStationJ());
        routesByAdmin.add(routesMap.getStationA());
        routesByAdmin.add(routesMap.getStationG());
        routesByAdmin.add(routesMap.getStationH());

        float shortestDistanceRoutes = routesMap.calculateTotalDistance(routesByAdmin);
        System.out.println("La distancia más corta entre " + origin.getNombre() + " y " +
                destination.getNombre() + " es: " + shortestDistanceRoutes + " km");

        LinkedList<Station> buildRoute = routesMap.buildRoute(routesByAdmin);

        int j = 1;
        while (!buildRoute.isEmpty()) {
            System.out.println("Estacion "+ j);
            System.out.println(buildRoute.poll().getNombre()+"\n");
            j++;
        }
        /* 

        // Prueba de la ruta personalizada
        Station intermediateStationI = routesMap.getStationI();
        Station intermediateStationJ = routesMap.getStationJ();
        Station intermediateStationA = routesMap.getStationA();
        Station intermediateStationG = routesMap.getStationG();
        Station intermediateStationH = routesMap.getStationH();

        // Crear una lista de estaciones proporcionadas por el cliente
        LinkedList<Station> customStationsList = new LinkedList<>();
        customStationsList.add(intermediateStationI);
        customStationsList.add(intermediateStationJ);
        customStationsList.add(intermediateStationA);
        customStationsList.add(intermediateStationG);
        customStationsList.add(intermediateStationH);

        // Construir la ruta personalizada
        LinkedList<Station> customRouteStations = routesMap.buildCustomRoute(customStationsList);

        System.out.println("Tiempo que se demoraria la ruta: "+routesMap.calculateTotalTime(customRouteStations));

        // Imprimir las estaciones en la ruta personalizada
        System.out.println("Ruta Personalizada:");
        int j = 1;
        while (!customRouteStations.isEmpty()) {
            System.out.println("Estación " + j + ": " + customRouteStations.poll().getStationName());
            j++;
        }

        // Calcular los kilómetros totales recorridos
        float totalDistance = routesMap.calculateTotalDistance(customStationsList);
        System.out.println("Kilómetros totales recorridos en la ruta personalizada: " + totalDistance + " km");


        routesMap.showsStationsIndex();
        /* */
    }

}
