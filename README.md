# Woof · Material 3

Práctica de temas con Jetpack Compose. La pantalla muestra nueve perros con su foto, nombre y edad. El tema sigue la configuración clara u oscura del dispositivo.

## Ejecutar en Android Studio

1. Abre la carpeta que contiene `settings.gradle.kts` y espera a que termine la sincronización.
2. Usa JDK 17 para Gradle e instala Android SDK 34 si Android Studio lo solicita.
3. Selecciona un emulador con API 24 o posterior y pulsa Run ▶.
4. Desliza hasta Leroy. Cambia el tema oscuro desde los ajustes del dispositivo y vuelve a la app para comparar las tarjetas.

En un dispositivo configurado en español, las edades se presentan en años. La barra usa Abril Fatface y las tarjetas usan Montserrat. Las fotos se recortan en círculo. Los colores y las formas se definen en `ui/theme`.

## Pruebas

Desde la carpeta del proyecto, ejecuta `./gradlew testDebugUnitTest` (en Windows, `.\gradlew.bat testDebugUnitTest`). Las pruebas abren MainActivity con Robolectric, comprueban nombres y edades, capturan la lista y se desplazan al último perro. Las imágenes quedan en `app/build/evidencias/`.

Adaptación didáctica de la [rama material de Woof](https://github.com/google-developer-training/basic-android-kotlin-compose-training-woof/tree/material), con sus recursos, fuentes y licencia. [Instrucciones de la práctica](https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming?hl=es-419).
