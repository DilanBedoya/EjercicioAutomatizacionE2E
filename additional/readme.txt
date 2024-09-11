Tecnologías a utilizar:

SO: Windows 10 o superior.
IDE: IntelliJ IDEA 2023.3.2.
JDK: Versión 17 (configurado en JAVA_HOME).
Maven: Versión 3.9.1 (configurado en M2_HOME o MAVEN_HOME).
Serenity BDD: Versión 3.9.8.
ChromeDriver: Verificar versión y descargar desde aquí.

Instrucciones para Ejecutar los Tests:

En IntelliJ IDEA:
Abre IntelliJ IDEA y selecciona File > Open.
Navega hasta el directorio del proyecto y selecciona la carpeta raíz donde está el proyecto.
Verifica ChromeDriver en src/test/resources/webdriver/windows.
Navega a src/test/java/com/example/runners y ejecuta CucumberTestSuite, especificando el tag del escenario en src/test/resources/features/web.

Para generar reportes:
Ejecuta mvn serenity:aggregate luego de haber ejecutado CucumberTestSuite.
Abre target/site/serenity/index.html en tu navegador.
Elimina target antes de generar nuevos reportes.