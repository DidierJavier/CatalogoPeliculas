# CatalogoPeliculas
En este laboratorio final vamos a crear un ejercicio que simule un catálogo de películas. Para este ejercicio, vamos a almacenar la información del catálogo de 
películas en un archivo de texto, en una carpeta definida por nosotros, por ejemplo en la carpeta: c:\catalogoPeliculas\películas.txt Vamos a crear varios paquetes, 
cada uno con tareas específicas a desarrollar en el programa.

Paquetes:
1. Crear un paquete de excepciones.
2. Crear un paquete mx.com.gm.películas.domain que incluya una clase llamada Pelicula. Las clases almacenadas en este paquete, se conoce como las clases del dominio
   del problema.
3. Crear un paquete llamado mx.com.gm.películas.datos la cual incluye una interface y una clase que implementa dicha interface. El objetivo de estas clases es agregar
   la funcionalidad para interactuar con el archivo donde se va a guardar la información del catálogo de películas.
4. Crear el paquete llamado mx.com.gm.peliculas.negocio el cual incluye las clases para definir la funcionalidad de nuestra aplicación, también conocido como las 
   reglas de negocio de la aplicación.
6. Finalmente crearemos la clase CPJLaboratorioFinal, que significa CursoProgramacionJavaLaboratorioFinal, el cual incluye un menú de opciones para escoger la opción
   a procesar en el programa.
   
CatalogoPelicula: Esta clase nos servirá para representar el objeto Pelicula. En esta aplicación dejamos simple la definición de este objeto, sin embargo podría tener
  más atributos y hacer más compleja esta aplicación, pero el objetivo es que podamos desarrollar esta aplicación con la estructura planteada.
IAccesoDatos: Esta interfaz define los métodos para interactuar con el archivo que administrará el catálogo de películas. La clase AccesoDatosImpl es la que finalmente
  se encargará de agregar el comportamiento de cada uno de los métodos descritos.
El paquete de mx.com.gm.películas.negocio: contiene las clases que implementarán las reglas de negocio de nuestra aplicación. Y a su vez este es el paquete que será el
  intermediario entre la interfaz con el usuario (método main) y el guardado de la información (paquete de datos). Similar al paquete da datos, este paquete hemos 
  agregado también una interfaz y una implementación. De esta manera la interfaz de usuario (método main) hará uso de la interface, y será la implementación de 
  CatalagoPeliculasImpl.java quien finalmente ejecutará las tareas que sean necesarias para esta aplicación. A su vez la implementación del catálogo de películas será
  quien utilice la interface de AccesoDatos.java, por lo que al hacer uso de interfaces es que en cualquier momento podríamos cambiar la implementación y afectaríamos
  lo menos posible al código que ya hemos programado. A esta característica se le conoce como bajo acomplamiento, ya que un cambio en un componente o una clase afecta
  lo menos posible a otra clase, así que es sólo una de las muchas ventajas de programar utilizando interfaces y no utilizar directamente la implementación de la
  funcionalidad que necesitamos.
Clase MAIN: Esta clase representa la inteface con la que el usuario interactua. Esta clase solicita via consola la acción requerida por parte del usuario, y solicita
  opciones como:
  1.- Iniciar catalogo películas
  2.- Agregar película
  3.- Listar Películas
  4.- Buscar Película
  0.- Salir
  Y dependiendo de la opción elegida por el usuario es la acción que se ejecuta. Esta clase se apoya de la clase Catalogopeliculas para realizar las operaciones que
  necesita esta aplicación. A su vez la variable opción es la que se encargará de almacenar la opción seleccionada por parte del usuario. Y el nombre del archivo
  indica la ruta donde se almacenará el archivo. Por ejemplo, la cadena Java que se puede utilizar si estamos en Windows es:
  "c:\\catalogoPeliculas\\peliculas.txt“
  Sin embargo si es otro sistema operativo, como MacOS, la ruta podría ser:
  “/Volumes/gm/catalogoPeliculas/películas.txt “
  Debemos recordar que la carpeta sobre la que vayamos a trabajar ya debe estar creada y en caso necesario debe tener permisos de escritura, esto es particular de
  los requerimientos de cada sistema operativo.
