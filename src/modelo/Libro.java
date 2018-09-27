package modelo;
public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	@Override
	public String toString() {
		String salida = isbn + ", Autor:  " + autor + ", Titulo: " +  titulo + ", ";
		salida+= "Editorial: "+ editorial + ", Edición:  " + edicion ;
		return  salida;
	}
}
