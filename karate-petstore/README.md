<!-- @format -->

# Proyecto de Automatización de Pruebas E2E Karate - PetStore

Proyecto para realizar pruebas automatizadas para la validación de la API de gestión de mascotas.

## Escenarios de Prueba

1. (CA01) Adicionar nueva mascota con fichero JSON
2. (CA02) Verificar que la mascota se adicionó satisfactoriamente
3. (CA03) Actualizar nombre de una mascota existente
4. (CA04) Verificar el nombre de la mascota actualizada
5. (CA05) Eliminar una mascota dado su id

## Requisitos Previos

Requisitos básicos para ejecutar los tests de este proyecto:

- Maven
- Java JDK 17 o superior
- Conexión a Internet (para acceder a la API de PetStore)

## Pasos para ejecutar los tests

1. Clonar el repositorio:

> abrir git bash

> git clone https://github.com/navialopez92/karate-petstore

> cd karate-petstore

> mvn clean verify

# Nota:

Presenté la situación siguiente:

Al parecer el API está implementado para que aleatoriamente cambie los datos. He hecho test de todos los tipos, unas veces me fallaban a la hora de verificar el nombre de la mascota actualizada, otras veces cuando la borraba, y otras cuando le hacía el segundo request. Probé con otros dos nombres como "Manolo" y "Pepe" y si me funcionó, al parecer el API tiene algo extraño dentro ya que me dí cuenta haciendo request a la mascota con id = 1 que unas veces devolvía name "doggie" y otras veces not found.
