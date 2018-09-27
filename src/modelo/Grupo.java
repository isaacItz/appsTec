package modelo;

import static lib.Utileria.leerCadena;
import static lib.Utileria.leerEntero;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Scanner;

public class Grupo {
	private Usuario[] contenedor;
	private int tamaño;
	private int contador;

	public Grupo(int tamaño) {
		this.tamaño = tamaño;
		this.contador = 0;
		this.contenedor = new Usuario[tamaño];
	}

	public void agregar(Usuario usuario) {
		contenedor[contador] = usuario;
		contador++;
	}

	public String listar() {
		String salida = "Listado General de Usuario \n\n";
		for (int i = 0; i < contador; i++) {
			salida += contenedor[i] + "\n";
		}
		return salida;
	}

	public void agregarMedianteArchivo(File archivo) throws FileNotFoundException {
		Scanner lector = new Scanner(archivo);
		int i = 0;
		while (lector.hasNextLine()) {
			System.out.println("pasada " + i++);
			String linea = lector.nextLine();
			// System.out.println(linea);
			String[] cadenaSeparada = linea.split(",");
			for (String string : cadenaSeparada) {
				System.out.println(string);
			}

			Usuario usuario = new Usuario();
			usuario.setClave(cadenaSeparada[0]);

			usuario.setApellidoPaterno(cadenaSeparada[1]);
			usuario.setApellidoMaterno(cadenaSeparada[2]);
			System.out.println("longitu " + cadenaSeparada.length);

			usuario.setNombre(cadenaSeparada[3]);
			usuario.setGenero(cadenaSeparada[4]);
			usuario.setTelefono(cadenaSeparada[5]);
			usuario.seteMail(cadenaSeparada[6]);

			Domicilio domicilio = new Domicilio();
			linea = lector.nextLine();
			cadenaSeparada = linea.split(",");

			domicilio.setCalle(cadenaSeparada[0]);
			String[] numeroCasa = cadenaSeparada[1].split(" ");
			domicilio.setNumeroCasa(Integer.parseInt(numeroCasa[1]));
			domicilio.setColonia(cadenaSeparada[2]);
			domicilio.setCiudad(cadenaSeparada[3]);
			domicilio.setEstado(cadenaSeparada[4]);
			domicilio.setCodigoPostal(cadenaSeparada[5]);

			usuario.setDomicilio(domicilio);

			cadenaSeparada = null;
			this.agregar(usuario);

		}
	}

	public Usuario[] OrdenarUsuarioA() {
		Usuario aux = null;
		for (int i = 0; i < contador - 1; i++) {
			for (int j = (i + 1); j < contador; j++) {
				if (contenedor[i].getNombreCompleto().compareToIgnoreCase(contenedor[j].getNombreCompleto()) > 0) {
					aux = contenedor[i];
					contenedor[i] = contenedor[j];
					contenedor[j] = aux;
				}
			}
		}
		return contenedor;

	}

	public boolean tieneUsuarios() {
		return contador > 0;
	}

	/*
	 * public Usuario getUsuario(int posicion){ int i=0; while
	 * (i<contador&&(!contenedor[i].getClave().equals(clave))) { i++; }
	 * if(i<contador){ return contenedor[i]; }else return null; }
	 */
	public Usuario getUsuario(int posicion) {
		return contenedor[posicion];
	}

	public int getPosicion(String clave) {
		int i = 0;
		while (i < contador && (!contenedor[i].getClave().equals(clave))) {
			i++;
		}
		return i;
	}

	/*
	 * public int buscarN(String control){ int i=0;
	 * while((i<contador)&&(!contenedor[i].getClave().equals(control))){ i++; }
	 * return i; }
	 */
	public void eliminar(int pocision) {
		for (int i = pocision; i < contador - 1; i++) {
			contenedor[i] = contenedor[i + 1];

		}
		contador--;
	}

	public boolean existe(int pocision) {

		return pocision < contador;
	}

	public boolean estaLleno() {
		return contador == tamaño;
	}

	public void menuModificar(Usuario usuario) {
		int opcion = 0;
		do {
			String menu = "Modificación de Usuarios\n";
			menu += "1.- Nombre: " + usuario.getNombre() + "\n";
			menu += "2.- Apellido Paterno: " + usuario.getApellidoPaterno() + "\n";
			menu += "3.- Apellidos Materno: " + usuario.getApellidoMaterno() + "\n";
			menu += "4.- Genero: " + usuario.getGenero() + "\n";
			menu += "5.- e-Mail: " + usuario.geteMail() + "\n";
			menu += "6.- Telefono: " + usuario.getTelefono() + "\n";
			menu += "7.- No. Casa: " + usuario.getDomicilio().getNumeroCasa() + "\n";
			menu += "8.- Calle: " + usuario.getDomicilio().getCalle() + "\n";
			menu += "9.- Colonia: " + usuario.getDomicilio().getColonia() + "\n";
			menu += "10.- Ciudad: " + usuario.getDomicilio().getCiudad() + "\n";
			menu += "11.- Estado: " + usuario.getDomicilio().getEstado() + "\n";
			menu += "12.- Codigo Postal: " + usuario.getDomicilio().getCodigoPostal() + "\n";
			menu += "13.- Salir\n";
			menu += "seleccione su opcion";
			do {
				opcion = leerEntero(menu);
			} while (opcion < 1 || opcion > 13);
			switch (opcion) {
			case 1:
				usuario.setNombre(leerCadena("Ingrese Nombre"));
				break;
			case 2:
				usuario.setApellidoPaterno(leerCadena("Ingrese Apellido Paterno"));
				break;
			case 3:
				usuario.setApellidoMaterno(leerCadena("Ingrese Apellido Materno"));
				break;
			case 4:
				usuario.setGenero(leerCadena("Ingrese Genero"));
				break;
			case 5:
				usuario.seteMail(leerCadena("Ingrese e-Mail"));
				break;
			case 6:
				usuario.setTelefono(leerCadena("Ingrese Telefono"));
				break;
			case 7:
				usuario.getDomicilio().setNumeroCasa(leerEntero("Ingrese el nuevo Número"));
				break;
			case 8:
				usuario.getDomicilio().setCalle(leerCadena("Ingrese Calle"));
				break;
			case 9:
				usuario.getDomicilio().setColonia(leerCadena("ingrese Colonia"));
				break;
			case 10:
				usuario.getDomicilio().setCiudad(leerCadena("Ingrese Ciudad"));
				break;
			case 11:
				usuario.getDomicilio().setEstado(leerCadena("Ingrese Estado"));
				break;
			case 12:
				usuario.getDomicilio().setCodigoPostal(leerCadena("Ingrese Codigo Postal"));
				break;
			default:
				break;
			}
		} while (opcion != 13);
	}

}
