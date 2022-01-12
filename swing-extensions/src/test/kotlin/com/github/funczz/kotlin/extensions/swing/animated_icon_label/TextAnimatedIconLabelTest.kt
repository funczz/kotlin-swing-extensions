package com.github.funczz.kotlin.extensions.swing.animated_icon_label

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import java.awt.Color
import javax.swing.JFrame

internal class TextAnimatedIconLabelTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(TextAnimatedIconLabelPanel(fontColor = Color.BLUE, delay = 500))
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}