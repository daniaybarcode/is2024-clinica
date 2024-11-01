# Estructura de Capas del Proyecto Clínica

Organización de las capas en el proyecto Spring Boot para la clínica, siguiendo una arquitectura limpia y desacoplada.

---

## 1. Capa de Controlador (Controller)

- **Ubicación**: `package com.grupo3.is2024clinica.controller`
- **Responsabilidad**:
    - Esta capa maneja las solicitudes HTTP y es el punto de entrada de la API.
    - Recibe las peticiones (POST, GET, PUT, DELETE) y envía las respuestas adecuadas.
    - Llama a la capa de servicio para realizar operaciones de negocio.
- **Ejemplo**: `MedicoController.java` o `PersonaController.java`

---

## 2. Capa de Servicio (Service)

- **Ubicación**: `package com.grupo3.is2024clinica.service`
- **Responsabilidad**:
    - Define la lógica de negocio de la aplicación.
    - Contiene métodos que gestionan las reglas de negocio.
    - Los controladores llaman a la capa de servicio para obtener datos o realizar operaciones, sin conocer los detalles de cómo se implementan.
- **Ejemplo**: `MedicoService.java` o `PersonaService.java`

---

## 3. Capa de Repositorio (Repository)

- **Ubicación**: `package com.grupo3.is2024clinica.repository`
- **Responsabilidad**:
    - Se comunica directamente con la base de datos utilizando Spring Data JPA para realizar operaciones CRUD.
    - Maneja las consultas a la base de datos, abstractando la persistencia de datos.
- **Ejemplo**: `MedicoRepository.java` o `PersonaRepository.java`

---

## 4. Capa de Modelo (Model)

- **Ubicación**: `package com.grupo3.is2024clinica.model`
- **Responsabilidad**:
    - Contiene las entidades que representan las tablas de la base de datos.
    - Define los datos y atributos de cada entidad y permite mapear la estructura de la base de datos en Java.
    - Usa anotaciones de JPA para definir relaciones entre tablas.
- **Ejemplo**: `Medico.java` o `Persona.java`

---

## 5. Capa de Excepciones (Opcional)

- **Ubicación**: `package com.grupo3.is2024clinica.exception`
- **Responsabilidad**:
    - Gestiona errores personalizados de la aplicación.
    - Define excepciones específicas que se lanzan y manejan en otras capas, controlando los errores y personalizando los mensajes de respuesta de la API.
- **Ejemplo**: `ResourceNotFoundException.java`

---

## 6. Capa de DTO (Data Transfer Object) (Opcional)

- **Ubicación**: `package com.grupo3.is2024clinica.dto`
- **Responsabilidad**:
    - Facilita la transferencia de datos entre la API y el cliente de forma controlada.
    - Permite evitar exponer toda la estructura de los modelos, controlar la información que se envía y estructurar mejor las solicitudes recibidas.
- **Ejemplo**: `MedicoDTO.java` o `PersonaDTO.java`

---

## 7. Capa de Configuración (Opcional)

- **Ubicación**: `package com.grupo3.is2024clinica.config`
- **Responsabilidad**:
    - Contiene clases de configuración como configuración de seguridad, configuración de CORS o configuraciones específicas de Spring.
- **Ejemplo**: `WebSecurityConfig.java` (para configuración de seguridad)

---

## Interacción entre capas

1. **Solicitud del Cliente**: Llega una solicitud al **Controlador**.
2. **Controlador a Servicio**: El controlador llama a la **Capa de Servicio** para ejecutar la lógica de negocio.
3. **Servicio a Repositorio**: La capa de servicio interactúa con el **Repositorio** para acceder a los datos o persistirlos.
4. **Repositorio a Base de Datos**: El repositorio realiza las operaciones de datos en la base de datos.
5. **Respuesta**: Los datos pasan de regreso del repositorio al servicio, luego al controlador, y finalmente se devuelven como respuesta al cliente.
