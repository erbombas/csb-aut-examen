<!-- @format -->

# Proyecto de Automatización de Pruebas E2E Serenity - Swag Labs

Proyecto para realizar pruebas automatizadas para la validación de la apk Swag Labs

## Escenarios de Prueba

1. (CA01) Validar que se muestre el título 'SwagLabs' y el botón 'LOGIN'
2. (CA02) Validar inicio de sesion exitosamente
3. (CA03) Validar que se adicione un producto al carrito
4. (CA04) Validar que se muestre un producto junto a su precio en el carrito
5. (CA05) Validar que se elimine un producto del carrito
6. (CA06) Validar que se muestre la seccion "Swag Labs"
7. (CA07) Validar cierre de sesión exitosamente

## Requisitos Previos

Requisitos básicos para ejecutar los tests de este proyecto:

- Maven
- Java JDK 17 o superior
- Appium Server

## Pasos para ejecutar los tests

1. Clonar el repositorio (abrir git bash)

> git clone https://github.com/navialopez92/serenity-appium-apk

2. Entrar a la carpeta del repositorio clonado

> cd serenity-appium-apk

3. Ejecutar los tests

> mvn clean verify
