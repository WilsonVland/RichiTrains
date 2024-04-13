package co.project.richiTrainsModel.domainTrain;

public class GetVagonFactory {
    private int vagonIdContador = 1;
    public Vagon getVagon(String tipoVagon) {
        if (tipoVagon == null) {
            return null;
        }
        if (tipoVagon.equalsIgnoreCase("VagonPasajero")) {
            return new VagonPasajero(vagonIdContador++, 0, 0, 0);
        } else if (tipoVagon.equalsIgnoreCase("VagonEquipaje")) {
            return new VagonEquipaje(vagonIdContador++, 0, 0);
        }
        return null;
    }
}
//Mercedes 1-28 19 pasajero 9 equipaje max x = 19; x/2
//Arnold 1-32  21 pasajero 11 equipaje max x = 21; x <= 20 x/2; x= 21 x/2 + 1