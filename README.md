# personal_repository

Proyecto prueba IBM

// Para ejecutar el programa //

1. Descargue el archivo "programa.jar".
2. Abrir una consola de linea de comandos.
3. Dirijase a la ubicación del archivo descargado "programa.jar" mediante comandos.
4. Ejecute el comando "java -jar programa.jar {{parametro}}"

El campo parámetro descrito arriba será un número entero que representa el código de cliente. Cualquier caracter introducido dará un error y
se tendrá que volver a ejecutar el programa.

El programa generará un fichero de texto plano con el nombre "proveedores[numero].txt", donde número será el id de cliente que hemos introducido para la ejecución del programa
y que nos facilitará la identificación del fichero.
Si introducimos un id de cliente que no existe en la base de datos, nos avisará que no hay proveedores y no creará se el fichero.

// Ruta donde se genera el fichero resultado //

El fichero resultado de la ejecución del programa se generará en la carpeta raiz donde coloques el archivo ejecutable jar.
Por ejemplo: Si tenemos el jar en "C:/Usuarios/usuario/Nueva Carpeta", el fichero se generará en esa misma carpeta "C:/Usuarios/usuario/Nueva Carpeta/proveedores5.txt"

// Dependencias //

La única dependencia usada en el programa ha sido el jar que contiene el driver para la base de datos mysql, contenido en la carpeta "lib".
-> mysql-connector-java-5.0.8-bin.jar
