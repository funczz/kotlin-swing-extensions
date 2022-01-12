package com.github.funczz.kotlin.extensions.swing.toast_jdialog

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class ToastTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(ToastPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}