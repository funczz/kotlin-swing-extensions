package com.github.funczz.kotlin.extensions.swing.jpanel_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class GridBagJPanelTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(TableRowSorterGridBagJPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}