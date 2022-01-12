package com.github.funczz.kotlin.extensions.swing.jpanel_list

import io.kotlintest.provided.start
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import javax.swing.BoxLayout
import javax.swing.DefaultListModel
import javax.swing.JFrame

internal class JPanelListTest : StringSpec() {

    private val listData: List<ElementPanel> = mutableListOf<ElementPanel>().also {
        repeat(20) { i ->
            it.add(ElementPanel(i))
        }
    }

    private val dataModel: DefaultListModel<ElementPanel> = DefaultListModel<ElementPanel>().also {
        listData.forEach { e ->
            it.addElement(e)
        }
    }

    init {

        "デモ" {
            //JFrame().start(ElementPanel(0))
            //JFrame().start(JPanelListDataPanel(axis = BoxLayout.X_AXIS, listData = listData))
            JFrame().start(JPanelListPanel(axis = BoxLayout.Y_AXIS, dataModel = dataModel))
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}