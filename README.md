# 📦 E-COMMERCE-TR

Bienvenido a E-COMMERCE-TR, un pequeño pero eficaz sistema de pedidos.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.7
- Hibernate
- Oracle
- Maven

## 📄 Instrucciones para levantar
- Descarga el repositorio
- Abrelo con SpringTools o tu IDE de preferencia.
- Configura tus variables de entorno por cada Microservicio para que te permita acceder a la base de datos y consumir los servicios.
- Ejecuta los Scripts proporcionados para crear la base de datos.
- Levanta los microservicios en el siguiente orden:
  - Primero levanta el servidor Eureka-Server
  - Despues levanta los microservicios en el siguiente orden (recomendable)
    - Productos
    - Clientes
    - Pedidos
  - Finalmente levanta el Gateway.
    
## 📬 Endpoints REST

### 🟢 GET

| Recurso   | Endpoint                        | Descripción                      |
|-----------|----------------------------------|----------------------------------|
| Pedidos   | `GET /api/pedidos`              | Listar todos los pedidos         |
| Pedidos   | `GET /api/pedidos/{id}`         | Obtener pedido por ID            |
| Productos | `GET /api/productos`            | Listar todos los productos       |
| Productos | `GET /api/productos/{id}`       | Obtener producto por ID          |
| Clientes  | `GET /api/clientes`             | Listar todos los clientes        |
| Clientes  | `GET /api/clientes/{id}`        | Obtener cliente por ID           |

---

### 🟡 POST

| Recurso   | Endpoint                        | Descripción                      |
|-----------|----------------------------------|----------------------------------|
| Pedidos   | `POST /api/pedidos`             | Crear nuevo pedido               |
| Productos | `POST /api/productos`           | Crear nuevo producto             |
| Clientes  | `POST /api/clientes`            | Registrar nuevo cliente          |

---

### 🔵 PUT

| Recurso   | Endpoint                        | Descripción                      |
|-----------|----------------------------------|----------------------------------|
| Pedidos   | `PUT /api/pedidos/{id}`         | Actualizar pedido existente      |
| Productos | `PUT /api/productos/{id}`       | Actualizar producto existente    |
| Clientes  | `PUT /api/clientes/{id}`        | Actualizar datos del cliente     |

---

### 🔴 DELETE

| Recurso   | Endpoint                        | Descripción                      |
|-----------|----------------------------------|----------------------------------|
| Pedidos   | `DELETE /api/pedidos/{id}`      | Eliminar pedido por ID           |
| Productos | `DELETE /api/productos/{id}`    | Eliminar producto por ID         |
| Clientes  | `DELETE /api/clientes/{id}`     | Eliminar cliente por ID          |
```bash
[https://github.com/jugodev2/e-commerce-tr.git]

