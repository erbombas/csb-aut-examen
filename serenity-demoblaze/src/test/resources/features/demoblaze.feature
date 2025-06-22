Feature: Validaciones a aplicación web (DemoBlaze)

  Scenario Outline: (CA01) Registrar nuevo usuario
    Given que ingresamos a la URL de DemoBlaze
    When hacemos clic en "Sign up"
    And registramos un usuario y contraseña random
    And pulsamos "Sign up"
    Then debe mostrarse una alerta con el mensaje "Sign up successful."

  Scenario Outline: (CA02) Login con cuenta existente
    Given que ingresamos a la URL de DemoBlaze
    When hacemos clic en "Log in"
    And ingresamos usuario "<usuario>" y contraseña "<contrasena>"
    And pulsamos "Log in"
    Then debe aparecer nuestro nombre de usuario en la esquina superior derecha: "<usuario>"

    Examples:
      | usuario  | contrasena  |
      | usuario1 | usuario1    |

  Scenario: (CA03) Navegar a categoría de Phones
    Given que ya estamos logueados
    When hacemos clic en la categoría "Phones"
    Then se debe mostrar el listado de "Phones"

  Scenario: (CA04) Ver detalle de un Phone
    Given que vemos el listado de "Phones"
    When hacemos clic en "Samsung galaxy s6"
    Then debe mostrarse el label "Product description"

  Scenario: (CA05) Añadir producto al carrito
    Given que estamos en la página de detalle de "Samsung galaxy s6"
    When hacemos clic en "Add to cart"
    Then aparece un modal con el mensaje "Product added"

  Scenario: (CA06) Ver carrito
    Given que "Samsung galaxy s6" está en el carrito
    When hacemos clic en "Cart"
    Then el carrito muestra "Samsung galaxy s6"

  Scenario: (CA07) Eliminar producto del carrito
    Given que estamos en nuestro carrito de compras
    When pulsamos "Delete"
    Then el carrito queda vacío

  Scenario: (CA08) Logout desde carrito
    Given que estamos en el carrito
    When pulsamos "Log out"
    Then nos redirige a la página principal de DemoBlaze

  Scenario: (CA09) Volver al home
    Given que estamos en cualquier página de DemoBlaze
    When hacemos clic en el logo del sitio
    Then volvemos a la página principal

  