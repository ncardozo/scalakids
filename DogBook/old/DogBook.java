/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: dogBook
 * Autor: Equipo Cupi2 - 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.dogBook.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Clase que representa el dogBook.
 */
public class DogBook {
	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * El arreglo de perros en el dogBook.
	 */
	private PerroScala[] perros;

	/**
	 * La posición donde se encuentra el perro actual.
	 */
	private int perroActual;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Crea un nuevo dogBook con la información encontrada en el archivo. <br>
	 * <b> post: </b> El arreglo de perros ha sido inicializado. </br>
	 * Se inicializaron los perros con la información encontrada en el
	 * archivo.<br>
	 * La posición del perro actual se inicializó en cero.
	 * 
	 * @throws Exception
	 *             Si ocurre un error al cargar el archivo con la información
	 *             del dogBook.
	 */
	public DogBook() throws Exception {
		try {
			// Carga el archivo de propiedades
			Properties persistencia = new Properties();
			FileInputStream fis = new FileInputStream(new File("data/perros.data"));
			persistencia.load(fis);
			fis.close();

			// Lee la cantidad de perros del archivo
			int cantidadPerros = Integer.parseInt(persistencia.getProperty("dogBook.cantidadPerros"));

			// Inicializa el arreglo de perros
			perros = new PerroScala[cantidadPerros];

			// Carga la información del archivo.
			cargar(persistencia);

			// Inicializa la posición del perro actual en cero.
			perroActual = 0;
		} catch (Exception e) {
			throw new Exception("Error al cargar la información del archivo.");
		}
	}

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	/**
	 * Retorna la cantidad de perros que hay en el dogBook.</br>
	 * <b> pre: El arreglo de perros se encuentra inicializado.
	 * 
	 * @return Cantidad de perros del dogBook.
	 */
	public int darCantidadPerros() {
		return perros.length;
	}

	/**
	 * Retorna el perro actual del dogBook. </br>
	 * <b> pre: </b> El arreglo de perros se encuentra inicializado. </br>
	 * 
	 * @return Perro actual del dogBook.
	 * @throws Exception
	 *             Si no existe un perro en la posición actual del dogBook.
	 */
	public PerroScala darPerroActual() throws Exception {
		PerroScala perro = perros[perroActual];
		if (perro == null) {
			throw new Exception(" No existe ningún perro en la posición actual.");
		}
		return perro;
	}

	/**
	 * Retorna el perro ubicado en la posición siguiente a la actual del
	 * dogBook. </br>
	 * <b> pre: </b> El arreglo de perros se encuentra inicializado. </br>
	 * <b> post: </b> Se actualizó el atributo perroActual a la siguiente
	 * posición.
	 * 
	 * @return Perro en la posición siguiente.
	 * @throws Exception
	 *             Si ya se encuentra en el último perro.
	 */
	public PerroScala darPerroSiguiente() throws Exception {
		if (perroActual == perros.length - 1) {
			throw new Exception("Se encuentra en el último perro.");

		}
		perroActual++;
		return darPerroActual();
	}

	/**
	 * Retorna el perro ubicada en la posición anterior a la actual del dogBook.
	 * </br>
	 * <b> pre: <b> El arreglo de perros se encuentra inicializado. </br>
	 * <b> post: </b> Se actualizó el atributo perroActual a la anterior
	 * posición.
	 * 
	 * @return Perro en la posición anterior.
	 * @throws Exception
	 *             Si ya se encuentra en el primer perro.
	 */
	public PerroScala darPerroAnterior() throws Exception {
		if (perroActual == 0) {
			throw new Exception("Se encuentra en el primer perro. ");
		}
		perroActual--;
		return darPerroActual();
	}

	/**
	 * Retorna el perro ubicado en la primera posición del dogBook. </br>
	 * <b> pre: <b> El arreglo de perros se encuentra inicializado. </br>
	 * <b> post: </b> Se actualizó el atributo perroActual con el primer perro.
	 * 
	 * @return Primer perro del dogBook.
	 * @throws Exception
	 *             Si no existe ningún perro en el dogBook o si ya se encuentra
	 *             en el primer perro.
	 */
	public PerroScala darPrimerPerro() throws Exception {
		if (perros.length == 0) {
			throw new Exception("No existe ningún perro en el dogBook.");
		} else if (perroActual == 0) {
			throw new Exception("Ya se encuentra en el primer perro.");
		}
		perroActual = 0;
		return perros[0];
	}

	/**
	 * Retorna el último perro del dogBook. </br>
	 * <b> pre: </b> El arreglo de perros se encuentra inicializado. </br>
	 * <b> post: </b> Se actualizó el atributo perroActual con el último perro.
	 * 
	 * @return Último perro del dogBook.
	 * @throws Exception
	 *             Si no existe ningún perro en el dogBook o si ya se encuentra
	 *             en el último perro.
	 */
	public PerroScala darUltimoPerro() throws Exception {
		if (perros.length == 0) {
			throw new Exception("No existe ningún perro en el dogBook.");
		}
		if (perroActual == perros.length - 1) {
			throw new Exception("Ya se encuentra en el último perro.");
		}
		perroActual = perros.length - 1;
		return perros[perros.length - 1];
	}

	/**
	 * Retorna el perro que tiene el nombre dado. </br>
	 * <b> pre: </b> El arreglo de perros se encuentra inicializado. </br>
	 * 
	 * @param pNombre
	 *            Nombre del perro a buscar. pNombre != null && pNombre != "".
	 * @return Perro con el nombre dado.
	 * @throws Exception
	 *             Si no se encuentra ningún perro con el nombre dado.
	 */
	public PerroScala buscarPerroPorNombre(String pNombre) throws Exception {
		PerroScala buscado = null;
		for (int i = 0; i < perros.length & buscado == null; i++) {
			if (pNombre.equals(perros[i].nombre())) {
				buscado = perros[i];
				perroActual = i;
			}
		}

		if (buscado == null) {
			throw new Exception("No existe ningún perro con el nombre dado.");
		}
		return buscado;
	}

	/**
	 * Agrega una reacción al perro actual. </br>
	 * <b> pre: </b> El arreglo de perros se encuentra inicializado </br>
	 * <b> post: </b> Se aumentó en uno la reacción con el nombre dado al perro
	 * actual.
	 * 
	 * @param pNombreReaccion
	 *            Nombre de la reacción a buscar. pNombreReaccion pertenece
	 *            {Reaccion.ME_GUSTA, Reaccion.CORAZON, Reaccion.CARA_FELIZ}.
	 */
	public void reaccionar(String pNombreReaccion) {
		perros[perroActual].reaccionar(pNombreReaccion);
	}

	/**
	 * Retorna la reacción con el nombre dado por parámetro del perro actual.
	 * </br>
	 * <b> pre: <b> El arreglo de perros se encuentra inicializado.
	 * 
	 * @param pNombreReaccion
	 *            Nombre de la reacción a buscar. pNombreReaccion pertenece
	 *            {Reaccion.ME_GUSTA, Reaccion.CORAZON, Reaccion.CARA_FELIZ}.
	 * @return Reacción con el nombre dado por parámetro.
	 */
	public ReaccionScala darCantidadReaccionPerros(String pNombreReaccion) {
		return perros[perroActual].darReaccionJava(pNombreReaccion);
	}

	/**
	 * Retorna el perro más popular. <br>
	 * <b> pre: </b> La lista de perros se encuentra inicializada.
	 * 
	 * @return Perro que tiene más reacciones.
	 * @throws Exception
	 *             Se lanza cuando no hay ningún perro en la lista.
	 */
	public PerroScala darPerroMasPopular() throws Exception {
		if (perros.length == 0) {
			throw new Exception("No existe ningún perro en el dogBook.");
		}

		PerroScala buscado = perros[0];
		for (int i = 1; i < perros.length; i++) {
			if (buscado.darCantidadReacciones() < perros[i].darCantidadReacciones()) {
				buscado = perros[i];
			}
		}
		return buscado;
	}

	/**
	 * Carga la información de los perros a partir del archivos properties.<br>
	 * </b> <b> post: </b> El arreglo de perros tiene un perro en cada posición.
	 * 
	 * @param pPersistencia
	 *            Archivo properties con la información de los perros.
	 *            pPersistencia != null.
	 */
	public void cargar(Properties pPersistencia) {
		for (int i = 1; i <= perros.length; i++) {
			String nombre = pPersistencia.getProperty("dogBook.perro" + i + ".nombre");
			int edad = Integer.parseInt(pPersistencia.getProperty("dogBook.perro" + i + ".edad"));
			String raza = pPersistencia.getProperty("dogBook.perro" + i + ".raza");
			String sexo = pPersistencia.getProperty("dogBook.perro" + i + ".sexo");
			String foto = pPersistencia.getProperty("dogBook.perro" + i + ".foto");
			String meGusta = pPersistencia.getProperty("dogBook.perro" + i + ".meGusta");
			String noMeGusta = pPersistencia.getProperty("dogBook.perro" + i + ".noMeGusta");
			boolean buscoPareja;
			if (pPersistencia.getProperty("dogBook.perro" + i + ".buscoPareja").equals("SI")) {
				buscoPareja = true;
			} else {
				buscoPareja = false;
			}

			PerroScala perro = new PerroScala(nombre, edad, raza, sexo, foto, meGusta, noMeGusta, buscoPareja);
			perros[i - 1] = perro;
		}
	}

	// -----------------------------------------------------------------
	// Métodos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método para la extensión 1.
	 * 
	 * @return respuesta1
	 */
	public String metodo1() {
		return "Respuesta 1";
	}

	/**
	 * Método para la extensión 2.
	 * 
	 * @return respuesta2
	 */
	public String metodo2() {
		return "Respuesta 2";
	}
}