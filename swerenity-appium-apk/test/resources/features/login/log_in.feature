Feature: Validaciones a la APK (SwagLabs)

  Scenario: (CA01) Validar que se muestre el título 'SwagLabs' y el botón 'LOGIN'
    Given abrimos la APK en el emulador
    When se muestra la pantalla inicial
    Then debe verse el título 'Swag Labs' y el botón 'LOGIN'

  Scenario Outline: (CA02) Validar inicio de sesion exitosamente
    Given estamos en la pantalla inicial
    When ingresamos usuario "<usuario>" y contraseña "<contrasena>"
    And pulsamos “LOGIN”
    Then debe mostrarse la lista de productos

    Examples:
      | usuario       | contrasena      |
      | standar_user  | secret_sauce    |


  Scenario: (CA03) Validar que se adicione un producto al carrito
    Given vemos la lista de productos
    When seleccionamos el producto <producto>
    And pulsamos “ADD TO CART”
    Then el carrito debe contener <producto>

  Scenario: (CA04) Validar que se muestre un producto junto a su precio en el carrito
    Given <producto> está en el carrito
    When abrimos el carrito
    Then debe listarse <producto> junto a su precio

  Scenario: (CA05) Validar que se elimine un producto del carrito
    Given <producto> está en el carrito
    When pulsamos “REMOVE” junto al <producto>
    Then el carrito debe quedar vacío

  Scenario: (CA06) Validar que se muestre la seccion "Swag Labs"
    Given estamos en cualquier pantalla de la app
    When abrimos el menú lateral y pulsamos “About”
    Then debe mostrarse la sección con texto “Swag Labs”

  Scenario: (CA07) Validar cierre de sesión exitosamente
    Given estamos logueados
    When pulsamos el botón “LOGOUT”
    Then regresa a la pantalla de login
