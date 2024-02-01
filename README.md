# TCSProject | Proyecto de Automatización de Pruebas

Este es un proyecto de automatización de pruebas realizado en Java, utilizando Gradle, TestNG y Selenium.

## Escenarios de Prueba

Los escenarios de prueba incluyen:

1. Ingreso a una tienda virtual, aplicación de filtro por menor precio, adición de un producto al carrito y comprobación de la adición correcta al carrito de compras.
2. Ingreso de dos palabras en dos campos de autocompletado.
3. Manejo de alertas, esperar que se muestre, comprobar botón de aceptar y cancelar y, por último, escribir un texto en una alerta y comprobar resultado.

## Tecnologías Utilizadas

Las tecnologías utilizadas en este proyecto incluyen:

- Lenguaje: Java 16 Oracle OpenJDK versión 16.0.2
- Marco de pruebas: TestNG versión 7.7.1
- Manejo de dependencias: Gradle versión 8.2
- Herramienta de automatización: Selenium versión 4.13.0
- Patrón de diseño: POM (Page Object Model)
- IDE: Aqua 233.13135.75
- Archivo de configuración: config.properties
- Reportes: Generados por TestNG

## Páginas

Las páginas incluyen:

- BasePage.java: Se realizó para ejecutar esperas explícitas y obtener foco del elemento, es decir, funciones básicas de interacción con los elementos.
- DemoQAAlertsPage.java: Contiene todos los elementos para ejecutar pruebas en la página de alertas.
- DemoQAWidgetsPage.java: Contiene todos los elementos para ejecutar pruebas en la página de widgets.
- SauceDemoLoginPage.java: Contiene todos los elementos para ejecutar pruebas en la página de compras.

## Ejecución de Pruebas

Las pruebas se realizan desde la clase principal "MainPageTest.java".

## Reportes

Se utilizó la librería de TestNG incluida para realizar reportes. La ruta donde se guarda automáticamente es "..\build\reports\tests\test\index.html".

## Documentación

Se creó la carpeta "docs", la cual contiene los casos de prueba aplicados en la automatización.
