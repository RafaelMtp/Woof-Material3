package com.example.woof

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import java.io.File

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [28], qualifiers = "es-rMX-w393dp-h800dp-port-mdpi")
class WoofTest {
    @get:Rule val ui = createAndroidComposeRule<MainActivity>()

    @Test fun claro() = comprobar("claro")

    @Test @Config(qualifiers = "es-rMX-w393dp-h800dp-port-night-mdpi")
    fun oscuro() = comprobar("oscuro")

    private fun comprobar(tema: String) {
        ui.onNodeWithText("Woof").assertIsDisplayed()
        ui.onNodeWithText("Koda").assertIsDisplayed()
        ui.onNodeWithText("16 años").assertIsDisplayed()
        val imagen = ui.runOnIdle {
            val vista = ui.activity.window.decorView
            val bitmap = Bitmap.createBitmap(vista.width, vista.height, Bitmap.Config.ARGB_8888)
            vista.draw(Canvas(bitmap))
            bitmap
        }
        val archivo = File("build/evidencias/$tema.png")
        archivo.parentFile.mkdirs()
        archivo.outputStream().use { imagen.compress(Bitmap.CompressFormat.PNG, 100, it) }
        ui.onNode(hasScrollAction()).performScrollToNode(hasText("Leroy"))
        ui.onNodeWithText("Leroy").assertIsDisplayed()
    }
}
