package co.project.richiTrainsModel.domainperson;

public enum TipoUsuario {
    ADMIN(1),
    EMPLEADO(2);

    private final int valor;

    private TipoUsuario(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
