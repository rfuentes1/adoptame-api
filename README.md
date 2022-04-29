![adoptame_logo](https://user-images.githubusercontent.com/74479463/166060707-dafc4c0c-589b-4d0c-9bce-bd593c3fc590.png)  
Sitio web para la adopción de mascotas.  
### Elaborado por: Rocío Fuentes  

---

### Descripción  
La ciudad de Mérida, Yucatán padece de sobrepoblación de perros y gatos callejeros, el número de animales se ha incementado a tal punto que los albergues se ven rebasados. Factores como el abandono de mascotas en las calles, la escasa cultura de esterilización, la venta indiscriminada o el extravío contribuyen al incremento de perros y gatos en los refugios que los rescatan. Aunque hay varios refugios que cuentan con espacios donde promocionan a sus mascotas, muchas veces la información se encuentra desactualizada o se pierde entre avisos, comentarios y otras publicaciones, es decir, no hay un sitio centralizado que muestre información completa de las mascotas.
Debido a esta falta de formalidad es muy común que suceda que en las publicaciones de mascotas que hacen los albergues no se responda a tiempo a dudas ni se proporcionen la información que requieren los interesados, y como resultado, la gente se frustra, se deja de interesar y termina por abandonar la idea de adoptar.


### Configuración de ambiente
#### Requisitos:

- Java 11
- Maven 3
- MariaDB 10.7

#### Base de datos
Aquí puedes ver el [diagrama relacional.](https://user-images.githubusercontent.com/74479463/166059074-ada44bf4-26cb-4924-aca2-a571bef49ebd.png)  

El script para crear la base de datos se encuentra en [src/main/resources/bd/schema.sql](https://github.com/rfuentes1/adoptame-api/blob/master/src/main/resources/bd/schema.sql)  
La carga inicial con datos de ejemplo se encuentra en [src/main/resources/bd/initial_load.sql](https://github.com/rfuentes1/adoptame-api/blob/master/src/main/resources/bd/initial_load.sql)  
Para ajustar los datos de conexión en [src/main/resources/application.properties](https://github.com/rfuentes1/adoptame-api/blob/master/src/main/resources/application.properties)  

### Como correr la aplicación
1. Hacer build con maven  
`$ mvn package`
2. Ejecutar el jar generado  
`$ java -jar target/adoptame-api-0.0.1-SNAPSHOT.jar`

#### Probar API en vivo  
La aplicación se desplegó en AWS EC2 y aquí puedes encontrar la documentación de la API con Swagger:  
http://ec2-34-203-227-108.compute-1.amazonaws.com:8080/swagger-ui/index.html

