package modelo;

import java.util.Date;

public class Tarjeta {
    private Double limite;
    private Date fecha_corte;
    private Float interes;


    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Date getFecha_corte() {
        return fecha_corte;
    }

    public void setFecha_corte(Date fecha_corte) {
        this.fecha_corte = fecha_corte;
    }

    public Float getInteres() {
        return interes;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }
}
