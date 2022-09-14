package com.ntt.proyect.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class PersonEntity {
    
    /*
     * Se creara un codigoPersona por cada persona registrada,
     * este codigo sera generado automaticamente con un id alfanumerico "uuid",
     * con el fin de evitar id's repetidos.
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "codigo_persona", unique = true, nullable = false)
    private int codigoPersona;

    @Column(name = "primer_nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "segundo_nombre", length = 30)
    private String segundoNombre;

    @Column(name = "primer _apellido", length = 30, nullable = false)
    private String apellido;

    @Column(name = "segundo_apellido", length = 30)
    private String segundoApellido;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "estado_civil", length = 30)
    private String estadoCivil;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "telefono_movil", length = 30)
    private String telefonoMovil;

    @Column(name = "telefono_fijo", length = 30)
    private String telefonoFijo;

    @Column(name = "estatus", nullable = false)
    private boolean status;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
    


}
