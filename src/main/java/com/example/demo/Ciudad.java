package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "ciudades", schema = "qa")
public class Ciudad
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int ciudad;
    @Column(name = "nombres")
    private String nombres;

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
