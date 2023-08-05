# GameDev TaskManager - API REST en Spring para la gestión de tareas de desarrollo de videojuegos

¡Bienvenido a GameDev TaskManager! Este repositorio contiene una API REST desarrollada en Spring para gestionar las tareas de equipos de desarrollo de videojuegos. Con esta aplicación, puedes crear y administrar juegos, desarrolladores y sus respectivas tareas para llevar a cabo proyectos de videojuegos de manera efectiva.

## Funcionalidades

- Registro de juegos.
- Visualización de juegos en desarrollo.
- Visualización de juegos finalizados.
- Visualización de los desarrolladores asociados a un juego.
- Registro de desarrolladores.
- Asignación de desarrolladores a un juego.
- Asignación de tareas a desarrolladores para un juego específico.
- Visualización de tareas asignadas a un desarrollador.
- Actualización de estado de tareas (completada o en progreso).
- Búsqueda de tareas por estado o fecha límite.
- Búsqueda de tareas por juego.
- Búsqueda de tareas fuera del plazo límite.

## Dependencias

Las siguientes son las dependencias utilizadas en el proyecto:

- Spring Boot Starter Data JPA
- Spring Boot Starter Web (excluyendo Snakeyaml)
- MySQL Connector/J 8.0.32
- Lombok
- Spring Boot Starter Test (scope test)
- OpenCSV 5.7.1
- Jakarta Validation API 3.0.2
- Spring Boot Starter Validation

Puedes utilizar esta lista de dependencias en tu archivo de configuración de Maven o Gradle para asegurarte de tener todas las bibliotecas necesarias para ejecutar la API correctamente.

## Uso de la API

Puedes interactuar con la API utilizando herramientas como Postman. A continuación, se muestra un ejemplo de cómo realizar una solicitud:

**Ejemplo: Registro de un juego**

**Ruta**: POST /api/tpf/games

**Cuerpo de la solicitud**:
```json
{
    "titulo": "MiVideojuego",
    "descripcion": "Un increíble juego en desarrollo",
    "fechaLanzamiento": "05/08/2023"
}

**Respuesta exitosa**:

{
    "id": 1,
    "titulo": "MiVideojuego",
    "descripcion": "Un increíble juego en desarrollo",
    "fechaLanzamiento": "05/08/2023"
}