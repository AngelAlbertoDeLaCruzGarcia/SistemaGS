package com.example.sistemags.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes_ftt")
public class Clientesftt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientesftt_id")
    private int clientesFttId;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 100, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 100, nullable = false)
    private String apellidoMaterno;

    @Column(name = "fecha_nac", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @Column(name = "entidad_nac", length = 40, nullable = false)
    private String entidadNac;

    @Column(name = "genero", length = 20, nullable = false)
    private String genero;

    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "datos_comp_id", referencedColumnName = "datos_comp_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private DatosComplementariosftt datosComplementariosftt;

    public Clientesftt() { }

    public Clientesftt(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNac, String entidadNac, String genero, Date fechaCreacion, Date fechaActualizacion, DatosComplementariosftt datosComplementariosftt) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNac = fechaNac;
        this.entidadNac = entidadNac;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.datosComplementariosftt = datosComplementariosftt;
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

    public DatosComplementariosftt getDatosComplementariosftt() {
        return datosComplementariosftt;
    }

    public void setDatosComplementariosftt(DatosComplementariosftt datosComplementariosftt) {
        this.datosComplementariosftt = datosComplementariosftt;
    }

    private static final long serialVersionUID = 1L;
}
