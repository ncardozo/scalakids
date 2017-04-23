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

/**
 * Clase que representa una reacción.
 */
public class Reaccion
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * 
     * Constante que representa la reacción me gusta.
     */
    public final static String ME_GUSTA = "Me gusta";

    /**
     * Constante que representa la reacción corazón.
     */
    public final static String CORAZON = "Corazón";

    /**
     * Constante que representa la reacción cara feliz.
     */
    public final static String CARA_FELIZ = "Cara feliz";

    // -----------------------------------------------------------------
    // Atributo
    // -----------------------------------------------------------------
    /**
     * El nombre de la reacción.
     */
    private String nombre;

    /**
     * La cantidad de veces que han reaccionado.
     */
    private int cantidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea un nuevo tipo de reacción. </br>
     * <b>post: </b> El nombre de la reacción se inicializó con el valod dado por parámetro.<br>
     * La cantidad de reacciones se inicializó en 0.
     * @param pNombre Nombre de la reacción. pNombre != "" && pNombre != null.
     */
    public Reaccion( String pNombre )
    {
        nombre = pNombre;
        cantidad = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la reacción.
     * @return Nombre de la reacción.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la cantidad de veces que se ha reaccionado.
     * @return Cantidad de veces que se ha reaccionado.
     */
    public int darCantidad( )
    {
        return cantidad;
    }

    /**
     * Aumenta la cantidad de veces que se ha reaccionado en uno. <br>
     * <b> post: </b> La cantidad de veces que se ha reaccionado aumentó en uno. <br>
     */
    public void aumentarCantidad( )
    {
        cantidad++;
    }
}
