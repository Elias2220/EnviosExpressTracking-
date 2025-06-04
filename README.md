# EnviosExpress Tracking API SOAP

## Descripción

Este proyecto implementa una API SOAP que permite consultar el estado, ubicación actual, fecha estimada de entrega y el historial de eventos de un paquete utilizando un número único de seguimiento (tracking number).

La API está desarrollada en Java utilizando **JAX-WS** y se publica como un servicio SOAP estándar.

---

## Estructura del Proyecto

---

## Cómo ejecutar el proyecto

### 1. Base de datos
- Crea la base de datos `enviosexpress_db` y las tablas `package` y `tracking_event` con el siguiente script SQL:
    ```sql
    CREATE DATABASE enviosexpress_db;
     Crear tablas y agregar datos de ejemplo
    -- Tabla paquetes
    CREATE TABLE package (
      tracking_number VARCHAR(20) PRIMARY KEY,
      sender_name VARCHAR(100),
      receiver_name VARCHAR(100),
      origin VARCHAR(100),
      destination VARCHAR(100),
      weight NUMERIC,
      dimensions VARCHAR(50),
      status VARCHAR(50),
      current_location VARCHAR(100),
      estimated_delivery_date DATE
      );

    -- Tabla eventos de tracking
    CREATE TABLE tracking_event (
      id SERIAL PRIMARY KEY,
      tracking_number VARCHAR(20) REFERENCES package(tracking_number),
      event_date DATE,
      description TEXT,
      location VARCHAR(100)
  );

    ```
    

### 2. Configuración de dependencias

El proyecto usa Maven para gestionar dependencias. Asegúrate de tener Maven y JDK instalados en tu entorno.

- **Maven**: [Descargar Maven](https://maven.apache.org/download.cgi)
- **JDK**: [Descargar JDK](https://adoptopenjdk.net/)

### 3. Ejecución en IntelliJ IDEA

1. Abre el proyecto en IntelliJ IDEA.
2. Compila y reconstruye el proyecto:
    - **Build > Rebuild Project**
3. Ejecuta la clase `TrackingServicePublisher` para publicar el servicio SOAP:
    - Haz clic derecho sobre la clase y selecciona **Run 'TrackingServicePublisher'**.
    - El servicio será accesible en `http://localhost:8080/ws/tracking`.

### 4. Probar el servicio

Usa **SoapUI** o **Postman** para probar el servicio SOAP utilizando el WSDL generado en `http://localhost:8080/ws/tracking?wsdl`.

---


## Autor

**Elias Mateo Espinosa Vera, Bryan Alexander Alarcon Iza**  
Universidad de las Fuerzas Armadas ESPE  
eemunoz4@espe.edu.ec

---

## Licencia

Este proyecto es de uso educativo y puede ser modificado libremente.

