package modelo;

public class Cliente {
    private int codigo;
    private String nombre;
    private String direccion;
    private String email;
    private String celular;
    private Double saldo;
    private Tarjeta tarjeta_credito;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Tarjeta getTarjeta_credito() {
        return tarjeta_credito;
    }

    public void setTarjeta_credito(Tarjeta tarjeta_credito) {
        this.tarjeta_credito = tarjeta_credito;
    }
}
