package com.github.funczz.kotlin.extensions.swing.icon

import com.github.funczz.kotlin.extensions.util.FontUtil
import java.awt.*
import java.util.*
import javax.swing.Icon

class CharAnimatedIcon(

    private val char: Char,

    private val font: Font,

    private val fontColor: Color = Color.BLACK,

    repeat: Int = 5,

    ) : Icon, IAnimatedIcon {

    var size: Dimension = run {
        val height = FontUtil.getHeight(font)
        Dimension(height * 3, height)
    }

    private val _text = String(arrayOf(char).toCharArray())

    private val _repeat = Math.max(1, repeat) - 1

    private var _counter = 1

    private var _running: Boolean = false


    override fun next() {
        if (_running) {
            _counter = if (_counter > _repeat) 1 else _counter + 1
        }
    }

    override fun isRunning(): Boolean = _running

    override fun setRunning(running: Boolean) {
        _running = running
    }

    override fun paintIcon(c: Component, g: Graphics, x: Int, y: Int) {
        val g2 = g.create() as Graphics2D

        g2.translate(x, y)
        g2.paint = Optional.ofNullable(c).map(Component::getBackground).orElse(Color.WHITE)
        g2.fillRect(0, 0, iconWidth, iconHeight)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        val s = _text.repeat(_counter)
        g2.font = font
        g2.color = fontColor
        val fontMetrics = g2.fontMetrics
        g2.translate(x, y + fontMetrics.ascent)
        g2.drawString(s, 0, 0)

        g2.dispose()
    }

    override fun getIconWidth(): Int {
        return size.width
    }

    override fun getIconHeight(): Int {
        return size.height
    }

    companion object {
        private const val serialVersionUID: Long = -425064299338921630L
    }

}