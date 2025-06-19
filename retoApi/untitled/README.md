# EXAMEN-Automatizacion

Este repositorio contiene la automatización de pruebas E2E 
API utilizando **Java, Serenity BDD, Screenplay, Appium y Gradle**.

##  Tecnologías utilizadas

- **Java**
- **Serenity BDD**
- **Screenplay Pattern**
- **Gradle**
- **Cucumber**

## Estructura del Proyecto


CSB-Examen-Automatizacion/
│── src/
│   ├── main/
│   │   ├── java/  # Código principal de automatización
│   │   │   ├── driver
│   │   │   ├── tasks
│   │   │   ├── interactions
│   │   │   ├── utils
│   │   │   ├── uis
│   │   │   ├── questions
│   │   ├── resources/
│   │   │   ├── DataEntry/  # Archivos JSON y XLSX para pruebas
│   ├── test/
│   │   │   ├── runners
│   │   │   ├── stepsdefintions
│   ├── resources/
│   │   │   ├── features  
│── build.gradle  # Configuración de Gradle
│── README.md  # Este archivo
```

###  Instalación y Configuración

1. **Clonar el repositorio**
   ```sh
   git clone https://github.com/tu-usuario/CSB-Examen-Automatizacion.git
   cd CSB-Examen-Automatizacion
   ```

2. **Configurar las dependencias**
   ```sh
   ./gradlew clean build
   ```
##  Ejecución de Pruebas
#### 🔹 Pruebas API
```sh
gradle clean test -Dcucumber.options="--tags @api"
```
##  Casos de Prueba Implementados

### 🔗 API - [PetStore](https://petstore.swagger.io/v2/)
- Crear, modificar y eliminar mascotas

##  Reportes
Los reportes se generan automáticamente en `target/site/serenity/index.html` después de la ejecución.

