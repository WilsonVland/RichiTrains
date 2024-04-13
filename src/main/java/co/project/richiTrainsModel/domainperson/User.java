package co.project.richiTrainsModel.domainperson;

public class User {

    private String userName;
    private String password;
    private String id;
    private TipoUsuario tipo;
    
    
    public User(String userName, String password, String id, TipoUsuario tipo) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.tipo = tipo;

    }
    
    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {
        return id;
    }
    public void setId(String person) {
        this.id = person;
    }

    public static User getNullUser(){
        return new User("", "", "", null);
    }
}
