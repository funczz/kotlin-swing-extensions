package com.github.funczz.kotlin.extensions.util

import java.awt.Dimension
import javax.swing.JScrollPane
import javax.swing.ScrollPaneConstants

object JScrollPaneUtil {

    private const val PANE_WIDTH = 1000

    private const val PANE_HEIGHT = 1000

    fun getScrollBarSize(): Dimension {
        val pane = JScrollPane(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        )
        pane.size = Dimension(PANE_WIDTH, PANE_HEIGHT)
        pane.doLayout()
        return Dimension(
            PANE_WIDTH - pane.viewport.width,
            PANE_HEIGHT - pane.viewport.height
        )
    }
}