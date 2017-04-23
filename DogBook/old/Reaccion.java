/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: dogBook
 * Autor: Equipo Cupi2 - 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.dogBook.mundo;

/**
 * Clase que representa una reacci�n.
 */
public class Reaccion
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * 
     * Constante que representa la reacci�n me gusta.
     */
    public final static String ME_GUSTA = "Me gusta";

    /**
     * Constante que representa la reacci�n coraz�n.
     */
    public final static String CORAZON = "Coraz�n";

    /**
     * Constante que representa la reacci�n cara feliz.
     */
    public final static String CARA_FELIZ = "Cara feliz";

    // -----------------------------------------------------------------
    // Atributo
    // -----------------------------------------------------------------
    /**
     * El nombre de la reacci�n.
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
     * Crea un nuevo tipo de reacci�n. </br>
     * <b>post: </b> El nombre de la reacci�n se inicializ� con el valod dado por par�metro.<br>
     * La cantidad de reacciones se inicializ� en 0.
     * @param pNombre Nombre de la reacci�n. pNombre != "" && pNombre != null.
     */
    public Reaccion( String pNombre )
    {
        nombre = pNombre;
        cantidad = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la reacci�n.
     * @return Nombre de la reacci�n.
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
     * <b> post: </b> La cantidad de veces que se ha reaccionado aument� en uno. <br>
     */
    public void aumentarCantidad( )
    {
        cantidad++;
    }
}
