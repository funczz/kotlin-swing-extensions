package com.github.funczz.kotlin.extensions.swing.animated_icon_label

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import java.awt.Color
import javax.swing.JFrame

internal class CircleAnimatedIconLabelTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(CircleAnimatedIconLabelPanel(ellipseColor = Color.BLUE, iconSize = 6, delay = 500))
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}