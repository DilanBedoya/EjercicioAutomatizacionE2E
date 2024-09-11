
# Ejercicio de Automatización E2E en Demoblaze

Este repositorio contiene la automatización de pruebas para el flujo de compra en la página https://www.demoblaze.com.
Las pruebas se han implementado utilizando Serenity BDD y se han añadido instrucciones detalladas para la ejecución del proyecto.


## 1. Prerequisitos

Para ejecutar este proyecto, debes tener lo siguiente configurado en tu máquina local:

- **Sistema operativo:**  Windows 10 (o Superior)
- **IDE recomendado:** IntelliJ IDEA 2023.3.2
- **Java Development Kit (JDK):** Versión 17 (Debe estar en la variable de entorno JAVA-HOME)
- **Maven:** Versión 3.9.1 (Debe estar en las variables de entorno M2-HOME o MAVEN_HOME)
- **Serenity BDD:** Versión 3.9.8 (Recomendado).
- **chromedriver:** Verificar la versión de Chrome y descargar el driver compatible en el siguiente enlace Win64 o Win32: https://googlechromelabs.github.io/chrome-for-testing/


## 2. Comandos de instalación

1. Clona el repositorio desde GitHub o descarga el Zip:
   ```
   git clone https://github.com/DilanBedoya/EjercicioAutomatizacionE2E.git
   ```
2. Descarga las dependencias utilizando Maven (En caso de ser necesario):
   ```
   mvn install -DskipTests
   ```

## 3. Instrucciones para ejecutar los tests

1. **Ejecución de las pruebas**:
   Para ejecutar las pruebas, sigue los siguientes pasos para el IDE Correspondiente:

   ### IntelliJ IDEA:
   - Abre IntelliJ IDEA y selecciona `File > Open`.
   - Navega hasta el directorio del proyecto y selecciona la carpeta raíz donde está el proyecto.
   - Primero verificar el Chrome Driver compatible en la ubicación `src/test/resources/webdriver/windows` en caso de no tener el driver actualizado remplazar en dicha ruta. 
   - En el panel de proyectos, ve a la ruta `src/test/java/com/example/runners` y selecciona el archivo de prueba `CucumberTestSuite`
   - Una vez dentro, especificar el tag del escenario a ejecutarse el cual se encuentra en la ruta: `src/test/resources/features/web` ,posterior a ello, ejecutar la clase `CucumberTestSuite`
   - El IDE ejecutará las pruebas y mostrará los resultados en la consola.

2. **Verificación de reportes en SerenityBDD**:
   Después de que las pruebas se ejecuten, se creará la siguiente carpeta  la carpeta `/target` aún sin generar el reporte.

   Para generar el **Reporte** ejecutar el siguiente comando en la terminal del IDE (Ubicarse en la ruta Raíz del proyecto de ser necesario):
   ````
   mvn serenity:aggregate
   ````

   - Luego de haber ejecutado el comando se creará el reporte, abre la carpeta `target` en el directorio principal del proyecto.
   - Dentro de `target`, abre la carpeta `site/serenity` y busca el archivo `index.html`.
   - Abre `index.html` en tu navegador preferido para ver el reporte de los resultados de las pruebas.
   - **IMPORTANTE**: Borrar la carpeta Target y ejecutar la clase `CucumberTestSuite` con su respectivo tag y también el comando `mvn serenity:aggregate` para generar un nuevo reporte.


## 4. Información adicional
1. Estructura de Carpetas:
`src/test/java/com/example` - Contiene las pruebas automatizadas escritas en Java.
`src/test/resources/` - Contiene archivos de configuración, el feature y recursos adicionales para las pruebas.
`target/site/serenity/` - Contiene los reportes generados por Serenity BDD.

![image](https://github.com/user-attachments/assets/8871dfd5-b64e-447c-ab04-6fa09450010d)

![image](https://github.com/user-attachments/assets/e582a699-0ec0-4f3c-93d0-660241239af5)

![image](https://github.com/user-attachments/assets/000c0b85-3e4a-4b9c-a136-ef23d70a0be2)

