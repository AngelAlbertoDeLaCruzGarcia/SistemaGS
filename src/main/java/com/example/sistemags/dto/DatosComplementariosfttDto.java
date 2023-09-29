package com.example.sistemags.dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class DatosComplementariosfttDto {

    @Size(min = 18, max = 18, message = "CURP debe ser de 18 digitos")
    @NotEmpty(message = "CURP no debe de ser nulo")
    private String curp;

    @Size(min = 13, max = 13, message = "RFC debe ser de 13 digitos")
    @NotEmpty(message = "RFC no debe de ser nulo")
    private String rfc;

    private Date fechaCreacion;

    private Date fechaActualizacion;

    public DatosComplementariosfttDto() {}

    public DatosComplementariosfttDto(String curp, String rfc, Date fechaCreacion, Date fechaActualizacion) {
        this.curp = curp;
        this.rfc = rfc;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
