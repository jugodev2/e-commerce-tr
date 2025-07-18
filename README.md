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
- `GET /api/pedidos` → Listar todos los pedidos
- `GET /api/pedidos/{id}` → Obtener pedido por ID

### 🟡 POST
- `POST /api/pedidos` → Crear nuevo pedido

### 🔵 PUT
- `PUT /api/pedidos/{id}` → Actualizar pedido existente

### 🔴 DELETE
- `DELETE /api/pedidos/{id}` → Eliminar pedido por ID
```bash
[https://github.com/jugodev2/e-commerce-tr.git]

