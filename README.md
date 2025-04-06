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

Esta solución utiliza Java 17, y emplea herramientas como `BufferedReader` para la lectura de archivos y programación orientada a objetos.

---

## ⚙️ Instrucciones de Ejecución

### ✅ Requisitos

Asegúrate de tener instalado:

- **Java 17 o superior**  
  [Descargar Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  
  Para verificar la versión de Java instalada, ejecuta el siguiente comando en tu terminal:
  ```bash
  java -version
### 🛠️ Ejecución del Proyecto
1. Clonar o descargar el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/interbank-reto-tecnico.git
2. Compilar el proyecto (si no está compilado): Navega a la carpeta del proyecto y compílalo utilizando Maven o tu herramienta de preferencia:
   ```bash
   mvn clean install
