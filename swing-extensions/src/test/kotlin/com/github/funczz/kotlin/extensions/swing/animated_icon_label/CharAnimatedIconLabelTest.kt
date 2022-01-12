package com.github.funczz.kotlin.extensions.swing.animated_icon_label

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import java.awt.Color
import javax.swing.JFrame

internal class CharAnimatedIconLabelTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(CharAnimatedIconLabelPanel(char = '>', fontColor = Color.BLUE, repeat = 5, delay = 500))
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}