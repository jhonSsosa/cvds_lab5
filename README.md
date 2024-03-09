# LABORATORIO 5 - INTRODUCCIÓN A SPRING MVC

## INTRODUCCIÓN A PROYECTOS WEB

### PARTE I - JUGANDO A SER UN CLIENTE HTTP

Para esta parte del laboratorio, usaremos las siguientes aplicaciones como cliente HTTP:
- Postman
- Telnet

Abre la aplicación Postman y utilizaremos sus funcionalidades para realizar solicitudes a un servidor HTTP. Al abrir Postman, identifica qué controles corresponden a los elementos de entrada y salida de un servicio HTTP.

![Postman Controls](https://github.com/PDSW-ECI/labs/assets/4140058/49acba5d-2f26-4515-96e9-af7aa50f89d4)

Realiza un request GET a la URL https://www.escuelaing.edu.co/es/ y verifica el cuerpo de respuesta en las opciones Pretty, Raw y Preview.

Luego, realiza otro request GET al recurso https://dummyjson.com/todos y nuevamente verifica el cuerpo de respuesta en varias opciones.

Responde las siguientes preguntas:
- **¿Qué pasa si no envío el método correcto?**
  Si no se envía el método correcto, el servidor puede responder con un código de estado HTTP 405 (Método no permitido), indicando que el método de solicitud no es compatible con el recurso.

- **¿Qué pasa si intento leer el cuerpo de respuesta HTML como JSON?**
  Si se intenta leer el cuerpo de respuesta HTML como JSON, es probable que ocurra un error de parseo ya que el contenido HTML no está en formato JSON. El resultado sería un error de parseo y el cuerpo de respuesta no sería legible como JSON.

- **¿Por qué el preview de HTML no se ve igual que cuando accedo a la URL en un navegador web?**
  El preview de HTML proporcionado por herramientas como Postman puede no representar completamente la experiencia de visualización en un navegador web real. Esto puede deberse a diferencias en el procesamiento y renderizado de HTML entre la vista previa en Postman y un navegador web real.

- **¿Qué ocurre si envío un cuerpo en una solicitud GET?**
  Según la especificación HTTP, no se espera que una solicitud GET tenga un cuerpo. Si se envía un cuerpo en una solicitud GET, es posible que algunos servidores lo ignoren, mientras que otros pueden responder con un código de estado 400 (Solicitud incorrecta) indicando que la solicitud es inválida.

Además, como parte del laboratorio en casa (ya que en los equipos del laboratorio está bloqueado), realiza los mismos dos requests anteriores utilizando la herramienta Telnet sobre el puerto 80.

Ten en cuenta que Telnet solo soporta HTTP y no HTTPS. Entonces, ¿qué significa la respuesta 301 cuando usas Telnet en el puerto 80? Para obtener una respuesta exitosa, podrías hacer solicitudes al servicio http://example.com/.

### PARTE II. - CLIENT SIDE RENDERING CON REACT
Para iniciar verifica que tengas alguna de estas herramientas:
- NPM o YARN

Verificando en terminal sería `$ npm --version`

La siguiente misión es ejecutar una aplicación react localmente:
- Abre la aplicación https://codesandbox.io/s/react-js-simple-calculator-pefmr, loguéate con GitHub y juega cambiando los parámetros como colores y duplicando las líneas del archivo App.js con tags como `<ResultComponent ...>` en la función render.

- ¿Qué hace cada uno de los archivos en la aplicación?
```

markdown
Copy code
### PARTE II. - CLIENT SIDE RENDERING CON REACT

Para iniciar, verifica que tengas alguna de estas herramientas:
- NPM o YARN

Verificando en terminal sería `$ npm --version`

La siguiente misión es ejecutar una aplicación React localmente:

- Abre la aplicación https://codesandbox.io/s/react-js-simple-calculator-pefmr, loguéate con GitHub y juega cambiando los parámetros como colores y duplicando las líneas del archivo App.js con tags como `<ResultComponent ...>` en la función render.

- ¿Qué hace cada uno de los archivos en la aplicación?

.
├── package.json: Se utiliza para definir las dependencias del proyecto React y configurar scripts de inicio y compilación.
├── public
│ └── index.html: Este archivo es la página HTML principal de la aplicación React. Es el punto de entrada de la aplicación y contiene el nodo raíz donde se montará la aplicación React.
└── src
├── App.js: Define la estructura de la aplicación y contiene la lógica principal. En este caso, es una calculadora simple que renderiza dos componentes secundarios: KeyPadComponent y ResultComponent.
├── components
│ ├── KeyPadComponent.js: Es responsable de renderizar los botones de la calculadora y manejar los eventos de clic en esos botones.
│ └── ResultComponent.js: Es responsable de renderizar el resultado de las operaciones de la calculadora y mostrarlo al usuario.
├── index.js: Este archivo es el punto de entrada de la aplicación React. Se encarga de renderizar el componente principal (App.js) en el nodo raíz del DOM, generalmente un elemento con el id "root".
└── styles.css: Este archivo contiene estilos CSS para la aplicación React. Define estilos para los componentes y elementos de la interfaz de usuario, como colores, tamaños de fuente, márgenes, etc.
```

- Después de haber visto los cambios, vuelve a abrir la URL original https://codesandbox.io/s/react-js-simple-calculator-pefmr y sigue los siguientes pasos:
1) Descargar código en un Zip
2) Descomprimir el Zip en la carpeta de proyectos de software, (en ciertos PC solo funciona 7-Zip)
3) Abrir una terminal de Git Bash en la carpeta descomprimida
5) Instalar las dependencias con `npm install`
   ![image](https://github.com/jhonSsosa/cvds_lab5/assets/112003191/5823af4a-afe9-40a3-9569-d44bd141832f)
7) Iniciar la aplicación con `npm start`, en algunos computadores con versiones antiguas de nodejs hay que agregar `NODE_OPTIONS=--openssl-legacy-provider npm run start`
   ![image](https://github.com/jhonSsosa/cvds_lab5/assets/112003191/b4f5f332-6813-4415-9693-40208c95dac3)
9) Si te sale el Firewall dale click en cancelar
10) Abrir la ruta http://localhost:3000/ en un navegador web como Firefox o Google Chrome

![image](https://github.com/jhonSsosa/cvds_lab5/assets/112003191/fbf45d2f-f0c7-47f7-9ac7-314b2541a5f8)

Has un request GET a la URL http://localhost:3000/ usando Postman, y revisa si el body de la respuesta es igual a alguno de los archivos del proyecto. Significa eso que es un recurso web dinámico o estático?
Los dos fragmentos de código HTML que se generaron son similares mas no iguales, pero tienen algunas diferencias importantes que pueden afectar cómo se sirve la aplicación web, de tal manera que:
- El primer fragmento de código sugiere que la aplicación se sirve de forma estática.
- El segundo fragmento de código también sugiere que la aplicación se sirve de forma estática, pero con procesamiento dinámico para servir los archivos JavaScript generados.
Por lo tanto, en ambos casos, la aplicación podría considerarse estática, pero el segundo fragmento podría involucrar un servidor que realiza cierto procesamiento dinámico antes de servir los archivos estáticos.

### PARTE III. - HACIENDO UNA APLICACIÓN WEB DINÁMICA USANDO EL PATRÓN MVC
En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de spring MVC.

Para esto usaremos la documentación oficial de Spring con que que aprenderemos las funciones básicas de este framework https://spring.io/guides/gs/serving-web-content/

Después de terminar el aprendizaje analice:
- ¿Por qué MVC obtiene ese nombre? (puede apoyarse de https://www.javatpoint.com/spring-mvc-tutorial) 
- ¿Cuáles son las ventajas de usar MVC?
- ¿Qué diferencia tiene la estructura de directorios de este proyecto comparado con las de proyectos pasados (con solo maven y java EE)?
- ¿Qué anotaciones usaste y cuál es la diferencia entre ellas?
- Ahora, haz el request GET http://localhost:8080/greeting usando Postman, y revisa si el body de la respuesta es igual a alguno de los archivos del proyecto. Significa eso que es un recurso web dinámico o estático? (FALTA)

### PARTE IV. - APLICACIÓN MVC PARA CONSUMO DE SERVICIO RESTful
Usando la arquitectura MVC del punto anterior (el proyecto anterior), realice una aplicación simple qué permita navegar gráficamente sobre esta API
https://jsonplaceholder.typicode.com/todos/1, puede guiarse de tutoriales como https://medium.com/@nutanbhogendrasharma/consume-rest-api-in-spring-boot-web-application-354c404850f0

Luego de terminada esta parte responda:
- ¿Qué es RESTful?
- Si utilizo un framework como [Boostrap CSS](https://getbootstrap.com/) para qué el apartado gráfico se vea más profesional, ¿en qué capa se haría su uso?

### PARTE V. - APLICACIÓN MVC JUEGO
¡Llego la hora del reto! Teniendo las bases del uso del framework, cree una nueva ruta, por ejemplo `/guess`, y agrege formulario básico con un campo llamado "número" (guía de como crear formularios HTML https://www.w3schools.com/html/)

Y vamos a implementar la lógica de nuestro juego:
1. Se trata de un juego en línea para adivinar un número, en el que el ganador, si acierta en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premio
se reduce en $10.000, como en los juegos de apuesta, es natural qué quede en saldos negativos.
2. El número a adivinar debe ser generado en cada intento y comparado con el número qué el usuario está insertando, es un número de 1 a 10.
3. Debe existir un botón de reset, qué permita al jugador iniciar de nuevo.
4. La capa de controlador debe procer el número del usuario mediante método `POST`.

Analice las siguientes situaciones:
- ¿Qué pasa si abro el sitio de juegos en dos navegadores difententes?
- Si quisiera qué a cada jugador le aparecieran independientemente sus respectivos saldos. ¿Qué habría que hacer?

## ENTREGA
- En un README.md colocar lo siguiente:
- Una sección llamada “INTEGRANTES” y allícolocar el listado de los integrantes del taller (máximo 2).
- Una sección llamada “RESPUESTAS” colocar las respuestas a las preguntas.
- Configurar el archivo .gitignore para excluir del repositorio los archivos no relevantes.
- En una carpeta en la raiz del repositorio llamada diagrams y allí realizar un diagrama de clases del proyecto.
