# Lab-05

## INTRODUCCIÓN A PROYECTOS WEB

### PARTE I. - JUGANDO A SER UN CLIENTE HTTP

**1.** Abra una terminal Linux o consola de comandos Windows.

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
Sale el error
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

- ¿Qué otros tipos de peticiones existen?


**6.** En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos:

curl www.httpbin.org
Utilice ahora el parámetro -v y con el parámetro -i:

curl -v www.httpbin.org
curl -i www.httpbin.org
¿Cuáles son las diferencias con los diferentes parámetros?
