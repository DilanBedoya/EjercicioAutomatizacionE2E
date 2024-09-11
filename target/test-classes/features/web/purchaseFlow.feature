@TestComplete
Feature: Flujo de compra en DemoBlaze

  #Separé en dos escenarios debido a que en uno solo generaría confusiones y sería muy extenso
  @TestProductAndCar
  Scenario Outline: Agregar dos productos al carrito y visualizar Carrito
    Given El "Cliente" está en la página principal de DemoBlaze
    When selecciona la categoría "<categoria1>" para el primer producto
    And selecciona el primer producto "<producto1>"
    And agrega al carrito el primero producto
    When selecciona la categoría "<categoria2>" para el segundo producto
    And selecciona el segundo producto "<producto2>"
    And agrega al carrito el segundo producto
    Then se muestran los productos "<producto1>" y "<producto2>" en el carrito

    #Seleccionar cualquier categoria y producto
    Examples:
      | categoria1 | producto1        | categoria2 | producto2   |
      | Monitors   | Apple monitor 24 | Laptops    | MacBook air |
      #| Laptops    | 2017 Dell 15.6 Inch | Phones     | Nexus 6     |
      #| Phones     | Iphone 6 32gb | Phones     | HTC One M9 |


  @TestForm
  Scenario Outline: Completar formulario de compra y finalizar compra
    Given El "Cliente" está en la sección de carrito
    When realiza una orden
    And llena el formulario con "<Name>","<Country>","<City>","<Credit card>","<Month>" y "<Year>" correctamente
    Then visualiza el mensaje "Thank you for your purchase!"

    Examples:
      | Name  | Country | City  | Credit card | Month   | Year |
      | Dilan | Ecuador | Quito | 123456      | Febrero | 2024 |








