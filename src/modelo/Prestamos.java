package modelo;

import static lib.Utileria.leerCadena;
import static lib.Utileria.leerEntero;

import java.util.Date;

public class Prestamos {
	private Prestamo [] contenedor;
	private int tamaño;
	private int contador;
	public Prestamos(int tamaño) {
		this.tamaño=tamaño;
		this.contador=0;
		this.contenedor= new Prestamo[tamaño];
	}
	public void agregar(Prestamo prestamo){
		contenedor[contador]=prestamo;
		contador++;
	}
	public String listar(){
		String salida = "Listado General de Prestamos \n\n";
		for (int i = 0; i < contador; i++) {
			salida+= contenedor[i]+ "\n";
		}
		return salida;
	}
	public boolean tieneUsuarios(){
		return contador>0;
	}


	public Prestamo getPrestamo(int posicion){
		return contenedor[posicion];
	}
	public int getPosicion(String claveIsbn,boolean bandera){
		int i=0;
		String opcion =null;
		while (i<contador) {
			if (bandera) {
				opcion = contenedor[i].getIsbn();
			} else 
				opcion = contenedor[i].getClaveUsuario();
			if (opcion.equals(claveIsbn)) {
				return i;
			}
			i++;
		}
		return i;
	}

	public void eliminar(int pocision){
		for (int i = pocision; i < contador-1; i++) {
			contenedor[i]=contenedor[i+1];

		}
		contador--;
	}
	public boolean existe(int pocision){

		return pocision<contador;
	}
	public boolean estaLleno(){
		return contador==tamaño;
	}
	public void menuModificar(Prestamo prestamo){
		int opcion=0;
		do{
			String menu ="Modificación de Prestamos \n";
			menu+="1.- Fecha de Prestamo: " + prestamo.getFechaPrestamo()+"\n";
			menu+="2.- Fecha de Entrega: " + prestamo.getFechaEntrega()+"\n";
			menu+="3.- Salir\n";
			menu += "seleccione su opcion";
			do {
				opcion=leerEntero(menu);
			} while (opcion<1 || opcion>13);
			switch (opcion) {
			case 1:
				prestamo.setFechaPrestamo(new Date(leerCadena("ingrese nueva fecha")));
				break;
			case 2:
				prestamo.setFechaEntrega(null);
				break;

			default:
				break;
			}
		}while(opcion!=3);
	} 
	public boolean estaVacio(){
		return contador==0;
	}	public String getLibrosPrestados(String clave,Estante estante) {
		String salida = "";
		for (int i = 0; i <contador ; i++) {
			if (contenedor[i].getClaveUsuario().equals(clave)) {

				//		String datosLibro =estante.getLibro(estante.getPosicionL(contenedor[i].getIsbn())).toString();
				String isbn=contenedor[i].getIsbn();
				int posicion = estante.getPosicionL(isbn);
				Libro libro = estante.getLibro(posicion);
				String datosLibro = libro.toString();
				salida+= datosLibro + "\n ";
			}
		}
		return salida;
	}

}
