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
 * Clase que representa un perro .
 */
public class Perro
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El nombre del perro.
     */
    private String nombre;

    /**
     * La edad del perro.
     */
    private int edad;

    /**
     * La raza del perro.
     */
    private String raza;

    /**
     * El sexo del perro.
     */
    private String sexo;

    /**
     * Lo que le gusta al perro.
     */
    private String meGusta;

    /**
     * Lo que no le gusta al perro.
     */
    private String noMeGusta;

    /**
     * Atributo que indica si el perro busca pareja.
     */
    private boolean buscoPareja;

    /**
     * La ruta de la foto del perro.
     */
    private String foto;

    /**
     * Lista de las reacciones obtenidas por el perro.
     */
    private ReaccionScala[] reacciones;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Crea un nuevo perro con la información dada por parámetro. </br>
     * <b> post: </b> Se inicializó el arregló de reacciones.<br>
     * El nombre, la edad, la raza, el sexo, la foto, y la información de me gusta, no me gusta y buscoPareja fueron inicializados con los valores dados.
     * @param pNombre Nombre del perro. pNombre != null && pNombre != "".
     * @param pEdad La edad del perro. pEdad >= 0.
     * @param pRaza Raza del perro. pRaza != null && pRaza != "".
     * @param pSexo Sexo del perro. pSexo != null && pSexo != "".
     * @param pFoto Foto del perro. pFoto != null && pFoto != "".
     * @param pMeGusta Lo que le gusta al perro. pMeGusta != null && pMeGusta != "".
     * @param pNoMeGusta Lo que no le gusta al perro. pNoMeGusta != null && pNoMeGusta != "".
     * @param pBuscoPareja Si el el perro está buscando pareja o no. pBuscoPareja == {true, false}.
     */
    public Perro( String pNombre, int pEdad, String pRaza, String pSexo, String pFoto, String pMeGusta, String pNoMeGusta, boolean pBuscoPareja )
    {
        reacciones = new ReaccionScala[3];
        reacciones[ 0 ] = new ReaccionScala( ReaccionScala.ME_GUSTA() );
        reacciones[ 1 ] = new ReaccionScala( ReaccionScala.CORAZON() );
        reacciones[ 2 ] = new ReaccionScala( ReaccionScala.CARA_FELIZ() );

        nombre = pNombre;
        edad = pEdad;
        raza = pRaza;
        sexo = pSexo;
        foto = "data/imagenes/" + pFoto;
        meGusta = pMeGusta;
        noMeGusta = pNoMeGusta;
        buscoPareja = pBuscoPareja;
    }

    /**
     * Retorna el nombre del perro.
     * @return Nombre del perro.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la edad del perro.
     * @return edad del perro.
     */
    public int darEdad( )
    {
        return edad;
    }

    /**
     * Retorna la raza del perro.
     * @return raza del perro.
     */
    public String darRaza( )
    {
        return raza;
    }

    /**
     * Retorna el sexo del perro.
     * @return sexo del perro.
     */
    public String darSexo( )
    {
        return sexo;
    }

    /**
     * Indica si el perro busca pareja.
     * @return true si busca pareja, false de lo contrario.
     */
    public boolean buscoPareja( )
    {
        return buscoPareja;
    }

    /**
     * Retorna lo que le gusta al perro.
     * @return La información de lo que le gusta al perro.
     */
    public String darMeGusta( )
    {
        return meGusta;
    }

    /**
     * Retorna lo que no le gusta al perro.
     * @return La información de lo que no le gusta al perro.
     */
    public String darNoMeGusta( )
    {
        return noMeGusta;
    }

    /**
     * Retorna la ruta donde se encuentra la foto del perro.
     * @return Ruta de la foto.
     */
    public String darFoto( )
    {
        return foto;
    }

    /**
     * Retorna la reacción con el nombre dado. </br>
     * <b> pre: </b> El arreglo de reacciones se encuentra inicializado.
     * @param pNombreReaccion Nombre de la reacción a buscar. pNombreReaccion pertenece {Reaccion.ME_GUSTA, Reaccion.CORAZON, Reaccion.CARA_FELIZ}.
     * @return Reacción con el nombre dado o null si no hay ninguna reacción con ese nombre.
     */
    public ReaccionScala darReaccion( String pNombreReaccion )
    {
    	ReaccionScala reaccion = null;
        for( int i = 0; i < reacciones.length; i++ )
        {
            if( reacciones[ i ].darNombre( ).equals( pNombreReaccion ) )
            {
                reaccion = reacciones[ i ];
            }
        }
        return reaccion;
    }

    /**
     * Aumenta en uno la cantidad de veces que se ha reaccionado con la reacción con el nombre dado por parámetro. </br>
     * <b> post: </b> Se aumentó en uno la cantidad de reacciones de la reacción on el nombre dado.
     * @param pNombreReaccion Nombre de la reacción a buscar. pNombreReaccion pertenece {Reaccion.ME_GUSTA, Reaccion.CORAZON, Reaccion.CARA_FELIZ}.
     */
    public void reaccionar( String pNombreReaccion )
    {
        boolean reacciono = false;
        for( int i = 0; i < reacciones.length && !reacciono; i++ )
        {
            if( reacciones[ i ].darNombre( ).equals( pNombreReaccion ) )
            {
                reacciones[ i ].aumentarCantidad( );
                reacciono = true;
            }
        }
    }

    /**
     * Retorna la cantidad de reacciones. </br>
     * <b> pre: </b> El arreglo de reacciones se encuentra inicializado.
     * @return cantidad de reacciones.
     */
    public int darCantidadReacciones( )
    {
        int cantidad = 0;
        for( int i = 0; i < reacciones.length; i++ )
        {
            cantidad += reacciones[ i ].darCantidad( );
        }
        return cantidad;
    }

}