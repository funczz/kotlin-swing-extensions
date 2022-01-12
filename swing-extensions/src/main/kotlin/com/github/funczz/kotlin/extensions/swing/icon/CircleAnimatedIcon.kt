package com.github.funczz.kotlin.extensions.swing.icon

import java.awt.*
import java.awt.geom.Ellipse2D
import java.util.*

class CircleAnimatedIcon(

    private val ellipseColor: Color = Color(0x80_80_80),

    iconSize: Int = 1,

    ) : IAnimatedIcon {

    private val R = 2.0 * iconSize
    private val SX = 1.0 * iconSize
    private val SY = 1.0 * iconSize

    private val _width = (R * 8 + SX * 2).toInt()

    private val _height = (R * 8 + SY * 2).toInt()

    private val _list: MutableList<Shape> = mutableListOf(
        Ellipse2D.Double(SX + 1 * R, SY + 1 * R, 2 * R, 2 * R),
        Ellipse2D.Double(SX + 0 * R, SY + 3 * R, 2 * R, 2 * R),
        Ellipse2D.Double(SX + 1 * R, SY + 5 * R, 2 * R, 2 * R),
        Ellipse2D.Double(SX + 3 * R, SY + 6 * R, 2 * R, 2 * R),
        Ellipse2D.Double(SX + 5 * R, SY + 5 * R, 2 * R, 2 * R),
        Ellipse2D.Double(SX + 6 * R, SY + 3 * R, 2 * R, 2 * R),
        Ellipse2D.Double(SX + 5 * R, SY + 1 * R, 2 * R, 2 * R),
        Ellipse2D.Double(SX + 3 * R, SY + 0 * R, 2 * R, 2 * R)
    )

    private var _running: Boolean = false

    override fun next() {
        if (_running) {
            Collections.rotate(_list, 1)
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
        g2.paint = ellipseColor
        val size = _list.size.toFloat()
        _list.forEach { s ->
            val alpha = if (_running) (_list.size - _list.indexOf(s)) / size else .5f
            g2.composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)
            g2.fill(s)
        }

        g2.dispose()
    }

    override fun getIconWidth(): Int {
        return _width
    }

    override fun getIconHeight(): Int {
        return _height
    }

    companion object {
        private const val serialVersionUID: Long = -3166844774956169173L
    }

}