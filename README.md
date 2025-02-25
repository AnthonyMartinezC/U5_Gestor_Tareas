# README

## Proyecto Spring Boot con Maven

Este proyecto es una aplicación Spring Boot que utiliza Maven para la gestión de dependencias.

### Requisitos

- Java 20 o superior
- Maven 3.6.0 o superior

### Instalación

1. Clona el repositorio:
   ```sh
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```

2. Compila y empaqueta la aplicación:
   ```sh
   ./mvnw clean package
   ```

### Ejecución

Para ejecutar la aplicación, usa el siguiente comando:
```sh
./mvnw spring-boot:run
```

La aplicación se levantará en `http://localhost:8080`.

### Documentación de la API

La documentación de la API está disponible en la carpeta `Swagger` del repositorio.

### Colección de Postman

Para facilitar las pruebas de la API, se incluye una colección de Postman. Puedes importar la colección desde el archivo `postman_collection.json` que se encuentra en la raíz del proyecto.

### Contribuciones

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

### Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.