<!-- @format -->

# Proyecto de Automatización de Pruebas E2E Serenity - DemoBlaze

Proyecto para realizar pruebas automatizadas para la validación de la web DemoBlaze

## Escenarios de Prueba

1. (CA01) Registrar nuevo usuario
2. (CA02) Login con cuenta existente
3. (CA03) Navegar a categoría de Phones
4. (CA04) Ver detalle de un Phone
5. (CA05) Añadir producto al carrito
6. (CA06) Ver carrito
7. (CA07) Eliminar producto del carrito
8. (CA08) Logout desde carrito
9. (CA09) Volver al home

## Requisitos Previos

Requisitos básicos para ejecutar los tests de este proyecto:

- Maven
- Java JDK 17 o superior
- Conexión a Internet (para acceder a la web de DemoBlaze)

## Pasos para ejecutar los tests

1. Clonar el repositorio (abrir git bash)

> git clone https://github.com/navialopez92/serenity-demoblaze

2. Entrar a la carpeta del repositorio clonado

> cd serenity-demoblaze

3. Ejecutar los tests

> mvn clean verify
