package com.example.sistemags.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class ClientesfttDto {

    @Size(min = 2, max = 100, message = "Nombre acepta maximo 100 caracteres")
    @NotEmpty(message = "Nombre no debe de ser nulo")
    private String nombre;

    @Size(min = 3, max = 100, message = "Apellidos acepta maximo 100 caracteres")
    @NotEmpty(message = "Apellidos no deben de ser nulo")
    private String apellidoPaterno;

    @Size(min = 3, max = 100, message = "Apellidos acepta maximo 100 caracteres")
    @NotEmpty(message = "Apellidos no deben de ser nulo")
    private String apellidoMaterno;

    @Past(message = "Fecha de nacimiento no valida")
    private Date fechaNac;

    @Size(min = 2, max = 40, message = "Entidad acepta maximo 40 caracteres")
    @NotEmpty(message = "Entidad no deben de ser nulo")
    private String entidadNac;

    @Size(min = 3, max = 20, message = "Genero acepta maximo 20 caracteres")
    @NotEmpty(message = "Genero no deben de ser nulo")
    private String genero;

    private Date fechaCreacion;

    private Date fechaActualizacion;

    public ClientesfttDto() { }

    public ClientesfttDto(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNac, String entidadNac, String genero, Date fechaCreacion, Date fechaActualizacion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNac = fechaNac;
        this.entidadNac = entidadNac;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEntidadNac() {
        return entidadNac;
    }

    public void setEntidadNac(String entidadNac) {
        this.entidadNac = entidadNac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
