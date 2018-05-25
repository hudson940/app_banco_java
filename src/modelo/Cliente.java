/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Andrea
 */
public class Cliente {
    private int idCliente;
    private String nombre;
    private String direccion;
    private String email;
    private Double saldo;
    private long celular;
    private Tarjeta tarjeta;
    
    /**
     * Constructor para cliente
     * @param id
     * @param nombre
     * @param direccion
     * @param email
     * @param saldo
     * @param celular
     * @param tarjeta
     */
    public Cliente(int id, String nombre, String direccion,
                    String email, Double saldo, long celular ,Tarjeta tarjeta )
    {
        this.idCliente = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.saldo = saldo;
        this.celular = celular;
        this.tarjeta = tarjeta;
    }

    /**
     *
     * @return id cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return nombre cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return dirección cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return email cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return saldo cliente
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     *
     * @param saldo
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     *
     * @return tarjeta cliente
     */
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    /**
     *
     * @param tarjeta
     */
    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     *
     * @return celular cliente
     */
    public long getCelular() {
        return celular;
    }

    /**
     *
     * @param celular
     */
    public void setCelular(long celular) {
        this.celular = celular;
    }
    
    /**
     *
     * @param deposito valor a depositar
     * @return saldo despues del deposito
     */
    public Double depositar(Double deposito) {
       this.saldo = this.saldo + deposito;
       return this.saldo;
   }

    /**
     *
     * @param retiro valor a retirar
     * @return saldo despues del retiro
     */
    public Double retirar(double retiro) {
       if(this.saldo < retiro)
           return null;
       else
           return this.saldo = this.saldo - retiro;
   }
}
