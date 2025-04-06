# 📦 Interbank Reto Técnico - Procesador de Transacciones Bancarias

Este proyecto es una solución para un reto técnico que implica procesar transacciones bancarias desde un archivo CSV, realizar cálculos de montos y generar resultados con la transacción más alta. El objetivo es implementar una aplicación en Java que sea capaz de leer datos de un archivo CSV, procesarlos y permitir análisis básico de las transacciones.

---

## 🚀 Introducción

El propósito de este reto es construir una aplicación que procese datos de transacciones bancarias. La aplicación debe poder:

- ***Leer un archivo CSV con transacciones.***
- ***Balance Final:***
  - Suma de los montos de las transacciones de tipo "Crédito" menos la suma de los montos de las transacciones de tipo "Débito".
- ***Transacción de Mayor Monto:***
  - Identificar el ID y el monto de la transacción con el valor más alto.
- ***Conteo de Transacciones:***
  -Número total de transacciones para cada tipo ("Crédito" y "Débito").

Esta solución utiliza Java 17,MAVEN como gestor de dependencias, emplea herramientas como `BufferedReader` para la lectura de archivos y programación orientada a objetos.

---

## ⚙️ Instrucciones de Ejecución

### ✅ Requisitos

Asegúrate de tener instalado:

- **Java 17 o superior**  
  [Descargar Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  
  Para verificar la versión de Java instalada, ejecuta el siguiente comando en tu terminal:
  ```bash
  java -version
  ```
  tendrá que darte como respuesta algo similar a lo siguiente:
  ````
  java version "17.0.6" 2023-01-17 LTS
  ````
### 🛠️ Ejecución del Proyecto
1. #### Clonar o descargar el repositorio:
   ```bash
   git clone https://github.com/rod12151/RetoTecnico.git
   ```
2. #### Compilar el proyecto (si no está compilado):
   Navega a la carpeta del proyecto y compílalo utilizando Maven o tu herramienta de preferencia:
   ```bash
   mvn clean install
   ```
   
   Lo anterior creara un `app-rodmel.jar` en la carpeta `target`
   
    ```
    ├── RetoTecnico
    │ ├── .idea
    │ ├── src/main/java/rodmel
    │     │──CsvOperations.java
    │     │──Main.java
    │     └──Transaccion.java
    │ ├── target
    │     │── app-rodmel.jar   # Archivo JAR ejecutable
    ```
3. #### Ejecutar el archivo JAR:
    Una vez que tengas el archivo `app-rodmel.jar` generado, coloca el archivo CSV con las transacciones en una carpeta conocida.

    Para ejecutar la aplicación, navega a la carpeta del proyecto donde está el `.jar` y usa el siguiente comando:
    ```bash
    java -jar app-rodmel.jar ruta/al/archivo.csv
   ```
   Reemplaza `ruta/al/archivo.csv` con la ruta del archivo CSV que deseas procesar. <br/>
   ***Importante***<br/>
    El contenido del archivo `CSV` tiene que tener un formato como del siguiente ejemplo:
   ```
   id,tipo,monto
   1,Crédito,100.00
   2,Débito,50.00
   3,Crédito,200.00
   4,Débito,75.00
   5,Crédito,150.00
    ```
### 🧠 Enfoque y Solución
1. #### Lógica Implementada:
- **Lectura del archivo CSV:** <br/> Utilizo BufferedReader para leer línea por línea y procesar los datos de las transacciones. Los datos se extraen y se almacenan en una lista de objetos Transaccion (con atributos `id`, `tipo` y `monto`).
- **Calcular el balance final** <br/> Se creó una clase llamada `CsvOperation` el cual contiene varias funciones. <br/> para calcular el balance final se creó la función ` balanceFinal`  que recibe como parámetro una lista de objetos tipo `Transaccion`. <br/>
la función hace un `For` a la lista y almacena la suma los montos según el tipo de transacción ("Débito", "Crédito"). para al final devolver la operación `Crédito - Débito`. 
- **Identificar la transacción con el mayor monto**<br/>
Para dar solución a este campo utilizo la función `transaccionMayor` que está dentro de la clase`CsvOperation`, está función también recibe como parámetros de entrada una lista de objetos de tipo `transaccion`.<br/>
la función convierte la lista en un Stream utilizando la api Streams que tiene implementado Java, se hace esto para poder utilizar el método `Max()`. que tiene implementado está Api. se aplica este método en el atributo monto que tiene los objetos de la lista.
- **Calcular el total de transacciones por tipo (Débito o Crédito).**<br/>
Para dar solución a este campo también empleo la función ` balanceFinal` de la clase `CsvOperation`.<br/>
Al calcular el `balance final` hago un conteo según el tipo de transacción ("Débito", "Crédito") dentro del `For` que calcula la suma de montos.<br/>
### 📂 Estructura del Proyecto
1. #### carpetas 
    ```
    ├── RetoTecnico
    │ ├── .idea
    │ ├── src/main/java/rodmel
    │     │──CsvOperations.java  # Lógica para leer el archivo CSV y procesar las transacciones
    │     │──Main.java           # Clase principal que arranca la ejecución
    │     └──Transaccion.java    # Clase que representa una transacción bancaria
    │ ├── target
    │     │── app-rodmel.jar     # Archivo JAR ejecutable
    ├── pom.xml                  # Archivo de configuración de Maven
    ├── README.md                # Este archivo
    ```
2. #### Descripción de Archivos
- `CsvOperations.java`: Contiene métodos para leer el archivo CSV y transformar cada línea en una transacción, así como realizar cálculos con los datos.

- `Main.java`: Clase principal que ejecuta la lógica del proyecto y muestra los resultados.

- `Transaccion`.java: Clase que representa la estructura de cada transacción, con los atributos id, tipo y monto.



