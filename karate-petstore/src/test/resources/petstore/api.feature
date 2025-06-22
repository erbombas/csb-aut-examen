Feature: Validaciones a API (Petstore Swagger)

  Background:
    * url 'https://petstore.swagger.io/v2'
    * def newName = "PugCarlino_Luna"
    
  Scenario Outline: (CA01) Adicionar nueva mascota con fichero JSON
    * def newPet =
    """
    {
      "id": <id>,
      "name": "<name>",
      "photoUrls": <photoUrls>,
      "status": "<status>"
    }
    """
    Given path 'pet'
    And request newPet
    When method POST
    Then status 200
    And match response.id == <id>
    And match response.name == "<name>"

    Examples:
    | read('classpath:arrayPets.json') |

  
  
  Scenario Outline: (CA02) Verificar que la mascota se adicionó satisfactoriamente
    Given path 'pet/', <id>
    When method GET
    Then status 200
    And match response.name == "<name>"

    Examples:
    | read('classpath:arrayPets.json') |  
  
  
  Scenario Outline: (CA03) Actualizar nombre de una mascota existente
    * def updatedPet =
    """
    {
      "id": <id>,
      "name": "",
      "photoUrls": <photoUrls>,
      "status": "<status>"
    }
    """
    * updatedPet.name = newName
    Given path 'pet'
    And request updatedPet
    When method PUT
    Then status 200
    And match response.name == newName

    Examples:
    | read('classpath:arrayPets.json') |

  
  
  Scenario Outline: (CA04) Verificar el nombre de la mascota actualizada
    Given path 'pet/', <id>
    When method GET
    Then status 200
    And match response.name == "<name>"

    Examples:
    | read('classpath:arrayPets.json') |

  
  Scenario Outline: (CA05) Eliminar una mascota dado su id
    Given path 'pet/', <id>
    When method DELETE
    Then status 200
    
    Given path 'pet'
    When method GET
    Then status 404

    Examples:
    | read('classpath:arrayPets.json') |

  


