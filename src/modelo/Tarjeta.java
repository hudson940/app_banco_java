package modelo;

public class Tarjeta {
    private int numero;
    private Double limite;
    private String fechaCorte;
    private Float interes;

    public Tarjeta(int numero, Double limite, String fechaCorte, Float interes){
        this.numero = numero;
        this.limite = limite;
        this.fechaCorte = fechaCorte;
        this.interes = interes;

    }

    public int getNumero() {
        return numero;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Float getInteres() {
        return interes;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return ""+numero;
    }
}
