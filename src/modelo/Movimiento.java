package modelo;

public class Movimiento {

    private Cliente cliente;
    private Double monto;
    private String tipo;


    public Movimiento(Cliente cliente, Double monto, String tipo){
        this.setCliente(cliente);
        this.setMonto(monto);
        this.setTipo(tipo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
