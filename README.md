# DocumentsDB

## Indice

1. **[Introduccion al proyecto](#introduccion-al-proyecto)**
2. **[Documentacion](#documentacion)**
   1. **[Diagramas](#diagramas)**
      1. Diagramas de clase
2. **[Requisitos](#requisitos)**
3. **[Instalacion y configuracion del entorno](#instalacion-y-configuracion-del-entorno)**
4. **[Usando la API REST](#usando-la-api-rest)**
5. **[Scripts de Base de Datos](#scripts-de-bbdd)**

----

## Introduccion al proyecto

Este proyecto esta formado por dos repositorios, este donde se encuentra el backend y este otro donde se encuentra el frontend.

El objetivo de la aplicacion es una plataforma donde alojar de forma organizada los distintos apuntes de los distintos cursos que vas realizando a lo largo del tiempo.

Intenta resolver un problema propio. Cada vez que acabo un curso, trato de guardar los PDF o los distintos documentos que he visto durante el curso para tenerlos accesible en cualquier momento, el problema es que no tengo una plataforma donde los tenga de forma organizada, sino que los tengo repartidos o tengo que descargarlos de servicios como Drive, Mega, etc... organizados por carpetas.
Muchas veces, es un poco engorroso encontrar un archivo especifico ya que debo navegar entre carpetas repartidas en distintos servicios.

Con esta aplicacion trato de solventar mi propia necesidad organizando toda esa informacion en un esquema de este estilo, ademas de gestionar distintos eventos sobre un curso que esté "activo":
```
User __ Curso __ Asignatura __ Evento
                    |_  Tema __ Apunte
```
---
## Documentacion
 * ### Diagramas

   * #### **Diagrama de clase**

---
## Requisitos

**Desarrollo**
- Java 15
- Spring Tool Suite
- MySQL 8.0 (Preferentemente en Docker)
---
## Instalacion y configuracion del entorno

Voy a hacer el proceso de instalacion solo para distribuciones Linux.

Para instalar todo lo necesario en **Arch Linux** se puede acudir a este script(Se necesita `pacman` y `yay`): https://github.com/rudahee/InstallMyEnvironment

**EN CONSTRUCCION**

---
 ## Usando la API REST

Todas las entidades tienen desarrollado un CRUD que corresponde a las siguientes peticiones:

### GET
- **localhost:8080/[Entidad]/all**
	- Devuelve todos las entidades.
- **localhost:8081/[Entidad]/[Id]**
    - Devuelve una entidad por id

### POST
- **localhost:8080/[Entidad]**
    - Inserta una carta en formato JSON en el body.

### PUT
- **localhost:8081/[Entidad]/[Id]**
    - Recibe un body en formato JSON y cambia una carta existente por id

### DELETE
- **localhost:8081/[Entidad]/[Id]**
    - Borra una carta existente por id

---
## Scripts de BBDD

**EN CONSTRUCCION**
