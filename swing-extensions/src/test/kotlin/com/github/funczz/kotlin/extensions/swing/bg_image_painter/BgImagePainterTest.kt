package com.github.funczz.kotlin.extensions.swing.bg_image_painter

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import java.awt.Dimension
import javax.swing.JFrame

internal class BgImagePainterTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(BgImagePainterPanel().also {
                it.preferredSize = Dimension(1024, 768)
            })
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}