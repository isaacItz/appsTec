package vista;

import static lib.Utileria.continuar;
import static lib.Utileria.leerCadena;
import static lib.Utileria.leerEntero;
import static lib.Utileria.visualizar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelo.Domicilio;
import modelo.Estante;
import modelo.Grupo;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Prestamos;
import modelo.Usuario;

public class Ventana extends JFrame {
	private Grupo grupo;
	private Estante estante;
	private Prestamos prestamos;

	// UTILIZAMOS UN CONSTRUCCTOR
	public Ventana() {
		// setSize(600, 400);
		// setLocation(200,150);
		grupo = new Grupo(30);
		estante = new Estante(30);
		prestamos = new Prestamos(30);
		Font fuente = new Font("Comic Sans MS", 15, 15);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Biblioteca Virtual");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar barra = new JMenuBar();

		JMenu menuUsuarios = new JMenu("Gestión de Usuarios");
		JMenu menuLibros = new JMenu("Gestión de Libros");

		JMenu menuPrestamos = new JMenu("Gestion de Prestamos");

		JMenuItem opRegistrarUsuario = new JMenuItem("Registo de Usuarios");
		OyenteRegistarUsuario oyenteRegistrarUsuario = new OyenteRegistarUsuario();
		opRegistrarUsuario.addActionListener(oyenteRegistrarUsuario);

		JMenuItem opConsultarUsuario = new JMenuItem("Consulta de Usuarios");
		OyenteConsultarUsuario oyenteConsultarUsuario = new OyenteConsultarUsuario();
		opConsultarUsuario.addActionListener(oyenteConsultarUsuario);

		JMenuItem opModificarUsuario = new JMenuItem("Modificaciones de Usuarios");
		OyenteModificarUsuario oyenteModificarUsuario = new OyenteModificarUsuario();
		opModificarUsuario.addActionListener(oyenteModificarUsuario);

		JMenuItem opELiminarUsuario = new JMenuItem("Eliminación de Usuarios");
		OyenteEliminarUsuario oyenteEliminarUsuario = new OyenteEliminarUsuario();
		opELiminarUsuario.addActionListener(oyenteEliminarUsuario);

		JMenuItem opListadoUsuario = new JMenuItem("Listado de Usuarios");
		OyenteListarUsuario oyenteListarUsuario = new OyenteListarUsuario();
		opListadoUsuario.addActionListener(oyenteListarUsuario);

		JMenuItem opOrdenarUsuario = new JMenuItem("listado ordenado");
		OyenteOrdenarUsuario oyenteOrdenarUsuario = new OyenteOrdenarUsuario();
		opOrdenarUsuario.addActionListener(oyenteOrdenarUsuario);

		JMenuItem opArchivo = new JMenuItem("listado de archivo");
		OyenteArchivo oyenteArchivo = new OyenteArchivo();
		opArchivo.addActionListener(oyenteArchivo);

		// ________________________________________________________________

		JMenuItem opRegistrarLibro = new JMenuItem("Registro de Libros");
		OyenteRegistarLibro oyenteLibro = new OyenteRegistarLibro();
		opRegistrarLibro.addActionListener(oyenteLibro);

		JMenuItem opConsultarLibro = new JMenuItem("Consulta de Libros");
		OyenteConsultarLibro oyenteConsultarLibro = new OyenteConsultarLibro();
		opConsultarLibro.addActionListener(oyenteConsultarLibro);

		JMenuItem opModificarLibro = new JMenuItem("Modificaciones de Libros");
		OyenteModificarLibro oyenteModificar = new OyenteModificarLibro();
		opModificarLibro.addActionListener(oyenteModificar);

		JMenuItem opEliminarLibro = new JMenuItem("Eliminación de Libros");
		OyenteEliminarLibro oyenteEliminarLibro = new OyenteEliminarLibro();
		opEliminarLibro.addActionListener(oyenteEliminarLibro);

		JMenuItem opListadoLibro = new JMenuItem("Listado de Libros");
		OyenteListarLibro oyenteListadoLibro = new OyenteListarLibro();
		opListadoLibro.addActionListener(oyenteListadoLibro);

		JMenuItem opOrdenarLibro = new JMenuItem("Orden alfabetico de libros");
		OyenteOrdenarLibro oyenteOrdenarLibro = new OyenteOrdenarLibro();
		opOrdenarLibro.addActionListener(oyenteOrdenarLibro);
		// ________________________________________________________________
		JMenuItem opRegistarPrestamo = new JMenuItem("Registrar Prestamo");
		OyenteRegistar oyenteRegistrarPrestamo = new OyenteRegistar();
		opRegistarPrestamo.addActionListener(oyenteRegistrarPrestamo);

		JMenuItem opConsultarPorIsbn = new JMenuItem("Consultar Prestamo Por ISBN");
		OyenteConsultarPrestamoPorIsbn oyenteConsultarIsbn = new OyenteConsultarPrestamoPorIsbn();
		opConsultarPorIsbn.addActionListener(oyenteConsultarIsbn);

		JMenuItem opConsultarPorUsuario = new JMenuItem("Consultar Prestamo Por Usuario");
		OyenteConsultarPrestamoPorUsuario oyenteConsultarPorUsuario = new OyenteConsultarPrestamoPorUsuario();
		opConsultarPorUsuario.addActionListener(oyenteConsultarPorUsuario);

		JMenuItem opModificarPrestamo = new JMenuItem("Modificar Prestamo");
		OyenteModificarPrestamo oyenteModificarPrestamo = new OyenteModificarPrestamo();
		opModificarPrestamo.addActionListener(oyenteModificarPrestamo);

		JMenuItem opEliminarPrestamo = new JMenuItem("Eliminar Prestamo");
		OyenteEliminarPrestamo oyenteEliminarPrestamo = new OyenteEliminarPrestamo();
		opEliminarPrestamo.addActionListener(oyenteEliminarPrestamo);

		JMenuItem opListarPrestamos = new JMenuItem("Listado de Prestamos");
		OyenteListarPrestamo oyenteListarPrestamo = new OyenteListarPrestamo();
		opListarPrestamos.addActionListener(oyenteListarPrestamo);

		// ________________________________________________________________
		menuUsuarios.add(opRegistrarUsuario);
		menuUsuarios.add(opConsultarUsuario);
		menuUsuarios.add(opModificarUsuario);
		menuUsuarios.add(opELiminarUsuario);
		menuUsuarios.add(opListadoUsuario);
		menuUsuarios.add(opOrdenarUsuario);
		menuUsuarios.add(opArchivo);
		// ________________________________________________________________
		menuLibros.add(opRegistrarLibro);
		menuLibros.add(opConsultarLibro);
		menuLibros.add(opModificarLibro);
		menuLibros.add(opEliminarLibro);
		menuLibros.add(opListadoLibro);
		menuLibros.add(opOrdenarLibro);
		// ________________________________________________________________
		menuPrestamos.add(opRegistarPrestamo);
		menuPrestamos.add(opConsultarPorIsbn);
		menuPrestamos.add(opConsultarPorUsuario);
		menuPrestamos.add(opModificarPrestamo);
		menuPrestamos.add(opEliminarPrestamo);
		menuPrestamos.add(opListarPrestamos);
		barra.add(menuUsuarios);
		barra.add(menuLibros);
		barra.add(menuPrestamos);
		setJMenuBar(barra);
		setVisible(true);

		// ESTILO DE LETRA_________________________________________________
		menuLibros.setFont(fuente);
		menuUsuarios.setFont(fuente);
		menuPrestamos.setFont(fuente);
		opRegistrarUsuario.setFont(fuente);
		opConsultarUsuario.setFont(fuente);
		opModificarUsuario.setFont(fuente);
		opELiminarUsuario.setFont(fuente);
		opListadoUsuario.setFont(fuente);
		opOrdenarUsuario.setFont(fuente);
		opArchivo.setFont(fuente);
		opRegistrarLibro.setFont(fuente);
		opConsultarLibro.setFont(fuente);
		opModificarLibro.setFont(fuente);
		opEliminarLibro.setFont(fuente);
		opListadoLibro.setFont(fuente);
		opOrdenarLibro.setFont(fuente);
		opRegistarPrestamo.setFont(fuente);
		opConsultarPorIsbn.setFont(fuente);
		opConsultarPorUsuario.setFont(fuente);
		opModificarPrestamo.setFont(fuente);
		opEliminarPrestamo.setFont(fuente);
		opListarPrestamos.setFont(fuente);

	}
	// _______________________METODO MAIN__________________________________

	public static void main(String[] args) {
		new Ventana();

	}

	// _________________________CLASE INTERNAS_____________________________
	// CLASE OYENTE REGISTRAR_____________________________________________
	private class OyenteRegistarUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!grupo.estaLleno()) {
				do {
					String clave = leerCadena("Ingrese la clave");
					if (!grupo.existe(grupo.getPosicion(clave))) {
						Usuario usuario = leerUsuario();
						usuario.setClave(clave);
						grupo.agregar(usuario);
					} else
						visualizar("Este Usuario ya se encuentra Registrado");
				} while (!grupo.estaLleno() && continuar("Desea Registrar otro Usuario"));
			} else
				visualizar("El grupo esta Lleno");
		}
	}

	// CLASE OYENTE CONSULTAR______________________________________________
	private class OyenteConsultarUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (grupo.tieneUsuarios()) {
				do {
					String clave = leerCadena("Ingrese la Clave del Usuario que Desea Buscar");
					int posicion = grupo.getPosicion(clave);
					if (grupo.existe(posicion)) {
						visualizar(grupo.getUsuario(posicion).toString());
					} else
						visualizar("Este Usuario no Existe");
				} while (continuar("Desea Consultar otro Usuario"));
			} else
				visualizar("No tiene Usuarios");
		}
	}

	// OYENTE MODIFICAR____________________________________________________
	private class OyenteModificarUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (grupo.tieneUsuarios()) {
				do {
					String clave = leerCadena("Ingrese la Clave del Usuario que Desea Modificar");
					int posicion = grupo.getPosicion(clave);
					if (grupo.existe(posicion)) {
						Usuario usuario = grupo.getUsuario(posicion);
						grupo.menuModificar(usuario);
					} else
						visualizar("Este Usuario no Existe");
				} while (continuar("Desea Modificar  otro Usuario"));
			} else
				visualizar("No tiene Usuarios");
		}
	}

	// CLASE OYENTE ELIMINAR_______________________________________________
	private class OyenteEliminarUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (grupo.tieneUsuarios()) {
				do {
					String control = leerCadena("Ingrese la Clave del Usuario que desea Eliminar");
					int pocision = grupo.getPosicion(control);
					if (grupo.existe(pocision)) {
						grupo.eliminar(pocision);
						visualizar("El Usuario fue Eliminado con exito");
					} else
						visualizar("Este alumno no se encuentra en el grupo");
				} while (grupo.tieneUsuarios() && continuar("Desea Eliminar otro Usuario"));
			} else
				visualizar("El Grupo no tiene Usuarios");
		}
	}

	// CLASE OYENTE LISTAR__________________________________________________
	private class OyenteListarUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (grupo.tieneUsuarios()) {

				visualizar(grupo.listar());
			} else {
				visualizar("El Grupo esta Vacío");
			}
		}
	}

	private class OyenteOrdenarUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (grupo.tieneUsuarios()) {
				grupo.OrdenarUsuarioA();
				visualizar(" la lista ha sido ordenada");
			} else {
				visualizar("El Estante esta Vacío");
			}
		}
	}

	private class OyenteArchivo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser bus = new JFileChooser("C:\\mi area\\app Karen");
			bus.showOpenDialog(bus);
			File archivo = bus.getSelectedFile();
			try {
				grupo.agregarMedianteArchivo(archivo);
			} catch (FileNotFoundException e) {

			}

		}

	}
	// -----------------------------------//GESTIÓN DE LIBROS
	// OYENTES//----------------------------------------------//

	private class OyenteRegistarLibro implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!estante.estaLlenoL()) {
				do {
					String isbn = leerCadena("Ingrese la ISBN");
					if (!estante.existeL(estante.getPosicionL(isbn))) {
						Libro libro = leerLibro();
						libro.setIsbn(isbn);
						estante.agregarL(libro);
					} else
						visualizar("Este Libro ya se encuentra Registrado");
				} while (!estante.estaLlenoL() && continuar("Desea Registrar otro Libros"));
			} else
				visualizar("El estante esta Lleno");
		}
	}

	private class OyenteConsultarLibro implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (estante.tieneLibros()) {
				do {
					String isbn = leerCadena("Ingrese el ISBN del Libro que Desea Consultar");
					int posicion = estante.getPosicionL(isbn);
					if (estante.existeL(posicion)) {
						visualizar(estante.getLibro(posicion).toString());
					} else
						visualizar("Este Libro no Existe");
				} while (continuar("Desea Consultar otro Libro"));
			} else
				visualizar("No tiene Libros");
		}
	}

	private class OyenteModificarLibro implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (estante.tieneLibros()) {
				do {
					String isbn = leerCadena("Ingrese la ISBN del Libro que Desea Modificar");
					int posicion = estante.getPosicionL(isbn);
					if (estante.existeL(posicion)) {
						Libro libro = estante.getLibro(posicion);
						estante.modificarLibro(libro);
					} else
						visualizar("Este Libro no Existe");
				} while (continuar("Desea Modificar  otro Libro"));
			} else
				visualizar("No tiene Libros");
		}
	}

	private class OyenteEliminarLibro implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (estante.tieneLibros()) {
				do {
					String isbn = leerCadena("Ingrese el ISBN del Libro que desea Eliminar");
					int pocision = estante.getPosicionL(isbn);
					if (estante.existeL(pocision)) {
						estante.eliminarL(pocision);
						visualizar("El Libro fue Eliminado con exito");
					} else
						visualizar("Este Libro Existe");
				} while (grupo.tieneUsuarios() && continuar("Desea Eliminar otro Libro"));
			} else
				visualizar("No hay Libro");
		}
	}

	private class OyenteListarLibro implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (estante.tieneLibros()) {
				visualizar(estante.listarL());
			} else {
				visualizar("El Estante esta Vacío");
			}
		}

	}

	private class OyenteOrdenarLibro implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (estante.tieneLibros()) {
				estante.OrdenarAlfabetico();
				visualizar("esta ordenado");
			} else {
				visualizar("El Estante esta Vacío");
			}
		}

	}

	// -----------------------------------------------------/// PRESTAMOS
	// ///-----------------------------------------------//

	private class OyenteRegistar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!prestamos.estaLleno()) {
				do {
					String clave = leerCadena("Ingrese la Clave del Usuario");
					if (grupo.existe(grupo.getPosicion(clave))) {
						do {
							String isbn = leerCadena("Ingrese el ISBN del Libro que desea prestar");

							if (estante.existeL(estante.getPosicionL(isbn))) {
								if (!prestamos.existe(prestamos.getPosicion(isbn, true))) {
									Prestamo prestamo = new Prestamo();
									prestamo.setClaveUsuario(clave);
									prestamo.setIsbn(isbn);
									Date hoy = new Date();
									Calendar calendario = Calendar.getInstance();
									calendario.setTime(hoy);
									calendario.add(Calendar.DAY_OF_YEAR, 2);
									Date pasadoMañana = calendario.getTime();
									prestamo.setFechaPrestamo(hoy);
									prestamo.setFechaEntrega(pasadoMañana);
									prestamos.agregar(prestamo);
									visualizar("Prestamo Realizado con exito");
								} else
									visualizar("Este libro se encuentra prestado");
							} else
								visualizar("este libro no se encuentra en la biblioteca");
						} while (!prestamos.estaLleno() && continuar("Desea Prestar otro Libro a este Usuario"));
					} else
						visualizar("Este Usuario no se encuentra Registrado");
				} while (!prestamos.estaLleno() && continuar("Desea Registrar otro Prestamo"));
			} else
				visualizar("Ya no es posible realizar prestamos");
		}
	}

	private class OyenteConsultarPrestamoPorIsbn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!prestamos.estaVacio()) {
				do {
					String isbn = leerCadena("ingrese isbn");
					int posicion = prestamos.getPosicion(isbn, true);
					if (prestamos.existe(posicion)) {
						Prestamo prestamo = prestamos.getPrestamo(prestamos.getPosicion(isbn, true));
						String clave = prestamo.getClaveUsuario();
						String nombre = grupo.getUsuario(grupo.getPosicion(clave)).getNombreCompleto();
						String libro = estante.getLibro(estante.getPosicionL(isbn)).toString();
						SimpleDateFormat formato = new SimpleDateFormat(" dd  ' de '  MMMM  ' del año '  yyyy ");
						String fechaPrestamo = formato.format(prestamo.getFechaPrestamo());
						String fechaEntrega = formato.format(prestamo.getFechaEntrega());
						String datosPrestamo = "Los Datos de este prestamo son \n";
						datosPrestamo += libro + "\n";
						datosPrestamo += "Prestado a " + nombre + "\n";
						datosPrestamo += "Fecha de Prestamo " + fechaPrestamo + "\n";
						datosPrestamo += "Fecha de Entrega " + fechaEntrega;
						visualizar(datosPrestamo);
					} else
						visualizar("este libro no se encuentar prestado");
				} while (continuar("Desea consultar otro prestamo"));
			} else
				visualizar("No hay Prestamos Registrados");
		}
	}

	private class OyenteConsultarPrestamoPorUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!prestamos.estaVacio()) {
				do {
					String clave = leerCadena("ingrese clave del usuario");
					int posicion = grupo.getPosicion(clave);
					if (grupo.existe(posicion)) {
						String datosUsuario = grupo.getUsuario(grupo.getPosicion(clave)).getNombreCompleto();
						String salida = " los libros prestados al usuario " + datosUsuario + " son \n  ";
						String librosPrestados = prestamos.getLibrosPrestados(clave, estante);
						if (librosPrestados.isEmpty()) {
							salida += librosPrestados;
							visualizar(salida);
						} else {
							salida += "no tiene libros prestados";
							visualizar("no tiene libros prestados");
						}

						visualizar(salida);
					} else
						visualizar("este usuario no existe");
				} while (continuar("desea consultar otro prestamo"));
			} else
				visualizar("no hay prestamos registrados");
		}
	}

	private class OyenteModificarPrestamo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	private class OyenteEliminarPrestamo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	private class OyenteListarPrestamo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	private Usuario leerUsuario() {
		Usuario usuario = new Usuario();
		String nombre = leerCadena("Ingrese el nombre");
		String apellidoPaterno = leerCadena("Ingrese Apellido Paterno");
		String apellidoMaterno = leerCadena("Ingrese Apellido Materno");
		String genero = leerCadena("Ingrese Genero");
		String telefono = leerCadena("Ingrese Número de Telefono");
		String eMail = leerCadena("Ingrese e-Mail");
		Domicilio domicilio = new Domicilio();

		int numeroCasa = leerEntero("Ingrese Número de Casa");
		String calle = leerCadena("Ingrese Calle");
		String colonia = leerCadena("Ingrese Colonia");
		String ciudad = leerCadena("Ingrese Ciudad");
		String estado = leerCadena("Ingrese Estado");
		String codigoPostal = leerCadena("Ingrese Codigo Postal");

		domicilio.setNumeroCasa(numeroCasa);
		domicilio.setCalle(calle);
		domicilio.setColonia(colonia);
		domicilio.setCiudad(ciudad);
		domicilio.setEstado(estado);
		domicilio.setCodigoPostal(codigoPostal);

		usuario.setNombre(nombre);
		usuario.setApellidoPaterno(apellidoPaterno);
		usuario.setApellidoMaterno(apellidoMaterno);
		usuario.setGenero(genero);
		usuario.setTelefono(telefono);
		usuario.seteMail(eMail);
		usuario.setDomicilio(domicilio);

		return usuario;
	}

	private Libro leerLibro() {
		Libro libro = new Libro();

		String titulo = leerCadena("Ingrese Titulo");
		String autor = leerCadena("Ingrese el Autor");
		String editorial = leerCadena("Ingrese Editorial");
		String edicion = leerCadena("Ingrese Edición");

		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setEdicion(edicion);
		libro.setEditorial(editorial);
		return libro;
	}
}