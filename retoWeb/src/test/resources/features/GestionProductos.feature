# language: es
@Web
Característica: Gestión de Productos

  Antecedentes:
    Dado que me encuentro en la pantalla inicial de Store
    Cuando selecciono la categoría "Phones"
    Y selecciono el producto "Samsung galaxy s6"

  Regla: El sistema debe permitir el ingreso a los formularios

    @CP05
    Escenario: Seleccion de producto Samsung Galaxy S6
      Entonces podre ver el detalle del producto con la etiqueta "Product description"

    @CP06
    Escenario: Agregar producto al carrito
      Cuando agrego el producto al carrito
      Entonces podre ver el mensaje de la alerta "Product added"

    @CP07
    Escenario: Verificar producto en carrito
      Cuando agrego el producto al carrito
      Y podre ver el mensaje de la alerta "Product added"
      Y accedo a la seccion Cart desde el menu
      Entonces podre ver el producto "Samsung galaxy s6" agregado en mi carrito de compras

    @CP08
    Escenario: Eliminar producto del carrito
      Cuando agrego el producto al carrito
      Y podre ver el mensaje de la alerta "Product added"
      Y accedo a la seccion Cart desde el menu
      Y elimino el producto "Samsung galaxy s6" del carrito
      Entonces el producto "Samsung galaxy s6" desaparecerá del listado
