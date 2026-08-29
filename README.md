# 🧪 Java JUnit Testing

> 📚 Repositorio dedicado al aprendizaje y práctica de **JUnit 5** en Java.

Este proyecto reúne los principales conceptos y funcionalidades estudiadas durante el aprendizaje de **pruebas unitarias con JUnit 5**, desde assertions y ciclo de vida hasta pruebas parametrizadas, repetitivas y ejecución condicional.

---

## 🛠️ Tecnologías

| Tecnología     | Uso                                 |
| -------------- | ----------------------------------- |
| ☕ **Java**     | Lenguaje de programación            |
| 🧪 **JUnit 5** | Framework de testing                |
| 📦 **Maven**   | Gestión del proyecto y dependencias |

---

# 📖 Temas aprendidos

### ✅ Assertions

Validación de resultados dentro de las pruebas.

* `assertEquals`
* `assertAll`

---

### 🏷️ Identificación y organización

Herramientas para hacer los tests más claros y organizados.

* `@DisplayName`
* `@Tag`
* `TestInfo`

---

### 🔄 Ciclo de vida

Configuración y ejecución de código antes y después de las pruebas.

* `@BeforeAll`
* `@AfterAll`
* `@BeforeEach`
* `@AfterEach`

---

### 📊 Pruebas parametrizadas

Permiten ejecutar una misma prueba utilizando diferentes conjuntos de datos.

* `@ParameterizedTest`
* `@CsvSource`
* `@ValueSource`

---

### 🔁 Pruebas repetitivas

Ejecución de una misma prueba múltiples veces.

* `@RepeatedTest`

---

### ⚙️ Assumptions

Permiten ejecutar una prueba únicamente cuando se cumple una determinada condición.

* `Assumptions`

---

### 🗂️ Pruebas anidadas

Permiten organizar y agrupar pruebas relacionadas.

* `@Nested`

---

### 🖥️ Ejecución condicional

Control de las pruebas según diferentes condiciones del entorno.

* `@EnabledIfSystemProperty`
* `@EnabledOnJre`
* `@EnabledOnOs`

---

### 🚫 Control de ejecución

Permite desactivar temporalmente pruebas que no deben ejecutarse.

* `@Disabled`

---

### ⏱️ Control de tiempo

Permite establecer límites de tiempo para la ejecución de una prueba.

* `@Timeout`

---

### 📝 Reportes e información

Herramientas para proporcionar información adicional durante la ejecución de los tests.

* `TestReporter`

---

# 🧭 Mapa de aprendizaje

```text
                    🧪 JUNIT 5
                        │
       ┌────────────────┼────────────────┐
       │                │                │
   ✅ Assertions    🔄 Lifecycle    📊 Parametrized
       │                │                │
  assertEquals       BeforeAll       CsvSource
  assertAll          AfterAll        ValueSource
                     BeforeEach      ParameterizedTest
                     AfterEach
       │
       ├───────────────┬────────────────┐
       │               │                │
   🔁 Repeated     ⚙️ Conditions     🗂️ Organization
       │               │                │
 RepeatedTest      EnabledOnOs       Nested
                   EnabledOnJre       Tag
                   EnabledIf...       DisplayName
       │
       ├───────────────┬────────────────┐
       │               │                │
   🚫 Disabled      ⏱️ Timeout       📝 Reporter
```

---

# 🎯 Objetivo del proyecto

Consolidar los conocimientos fundamentales de **JUnit 5** mediante la práctica de diferentes herramientas para crear pruebas unitarias más organizadas, legibles y mantenibles.

---

# 📌 JUnit 5 — Checklist

* [x] `assertEquals`
* [x] `assertAll`
* [x] `@DisplayName`
* [x] `@Tag`
* [x] `TestInfo`
* [x] `TestReporter`
* [x] `@Timeout`
* [x] `@CsvSource`
* [x] `@ValueSource`
* [x] `@ParameterizedTest`
* [x] `@RepeatedTest`
* [x] `Assumptions`
* [x] `@Nested`
* [x] `@EnabledIfSystemProperty`
* [x] `@EnabledOnJre`
* [x] `@EnabledOnOs`
* [x] `@BeforeAll`
* [x] `@AfterAll`
* [x] `@BeforeEach`
* [x] `@AfterEach`
* [x] `@Disabled`

---

## 🚀 Próximamente

> 🔜 Continuar fortaleciendo conocimientos de testing en Java y avanzar hacia herramientas como **Mockito**, pruebas de integración y testing dentro de aplicaciones **Spring Boot**.

---

⭐ **Proyecto de aprendizaje y práctica de JUnit 5 con Java.**
