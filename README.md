# 📱 Prototipo 2 - Programación Android

## 📝 Resumen del Proyecto

Este proyecto es el segundo prototipo desarrollado para la asignatura de Programación Android. El objetivo principal es demostrar la correcta implementación de **Intents (Implícitos y Explícitos)** para la navegación y comunicación entre componentes, integrando además buenas prácticas como el manejo asíncrono con **Threads** y validaciones de errores para evitar cierres inesperados de la aplicación.

🛠 **Versión de Android API Mínima:** API 31 "S" (Android 12.0)
⚙️ **Android Gradle Plugin (AGP):** 9.0.1

---

## 🚀 Listado de Intents Implementados y Pasos de Prueba

La aplicación cuenta con una pantalla principal (`MainActivity`) que centraliza las acciones. A continuación, se detallan los intents y cómo probarlos:

### 🌐 5 Intents Implícitos (Interacción con el Sistema)

Todos estos intents cuentan con validaciones (`try-catch`) para asegurar que la aplicación no se cierre (`crash`) en caso de que el dispositivo del usuario no cuente con una aplicación compatible para manejar la acción.

1.  **Abrir Sitio Web (`ACTION_VIEW` con `https://`)**
    *   **Paso de prueba:** Presionar el botón "1. Abrir Sitio Web".
    *   **Resultado esperado:** El dispositivo abrirá el navegador predeterminado cargando la página institucional de Santo Tomás.
2.  **Llamar por Teléfono (`ACTION_DIAL` con `tel:`)**
    *   **Paso de prueba:** Presionar el botón "2. Llamar por Teléfono".
    *   **Resultado esperado:** Se abrirá el marcador telefónico del sistema pre-rellenado con un número de contacto, sin realizar la llamada automáticamente.
3.  **Ver Mapa Sede (`ACTION_VIEW` con `geo:`)**
    *   **Paso de prueba:** Presionar el botón "3. Ver Mapa Sede".
    *   **Resultado esperado:** Se abrirá la aplicación de Google Maps (o similar) apuntando a las coordenadas de la sede.
4.  **Ajustes Wi-Fi (`Settings.ACTION_WIFI_SETTINGS`)**
    *   **Paso de prueba:** Presionar el botón "4. Ajustes Wi-Fi".
    *   **Resultado esperado:** El sistema redirigirá al usuario directamente a la pantalla de configuración de redes Wi-Fi del dispositivo.
5.  **Enviar SMS (`ACTION_SENDTO` con `smsto:`)**
    *   **Paso de prueba:** Presionar el botón "5. Enviar SMS".
    *   **Resultado esperado:** Se abrirá la aplicación de mensajería predeterminada con un número pre-cargado, lista para escribir un mensaje.

### 🔄 3 Intents Explícitos (Navegación Interna y Paso de Datos)

1.  **`MainActivity` → `DetalleActivity` (Envío de Datos Extras)**
    *   **Paso de prueba:** Escribir un texto en el campo de entrada (`EditText`) y presionar "7. Ver Detalle (Enviar Dato)".
    *   **Resultado esperado:** Se abre una nueva pantalla mostrando exactamente el texto que el usuario ingresó, demostrando la comunicación mediante `putExtra`. Se incorpora un botón de retorno.
2.  **`MainActivity` → `ConfigActivity` (Espera de Resultado Bidireccional)**
    *   **Paso de prueba:** Presionar "6. Ir a Configuración (Esperar Respuesta)". En la nueva pantalla, presionar "Guardar y Volver".
    *   **Resultado esperado:** La aplicación regresa a la pantalla principal y muestra un `Toast` indicando "¡Configuración guardada exitosamente!", demostrando el uso de `registerForActivityResult`.
3.  **`MainActivity` → `ThreadActivity` (Proceso Asíncrono)**
    *   **Paso de prueba:** Presionar "8. Iniciar Proceso (Thread)".
    *   **Resultado esperado:** Se abre una pantalla indicando "Procesando en segundo plano...". Tras 2.5 segundos, el texto cambia a color verde indicando "✅ Proceso completado con éxito". Esto demuestra el uso correcto de **Threads** en segundo plano (`Thread.sleep`) y la actualización de la interfaz gráfica a través de `runOnUiThread`.

---

## 📸 Capturas de Pantalla

> 1. El Menú principal.
> 2. Intent implicito de abrir google maps en una ubicacion.
> 3. La pantalla de teclado numerico con un numero para llamar.
> 4. La pantalla del Thread con el mensaje de éxito.

| Menú Principal | Intent Implícito (Mapa) | LLamada (Listo para llamar) | Thread (Proceso Completo) |
| :---: | :---: | :---: | :---: |


| <img width="220" alt="Menú" src="https://github.com/user-attachments/assets/198d25bd-956e-4735-98e5-84ddc0e19be3" /> | <img width="220" alt="Mapa" src="https://github.com/user-attachments/assets/8109f478-0351-4011-8c34-81f33213a659" /> | <img width="220" alt="Llamada" src="https://github.com/user-attachments/assets/027d6821-a5a4-4a8f-a9dd-2fe892e3ceee" /> | <img width="220"  alt="thread" src="https://github.com/user-attachments/assets/e1ce0d74-3db4-4517-b71b-eee78452bddb" />
 |



---

## 📦 APK e Instrucciones de Compilación

### Archivo APK
El archivo ejecutable (.apk) en modo depuración (debug) se encuentra alojado dentro de este repositorio en la siguiente ruta:
📁 `app/build/outputs/apk/debug/app-debug.apk`

### Instrucciones para compilar desde el código fuente
Si deseas compilar el proyecto directamente en Android Studio:

1.  Abre la terminal o línea de comandos.
2.  Clona este repositorio utilizando el comando:
    `git clone [URL_DE_TU_REPOSITORIO]`
3.  Asegúrate de estar en la rama correcta (si aplica):
    `git checkout feature/intents`
4.  Abre **Android Studio**, selecciona `File > Open...` y localiza la carpeta raíz del proyecto clonado.
5.  Espera a que Gradle sincronice las dependencias del proyecto de forma automática.
6.  Conecta un dispositivo físico o inicia un Emulador.
7.  Presiona el botón **Run** (Shift + F10) para compilar y ejecutar la aplicación.
