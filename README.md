# prueba-zabud-alcancia
Prueba de seleccion Zabud - java- springboot- sprignSecurity - Terraform - githubActions

![Imagen del flujo de oauth2](https://uploads.toptal.io/blog/image/129096/toptal-blog-image-1549493352154-d8593c1d09444018667fd89566010f57.png)

### Ejecución
Podemos Ejecutar el proyecto de tres formar:
- Docker: Ya está preparado un
  docker-compose para ejecutarlo con el comando
  **docker-compose -d up --build**.
- Gradle: usando el comando **gradle run**.
- Ejecutable: Esta preprado un ejecutable para descargar.

### Pruebas

- #### Dependencias
  Para poder probar el funcionamiento correcto de oauth2
  debemos tener postman o algún cliente http disponible.

- #### Guia de Pruebas
    1.  Autenticación:
        Probaremos ingresando a la siguiente url
        *<http://localhost:8080/oauth/token?grant_type=client_credentials&client_id=client_read&client_secret=1234567890>*
        y la acción **POST** obtendremos el token para acceder a los recursos
        que hemos definido para ese scope, la salida seria
        muy similar a la siguiente:
        ```json
        {
        "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic2VydmljZSJdLCJzY29wZSI6WyJyZWFkIl0sImV4cCI6MTYxMTkyNzY2NCwiYXV0aG9yaXRpZXMiOlsiQ0xJRU5UX1JFQUQiXSwianRpIjoiYjEzOWE1MTctNjM2Ni00YzViLWI4ZDAtZTJiYmIwMDQ1MTVkIiwiY2xpZW50X2lkIjoiY2xpZW50X3JlYWQifQ.KiqoFiuIRh8Iz6EjuP64MgKp7H9If7bR-ZALnp7g15M",
        "token_type": "bearer",
        "expires_in": 43199,
        "scope": "read",
        "jti": "b139a517-6366-4c5b-b8d0-e2bbb004515d"
        }
        
        ```
    2. Autorización:
        - 200: Probaremos el acceso a un recurso con permisos,
          ingresando a la siguiente
          url *<localhost:8080/personas>* y la acción **GET**,
          en este caso la salida deberia ser:
            ```json
            Hola Persona!!
            ```
          Correcto, esta funcionando bien.
        - 403: Probaremos el acceso a un recurso sin permisos,
          ingresando a la siguiente
          url *<localhost:8080/personas/admin>* y la acción **GET**,
          en este caso la salida deberia ser:
            ```json
            {
              "error": "access_denied",
              "error_description": "Access is denied"
             }
            ```
          Correcto esta funcionando bien.

Como comprobamos tenemos acceso a ciertos
recursos, por medio de la especificacion oauth2
implementada en SpringBoot.
>> "Todo se puede aprender con la suficiente disciplina y dedicación"
