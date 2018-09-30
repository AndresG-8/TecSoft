# TecSoft
Aplicación funcional para TecniCentros de motos. 
* Base de datos SQL Server, JasperReport, NetBeans 8.2, Windows, Java 1.8

# Antes de proceder usar el programa, verificar si cumple con los siguientes requisitos.
Tener instalado los siguientes programas:
* .NET Framework de Microsoft Corporation 
* SQL server 2014 Express Edition
* Java Runtime Environment (JRE)
	 C:\Program Files\Java\jreX.X.X_XX  
   por defecto java instala en esa ruta o en cmd (consola) escribir java -version
* para la seguridad integrada se usa una dll, ubicarla en el Java/JDK_XX/bin o en cualquier otro lugar
    dicha dll es sqljdbc_auth.dll que se encuentra en Microsoft JDBC Driver 6.0 for SQL Server
    o 6.4, https://www.microsoft.com/en-us/download/details.aspx?id=11774
  
# ¿Como iniciar?
* Crear un nuevo proyecto en NetBeans y darle elnombre TecSoft (sin clase principal)
* Descargar o clonar el proyecto en el directorio del nuevo proyecto creado
  -Eliminar la carpeta src que creo NetBeans o reemplazarla
* Construir aplicación

# Para correr esta aplicacion una vez compilada desde linea de comandos
java -jar "<UBICACION DEL ARCHIVO>\TecSoft.jar"
  si se desea cambiar de ubicación la carpeta 'dist' la cual contiene los archivos de la aplicación una vez compilado,
  se debe copiar la carpeta 'TecSoft' dentro de la misma. De esta manera cuando se ejecute el archivo 'TecSof.jar'
  ubicará los archivos extras necesarios 

# Para tener en cuenta
* para la creacion del archivo para la copia de seguridad
https://docs.microsoft.com/es-es/sql/relational-databases/scripting/sqlcmd-connect-to-the-database-engine?view=sql-server-2017
* Guardar dos imagenes con el mismo nombre al mismo cliente puede causar perdida de datos
* Procure no guardar imagenes con el mismo nombre
* Si desea cambiar las placas de una moto y esta nueva placa ya existe en la base de datos
debera eliminar primero la moto y luego volverla a crear. si no existe, lo puede hacer

# TODO
*Login del paquete Login2
-se puede cambiar el getText en la contraseña por un getPassword que es mas seguro
	https://docs.oracle.com/javase/tutorial/uiswing/components/passwordfield.html

* Logon del paquete Login2
-los metodos para obtener la contraseña deberian ser privados

* se podria crear un historico de la agenda. y hay que hacer que elimine las pasadas cada x tiempo (puede ser semanal)

* AGREGAR FUNCION PARA RESTAURAR LA BASE DE DATOS
