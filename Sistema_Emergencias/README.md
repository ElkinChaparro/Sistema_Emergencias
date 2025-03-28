# corregir el priority debido a calculñar con prioridad y distancia

# Sistema de Emergencias
DEV_SENIOR_CODE

El **Sistema de Emergencias** es una aplicación diseñada para gestionar emergencias de manera eficiente, permitiendo registrar, atender y realizar un seguimiento de los recursos utilizados. Este sistema utiliza conceptos de programación orientada a objetos y estructuras de datos como `ArrayList` y `Queue` para manejar emergencias y recursos.

---

## Estructura del Proyecto

### **1. Models**
- **Fac IntF Serv Strategy**: Implementación de patrones de diseño para la gestión de emergencias.
- **Fac IntF Felix**: Modelos relacionados con la lógica de emergencias.
- **Serv Elkin**: Servicios para la gestión de recursos y personal.

### **2. Controller**
- **Inventario_dia**: Clase encargada de gestionar los recursos, vehículos y personal. Los datos se almacenan en `ArrayList` u objetos para facilitar su manipulación.

### **3. View**
- **Main**: Punto de entrada del programa.
- **Menús**: Los menús se separarán en una clase independiente para mejorar la modularidad y la legibilidad del código.

---

## Funcionalidades Principales

1. **Gestión de Emergencias**
   - Registrar nuevas emergencias con tipo, ubicación y gravedad utilizando `ENUMS` ubicados en la carpeta `utils`.
   - Atender emergencias de manera básica, mostrando mensajes en consola.
   - Mover emergencias atendidas de una `Queue` a una lista de emergencias atendidas.

2. **Estadísticas**
   - Mostrar estadísticas del día, como emergencias atendidas y pendientes.

3. **Gestión de Recursos**
   - Imprimir la cantidad actual de recursos disponibles.
   - Sugerir suministros necesarios basados en la demanda.

4. **Validaciones**
   - Validar que no se pueda atender una emergencia si no hay recursos disponibles.
   - Notificar al usuario si el programa no se detiene correctamente.

5. **Optimización**
   - Mejorar la lógica para descontar personal y recursos correctamente al atender emergencias.
   - Corregir el cálculo de prioridad basado en distancia y gravedad.

---

## Instalación y Configuración

1. **Requisitos Previos**
   - Java Development Kit (JDK) 8 o superior.
   - IDE como IntelliJ IDEA, Eclipse o Visual Studio Code con soporte para Java.

2. **Clonar el Repositorio**
   ```bash
   git clone https://github.com/tu-usuario/sistema_emergencias.git
   cd sistema_emergencias