package com.github.funczz.kotlin.extensions.swing.list_extensions

import io.kotlintest.provided.AbstractGridBagJPanel
import java.awt.Color
import java.awt.GridBagConstraints
import javax.swing.*

class JComponentListCellRendererPanel(

    selectionBackground: Color? = null,

    ) : AbstractGridBagJPanel() {

    private val label = JLabel("List")

    private val listModel = DefaultListModel<ElementPanel>().also {
        (0..99).map {
            ElementPanel(it)
        }.forEach { p ->
            it.addElement(p)
        }
    }

    private val listCellRenderer = JComponentListCellRenderer<ElementPanel>(
        selectionBackground = selectionBackground
    )

    private val jList = JList(listModel).also {
        it.setCellRenderer(listCellRenderer)
    }

    private val jScrollPane = JScrollPane(jList)

    init {
        addComponent(
            component = label,
            gridx = 0,
            gridy = 0,
            anchor = GridBagConstraints.WEST,
        )
        addComponent(
            component = jScrollPane,
            gridx = 0,
            gridy = 1,
            fill = GridBagConstraints.BOTH,
            weightx = 1.0,
            weighty = 1.0,
        )

        jList.addListSelectionListener {
            val result = jList.selectedIndices.joinToString(" ")
            println("selected: $result")
        }
    }

}