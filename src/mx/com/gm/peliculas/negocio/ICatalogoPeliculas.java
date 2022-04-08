/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.peliculas.negocio;

/**
 *
 * @author DIDIER JAVIER
 */
public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "Peliculas.txt";
    
    public void agregarPelicula(String nombrePelicula);
    
    public void listarPeliculas();
    
    public void buscarPelicula(String buscar);
    
    public void iniciarCatalogoPeliculas();
}
