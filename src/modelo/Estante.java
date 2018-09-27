package modelo;

import static  lib.Utileria.*;

public class Estante {
	private Libro [] estante;
	private int tamaño;
	private int contador;
	public Estante(int tamaño) {
		this.tamaño = tamaño;
		this.contador = 0;
		this.estante = new Libro[tamaño];
	}

	public void agregarL(Libro libro){
		estante[contador]=libro;
		contador++;
	}
	public String listarL(){
		String salida = "Listado General de Usuario \n\n";
		for (int i = 0; i < contador; i++) {
			salida+= estante[i]+ "\n";
		}
		return salida;
	}
	public  Libro []   OrdenarAlfabetico () {
		 Libro aux =null;
			for (int i=0; i<contador-1; i++) {
				for (int j =( i+1); j < contador; j++) {
					if (estante[i].getAutor().compareToIgnoreCase(estante[j].getAutor())>0) {
				 	   aux = estante [i];
						estante[i]=estante[j];
						 estante[j] = aux;
						
					}
					
				
					}
				
				}
			return estante;
			
			}
			
		
		public boolean tieneLibros(){
		return contador>0;
	}


	public Libro getLibro(int posicion){
		return estante[posicion];
	}
	public int getPosicionL(String isbn){
		int i=0;
		while (i<contador&&(!estante[i].getIsbn().equals(isbn))) {
			i++;
		}
		return i;
	}

	public void eliminarL(int pocision){
		for (int i = pocision; i < contador-1; i++) {
			estante[i]=estante[i+1];

		}
		contador--;
	}
	public boolean existeL(int pocision){

		return pocision<contador;
	}
	public boolean estaLlenoL(){
		return contador==tamaño;
	}
	public void modificarLibro(Libro libro){
		int opcion;
		do {
			String menu = "1. Autor: " + libro.getAutor()+ "\n";
			menu+= "2. Titulo: " + libro.getTitulo() + "\n";
			menu+= "3. Editorial: " + libro.getEditorial() + "\n";
			menu+= "4. Edicion: " + libro.getEdicion() + "\n";
			menu+= "5. Salir \n";
			menu+= "Seleccione una Opción " ;
			do {
				opcion=leerEntero(menu);
			} while (opcion<1 || opcion>5);
			switch (opcion) {
			case 1:
				libro.setAutor(leerCadena("Ingrese Autor"));
				break;
			case 2:
				libro.setTitulo(leerCadena("Ingrese Titulo"));
				break;
			case 3:
				libro.setEditorial(leerCadena("Ingrese Editorial"));
				break;
			case 4:
				libro.setEdicion(leerCadena("Ingrese Edicion"));
				break;
			default:
				break;
			}
		} while (opcion!=5);
	}
 
  


}
