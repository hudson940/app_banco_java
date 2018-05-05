package modelo;

import sun.misc.ExtensionInfo;

public class Cliente extends Object{
    private int codigo;
    private String nombre;
    private String direccion;
    private String email;
    private String celular;
    private Double saldo;
    private Tarjeta tarjeta_credito;

    public Cliente(int codigo, String nombre, String direccion, String email,
                   String celular, Double saldo ,Tarjeta tarjeta_credito){

        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.saldo = saldo;
        this.tarjeta_credito = tarjeta_credito;


    }

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

    public Tarjeta getTarjeta_credito() {
        return tarjeta_credito;
    }

    public void setTarjeta_credito(Tarjeta tarjeta_credito) {
        this.tarjeta_credito = tarjeta_credito;
    }

    public String to_string(){
        String cliente =
                "Código: "+this.codigo + '\n' +
                "Nombre: "+this.nombre + '\n' +
                "Dirección: "+this.direccion + '\n' +
                "Teleforno: "+ this.celular + '\n' +
                "Email: "+ this.email + '\n' +
                "saldo: "+ this.saldo + '\n' ;


        return cliente;
    }

    @Override
    public String toString() {
        String cliente =
                "Código: "+this.codigo + '\n' +
                        "Nombre: "+this.nombre + '\n' +
                        "Dirección: "+this.direccion + '\n' +
                        "Teleforno: "+ this.celular + '\n' +
                        "Email: "+ this.email + '\n' +
                        "saldo: "+ this.saldo + '\n' ;


        return cliente;
    }

    public String[] toTableRow(){
        String[] row = {"" + codigo , nombre,"" + saldo};
        return row;
    }

    public Double addSaldo(Double add) {
        this.saldo += add;
        return this.saldo;
    }

    public Double retirarSaldo(double retiro) {
        if(this.saldo < retiro)
            return null;
        else
            return this.saldo -= retiro;
    }
}
