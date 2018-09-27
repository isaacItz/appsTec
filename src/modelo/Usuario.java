package modelo;

import java.util.Date;

public class Usuario {
	private String clave;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String genero;
	private String telefono;
	private Date fechaNacimiento;
	private String eMail;
	private Domicilio domicilio;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		String salida = clave + " " + apellidoPaterno + " " + apellidoMaterno + " " + nombre + "\n";
		salida += "Telefono " + telefono + " e-Mail " + eMail + "\n";
		salida += "Genero " + genero + "\n ";
		salida += "Domicilio " + domicilio + "\n";
		return salida;
	}

	public String getNombreCompleto() {
		String salida = apellidoPaterno + " " + apellidoMaterno + " " + nombre;
		return salida;
	}

}
