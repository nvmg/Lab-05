# Lab-05

## INTRODUCCIÓN A PROYECTOS WEB

### PARTE I. - JUGANDO A SER UN CLIENTE HTTP

**2.** Realice una conexión síncrona TCP/IP a través de Telnet/Netcat al siguiente servidor:
* Host: www.escuelaing.edu.co
* Puerto: 80
Teniendo en cuenta los parámetros del comando telnet:
``` 
telnet HOST PORT
telnet www.escuelaing.edu.co 80
```
![1](https://user-images.githubusercontent.com/79550161/156277528-e46dca35-f64c-481f-b2b9-5b1f13327915.JPG)


**3.** Antes de que el servidor cierre la conexión por falta de comunicación:
* Solicite al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP.
```
GET /sssss/abc.html HTTP/1.0
Host: www.escuelaing.edu.co
```
![2](https://user-images.githubusercontent.com/79550161/156670642-d04d1afc-d29d-4a6f-bfdf-2f54b493e0e3.JPG)

* Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.

Se encontró el error 301, el cual indica que el recurso solicitado se ha movido permanentemente. En la respuesta se proporciona la nueva URL.

* ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?
  - Los errores (300-309) son errores de redirección, los cuales indican que los datos han sido transferidos a otra dirección. (Se debería intentar con una nueva dirección).
  - Los errores (400-409) son errores que se producen por parte del cliente, son errores con una sintaxis incorrecta o datos que no se encuentran en esa dirección.
  - Los errores (500-509) son errores que se producen por parte del servidor, como que se ha excedido el tiempo de espera o algún error interno.
![error](https://user-images.githubusercontent.com/79550161/156484351-ab5d397f-d2ab-4a03-94c2-dd0b0a59bd87.png)


**4.** Realice una nueva conexión con telnet, esta vez a:
* Host: www.httpbin.org
* Puerto: 80
```
telnet www.httpbin.org 80
```
![3](https://user-images.githubusercontent.com/79550161/156677313-62d14d10-d776-4530-98b2-2621853ce736.JPG)

* Versión HTTP: 1.1
Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?
```
GET /html HTTP/1.1
Host: www.httpbin.org
```
![4](https://user-images.githubusercontent.com/79550161/156677340-60d99423-7d16-4f74-ae2a-b4691f338a2e.JPG)
![image](https://user-images.githubusercontent.com/79550161/156684513-1dc212b2-5f10-43e3-b0d0-74330efb5556.png)
Se obtuvo un mensaje de éxito (200) y un texto en formato de html.

**5.** Seleccione el contenido HTML de la respuesta y copielo al cortapapeles CTRL-SHIFT-C. 
Ejecute el comando wc (word count) para contar palabras con la opción -c para contar el número de caracteres:

![6](https://user-images.githubusercontent.com/79550161/156864979-f62b6423-c8af-4663-99b2-74f2cb9353d3.JPG)

- ¿Cuál es la diferencia entre los verbos GET y POST? 

Ambos protocolos envían al servidor peticiones y reciben una respuesta a esta solicitud.
La diferencia se encuentra en la forma en la que envían los datos. Mientras que GET envía los datos usando una URL y permite obtener información del servidor, es decir, trae los datos que se encuentran en el servidor, ya sea en una base de datos o un archivo al cliente; POST los envía de forma oculta, es decir, envía información desde el cliente para que sea procesada y actualice o agregue información en el servidor.

- ¿Qué otros tipos de peticiones existen?

* HEAD: Es similar a la petición GET, pero cuando pide una respuesta solo se retorna el encabezado, permitiendo recuperar los metadatos de la respuesta sin tener que transportar todo el contenido. 
 * PUT: Es usada para almacenar el cuerpo en una ubicación dada por la URL, está dirigido a la actualización de contenidos, pero también se puede usar en la creación de estos.
 * DELATE: Es usado para solicitarle al servidor la eliminación de un recurso en la ubicación dada por la URL.
 * CONNECT: Se usa para establecer una conexión de red con un servidor web usando HTTP, también es usada para saber si se tiene acceso a un host.
 * OPTIONS: Retorna los métodos HTTP que el servidor soporta para una URL en específico.
 * TRACE: Se usa para solicitarle al servidor que introduzca en la respuesta todos los datos que reciba en el mensaje de petición.

**6.** Comando curl:
```
curl www.httpbin.org
```
![7](https://user-images.githubusercontent.com/79550161/156866050-9b6dadf1-9c2f-438e-94ec-1c8d01593932.JPG)
```
curl -v www.httpbin.org
```
![8](https://user-images.githubusercontent.com/79550161/156866146-9c506c23-f66d-4a96-b450-8af9e6bb79c2.JPG)
```
curl -i www.httpbin.org
```
![9](https://user-images.githubusercontent.com/79550161/156866147-7d9be337-2daa-4af2-9020-a9cf3e5cd52c.JPG)

¿Cuáles son las diferencias con los diferentes parámetros?

El comando curl -v nos ayuda a obtener el encabezado de la solicitud y el número de la respuesta obtenida, permite visualizar la petición GET y el Host realizado para obtener el contenido. El comando curl -i incluye el encabezado HTTP en la salida, contiene cosas como el nombre del servidor, la fecha del documento, la versión HTTP, cookies, entre otros.

### PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.

I. Cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp:
```
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp
```
**1.** Revise la clase SampleServlet, e identifique qué hace:

La clase SampleServlet permite recibir una petición de usuario y dar una respuesta a este.

**5.** Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’:

![10](https://user-images.githubusercontent.com/79550161/156869835-a572a66b-4d3f-4640-bc12-49c8ebe900d0.JPG)

**6.** Ingrese la misma URL, pero ahora agregando un parámetro GET:

http://localhost:8080/helloServlet?name=%20Nicole%20y%20Carolina

![11](https://user-images.githubusercontent.com/79550161/156871813-593c7a32-d879-4b09-acc9-1c93cc512fda.JPG)

**8.** Intente cambiando diferentes números al final del path de la url.

![12](https://user-images.githubusercontent.com/79550161/156872468-12026a97-e73f-4ebc-91c3-24d8bb12f298.JPG)

**15.** Intente hacer diferentes consultas desde un navegador Web para probar las diferentes funcionalidades:
* Sin especificar algún parámetro:

![13](https://user-images.githubusercontent.com/79550161/156873798-357c1db0-ded4-4430-9f31-55db23fc5ff4.JPG)

* Con un carácter inválido:

![14](https://user-images.githubusercontent.com/79550161/156873801-fcdfd7fa-aced-4653-914d-bbfb4c6b0a61.JPG)

* Con una consulta no existente:
*
![15](https://user-images.githubusercontent.com/79550161/156873804-17a2e24f-3c90-4519-9961-b0f5cf92a78e.JPG)

* Consulta correcta:

![16](https://user-images.githubusercontent.com/79550161/156873805-5d40c756-91bd-45c6-9afe-a1c228da20e8.JPG)

### PARTE III.

**19.** Revise este ejemplo de validación de formularios con javascript y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde el browser se valide que el valor ingresado es un valor numérico:

![17](https://user-images.githubusercontent.com/79550161/156874612-3b88315c-62aa-4e05-9ecf-23661f705aa5.JPG)

**20.** Use el método GET . Qué diferencia observa?

No se muestra un cambio significativo ya que se realizo la implementación de los metodos de la misma manera, pero la manera de enviar la información es diferente.

**21.** ¿Qué se está viendo?

### PARTE IV. - FRAMEWORKS WEB MVC – JAVA SERVER FACES / PRIME FACES

**1.** Al proyecto Maven, debe agregarle las dependencias mas recientes de javax.javaee-api, com.sun.faces.jsf-api, com.sun.faces.jsf-impl, javax.servlet.jstl y Primefaces (en el archivo pom.xml).
  ok

**2.** Para que configure automáticamente el descriptor de despliegue de la aplicación (archivo web.xml), de manera que el framework JSF se active al inicio de la aplicación, en el archivo web.xml agregue la siguiente configuración:

  ok
  
**3.** Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.

  * Servlets: generan páginas web de forma dinámica a partir de los parámetros de la petición que envíe el navegador web. Y a menudo se ejecutan cuando el usuario hace clic en     un enlace, envía un formulario o realiza otro tipo de acción en un sitio web.

**4.** Ahora, va a crear un Backing-Bean de sesión, el cual, para cada usuario, mantendrá de lado del servidor las siguientes propiedades:

    El conjunto de datos ingresados por el usuario.
    Los resultados de las operaciones.
    La cantidad de números ingresados por el usuario.
    
    ok

**5.** Cree una página XHTML, de nombre calculadora.xhtml (debe quedar en la ruta src/main/webapp). Revise en la página 13 del manual de PrimeFaces, qué espacios de nombres XML requiere una página de PrimeFaces y cuál es la estructura básica de la misma.

  ok
  
**6.** Con base en lo anterior, agregue un formulario con identificador calculadora_form con el siguiente contenido básico:
  
  ok
  
**7.** 


