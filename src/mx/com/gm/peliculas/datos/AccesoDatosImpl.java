/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;
/**
 *
 * @author DIDIER JAVIER
 */
public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreRecurso){
        var archivo = new File(nombreRecurso);//Se crea la variable archivo; no se crea un archivo
        return archivo.exists();//Se pregunta si el recurso existe; retorna verdadero o falso
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));//Se lee la información del archivo
            String lectura = null;
            lectura = entrada.readLine();
            while(lectura != null){             //Ciclo while para leer la información hasta que haya una línea en blanco
                Pelicula pelicula = new Pelicula(lectura);//Por cada línea se crean objetos tipo película
                peliculas.add(pelicula);  //Se guardan los objetos tipo película en el Array
                lectura = entrada.readLine(); 
            }
            entrada.close();//Se cierra el flujo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al listar películas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al listar películas" + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));//PrintWriter permite crear y escribir archivos
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito información al archivo" + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepción al escribir películas" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null; //Se almacena el resultado de la búsqueda. Si se encuentra se retorna el nombre e índice de la película
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            lectura = entrada.readLine();
            int indice = 1;
            while(lectura != null){
                if (buscar != null && buscar.equalsIgnoreCase(lectura)){
                    resultado = "Pelicula: " + lectura + ". Encontrada en el índice: " + indice + "\n";
                    break;
                }
                lectura = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al buscar película" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al buscar película" + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);//Se crea un objeto de tipo file en memoria
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));//PrintWriter permite crear y escribir archivos
            salida.close();//El archivo que se abrió se tiene que cerrar y en este momento se crea el archivo en memoria
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepción al crear archivo" + ex.getMessage());        }
    }

    @Override
    public void borrar(String nombreRecurso){
        var archivo = new File(nombreRecurso);
        if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
}
