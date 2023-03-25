package BolsaDeEmpleo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.support.ConnectionSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Panel {

    public static void main(String[] args) throws Exception {

        Logger.setGlobalLogLevel(Level.OFF);
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        String cedula;
        String nombre;
        int edad;
        int experiencia;
        String profesion;
        String telefono;

        // Ubicación del archivo de la base de datos
        String url = "jdbc:h2:file:./BolsaDeEmpleo";
        ConnectionSource conexion =
                new JdbcConnectionSource(url);

        // Obtener acceso a la lista de objetos=>Tabla (DAO)
        // Primero es la clase de la tabla, Segundo tipo de la llave
        Dao<Aspirante, String> listaAspirantes =
                DaoManager.createDao(conexion, Aspirante.class);

        //MENU DE OPCIONES

        do {
            System.out.println("----- BOSLA DE EMPLEO -----");
            System.out.println("1. Agregar hoja de vida de aspirante.");
            System.out.println("2. Mostrar la información detallada del aspirante.");
            System.out.println("3. Buscar por nombre del aspirante.");
            System.out.println("4. Ordenar la lista de aspirantes por los diferentes criterios: años de experiencia, edad y profesión.");
            System.out.println("5. Consultar el aspirante con mayor experiencia.");
            System.out.println("6. Consultar el aspirante más joven.");
            System.out.println("7. Contratar un aspirante (eliminarlo de la lista de aspirantes de la bolsa).");
            System.out.println("8. Eliminar aquellos aspirantes cuya experiencia sea menor a una cantidad de años especificada.");
            System.out.println("9. Presentar el promedio de edad de los aspirantes.");
            System.out.println("0. Salir");

            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // consumir el carácter de salto de línea

            switch (opcion) {

                case 1:
                    System.out.println("1. Agregar hoja de vida de aspirante.");

                    System.out.println("Ingrese los siguientes datos:");

                    System.out.print("Cedula: ");
                    cedula = entrada.nextLine();

                    System.out.println("Nombre Completo: ");
                    nombre = entrada.nextLine();

                    System.out.println("Edad: ");
                    edad = entrada.nextInt();

                    System.out.println("Años de experiencia: ");
                    experiencia = entrada.nextInt();

                    entrada.nextLine(); // consumir el carácter de salto de línea

                    System.out.println("Profesion: ");
                    profesion = entrada.nextLine();

                    System.out.println("Telefono: ");
                    telefono = entrada.nextLine();

                    //Creamos un objeto aspirante con todas la variables
                    Aspirante aspirante = new Aspirante(cedula, nombre, edad, experiencia, profesion, telefono);

                    //creamos el objeto en la base de datos
                    listaAspirantes.create(aspirante);


                    System.out.println("Cedulas registradas:  ");
                    //siclo para ver las cedulas registradas en la base de datos
                    for (Aspirante a : listaAspirantes) {

                        System.out.println("Nombre: "+ a.getNombreCompleto()+" ---> "+"Cedula: " + a.getCedula());

                    }

                    break;


                case 2:
                    System.out.println("2. Mostrar la información detallada de un aspirante por medio de Cedula.");
                    // aquí iría el código para la opción 2
                    System.out.println();
                    System.out.print("Ingrese el numero de cedula a buscar: ");
                    cedula = entrada.nextLine();

                    Aspirante aspirante1 = listaAspirantes.queryForId(cedula);

                    if(aspirante1 == null){

                        System.out.println("No existe un aspirante con esa cedula: " + cedula);

                    }
                    else {
                        System.out.println("Cedula: " + aspirante1.getCedula());
                        System.out.println("Nombre: " + aspirante1.getNombreCompleto());
                        System.out.println("Edad: " + aspirante1.getEdad());
                        System.out.println("Profesion: " + aspirante1.getProfesion());
                        System.out.println("Telefono: " + aspirante1.getTelefono());
                        System.out.println("Años de experiencia: " + aspirante1.getAnosExperiencia());

                    }

                    break;


                case 3:

                    System.out.println("3. Buscar por nombre del aspirante.");
                    System.out.println();
                    System.out.println("Ingrese  el nombre completo del aspirante: ");
                    nombre= entrada.nextLine();

                    // itera a través de la lista de aspirantes y agrega aquellos que tengan un nombre
                    // que coincida con el ingresado por el usuario en una lista de aspirantes encontrados.

                    List<Aspirante> aspirantesEncontrados = new ArrayList<>();
                    for (Aspirante aspirante2 : listaAspirantes) {
                        if (aspirante2.getNombreCompleto().equalsIgnoreCase(nombre)) {
                            aspirantesEncontrados.add(aspirante2);
                        }
                    }

                    //Si no se encuentra ningún aspirante con el nombre ingresado, se muestra un mensaje
                    // indicando que no existe ningún aspirante con ese nombre. De lo contrario, se muestra
                    // la información de todos los aspirantes encontrados con el nombre ingresado.

                    if (aspirantesEncontrados.isEmpty()) {
                        System.out.println("No existe un aspirante con ese nombre: " + nombre);
                    } else {
                        for (Aspirante aspirante2 : aspirantesEncontrados) {
                            System.out.println("Cedula: " + aspirante2.getCedula());
                            System.out.println("Edad: " + aspirante2.getEdad());
                            System.out.println("Profesion: " + aspirante2.getProfesion());
                            System.out.println("Telefono: " + aspirante2.getTelefono());
                            System.out.println("Años de experiencia: " + aspirante2.getAnosExperiencia());
                            System.out.println();
                        }
                    }

                    break;


                case 4:
                    System.out.println("Ha seleccionado la opción 4.");
                    // aquí iría el código para la opción 4
                    break;


                case 5:
                    System.out.println("5. Consultar el aspirante con mayor experiencia.");

                    // inicializamos una variable aspiranteMayorExperiencia en null.
                    // Luego, itera a través de la lista de aspirantes y compara los años
                    // de experiencia de cada aspirante con los años de experiencia del
                    // aspirante con mayor experiencia encontrado hasta el momento.

                    Aspirante aspiranteMayorExperiencia = null;
                    for (Aspirante aspirante4 : listaAspirantes) {
                        if (aspiranteMayorExperiencia == null || aspirante4.getAnosExperiencia() > aspiranteMayorExperiencia.getAnosExperiencia()) {
                            aspiranteMayorExperiencia = aspirante4;
                        }
                    }
                    if (aspiranteMayorExperiencia == null) {
                        System.out.println("No se encontraron aspirantes en la lista.");
                    } else {
                        System.out.println("El aspirante con mayor experiencia es: " + aspiranteMayorExperiencia.getNombreCompleto() + " con " + aspiranteMayorExperiencia.getAnosExperiencia() + " años de experiencia.");
                    }

                    break;


                case 6:

                    System.out.println("6. Consultar el aspirante más joven. ");

                    //inicializamos una variable aspiranteMasJoven en null.
                    // Luego, itera a través de la lista de aspirantes y compara la edad de cada aspirante
                    // con la edad del aspirante más joven encontrado hasta el momento.

                    Aspirante aspiranteMasJoven = null;
                    for (Aspirante aspirante5 : listaAspirantes) {
                        if (aspiranteMasJoven == null || aspirante5.getEdad() < aspiranteMasJoven.getEdad()) {
                            aspiranteMasJoven = aspirante5;
                        }
                    }
                    if (aspiranteMasJoven == null) {
                        System.out.println("No se encontraron aspirantes en la lista.");
                    } else {
                        System.out.println("El aspirante más joven es: " + aspiranteMasJoven.getNombreCompleto() + " con " + aspiranteMasJoven.getEdad() + " años.");
                    }

                    break;


                case 7:
                    System.out.println("Ha seleccionado la opción 7.");
                    // aquí iría el código para la opción 7
                    break;


                case 8:
                    System.out.println("Ha seleccionado la opción 8.");
                    // aquí iría el código para la opción 8
                    break;



                case 9:
                    System.out.println("9. Presentar el promedio de edad de los aspirantes.");
                    //Lo que hace este código es inicializar dos variables, totalEdades y numAspirantes, en cero.
                    // Luego, itera a través de la lista de aspirantes y agrega la edad de cada aspirante
                    // a la variable totalEdades, y aumenta la variable numAspirantes en uno por cada aspirante.

                    int totalEdades = 0;
                    int numAspirantes = 0;

                    for (Aspirante aspirante8 : listaAspirantes) {
                        totalEdades += aspirante8.getEdad();
                        numAspirantes++;
                    }
                    double promedioEdad = (double) totalEdades / numAspirantes;
                    System.out.println("El promedio de edad de los aspirantes es: " + promedioEdad);

                    break;



                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println(); // imprime una línea en blanco para separar las opciones

        } while (opcion != 0);


        // Cerrar la conexión
        conexion.close();


    }
}


