# Conversor de Monedas  

El siguiente programa realiza el consumo de una API de tasas de cambio (Exchange Rate API), obteniendo información actualizada para realizar la conversión de monedas de un conjunto de divisas. La ejecución se realiza de manera local por consola.  

## Funcionalidades  
- Menú interactivo y dinámico.  
- Filtrar, mostrar y convertir las monedas de interés.  
- Herramientas utilizadas:  
  - **Java**  
  - **HttpClient**  
  - **HttpRequest**  
  - **JSON**  
  - **Gson**  
  - **DTO**  
  - **Exceptions**  

## Requisitos Previos  

### 1. Instalar Java Development Kit (JDK)  
- Descargar JDK desde la página oficial:  
  [Descargar JDK](https://www.oracle.com/java/technologies/javase-downloads.html)  
- Asegúrate de tener la versión 8 o superior instalada.  

### 2. Descargar y Configurar Gson  
- Descargar el archivo JAR desde el siguiente enlace:  
  [Descargar Gson 2.11.0](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0)  
- Documentación oficial: [Google Gson GitHub](https://github.com/google/gson)  
- Agregar la dependencia Gson al proyecto.  

### 3. Conexión a Internet  
- Es necesario tener una conexión activa a Internet para el consumo de la API.  

### 4. Activar API Key (Si aplica)  
- Si la API utilizada requiere autenticación, asegúrate de incluir una clave de acceso (API Key) activa en el programa.  
- Especifica la clave directamente en el código donde se realiza el llamado al servicio.  

## Ejemplo de Uso  

```plaintext
-------------------------------------  
Bienvenido al Conversor de Monedas  

Seleccione entre las siguientes divisas:  

1) ARS - Peso argentino  
2) BOB - Boliviano boliviano  
3) BRL - Real brasileño  
4) CLP - Peso chileno  
5) COP - Peso colombiano  
6) USD - Dólar estadounidense  
7) Salir.  

Digite el número de la Divisa a Cambiar:  
6  
Divisa Actual: USD  

Digite el número de la Divisa a Cambiar:  
5  
Divisa a Cambiar: COP  

Ingrese Monto en USD:  
50  

Monto es: 50.0  
Tasa de cambio: 4414.1048  
De USD a COP  
Conversión: 220.705,24 COP  

Ingrese cualquier tecla para continuar con otra conversión.  
