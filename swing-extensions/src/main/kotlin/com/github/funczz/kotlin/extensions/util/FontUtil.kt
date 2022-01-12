package com.github.funczz.kotlin.extensions.util

import java.awt.Component
import java.awt.Font
import java.awt.Toolkit
import java.awt.font.GlyphVector

object FontUtil {

    fun getHeight(font: Font): Int {
        val fontSize = font.size
        val screenResolution = Toolkit.getDefaultToolkit().screenResolution
        val result = fontSize * screenResolution / 72.0
        return result.toInt()
    }

    fun getStringHeight(component: Component, text: String): Int {
        return getHeight(component.font) * text.lines().size
    }

    fun getStringMaxWidth(component: Component, text: String): Int {
        val font = component.font
        val context = component.getFontMetrics(font).fontRenderContext
        return text.lines().fold(0) { acc, v ->
            val gv: GlyphVector = font.createGlyphVector(context, v.replace(" ", "_"))
            val s = gv.getPixelBounds(null, 0F, 0F).width
            if (acc > s) acc else s
        }
    }

    fun getStringWidth(component: Component, text: String): List<Int> {
        val font = component.font
        val context = component.getFontMetrics(font).fontRenderContext
        return text.lines().map { v ->
            val gv: GlyphVector = font.createGlyphVector(context, v.replace(" ", "_"))
            val s = gv.getPixelBounds(null, 0F, 0F).width
            s
        }
    }

}