package com.example.demo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "qa")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "idciudad")
	private int idciudad;

	@OneToOne
	@JoinColumn(name="id")
	private Ciudad ciudad;

	public Users() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdciudad() {
		return idciudad;
	}

	public void setIdciudad(int idciudad) {
		this.idciudad = idciudad;
	}
}
