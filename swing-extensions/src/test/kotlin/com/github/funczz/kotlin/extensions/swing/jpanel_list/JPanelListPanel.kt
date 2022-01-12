package com.github.funczz.kotlin.extensions.swing.jpanel_list

import com.github.funczz.kotlin.extensions.util.JScrollPaneUtil
import io.kotlintest.provided.AbstractGridBagJPanel
import java.awt.Dimension
import java.awt.GridBagConstraints
import javax.swing.*

class JPanelListPanel(

    axis: Int,

    private val dataModel: DefaultListModel<ElementPanel>,

    ) : AbstractGridBagJPanel() {

    private val addButton = JButton("add").also {
        val dimension = it.preferredSize
        it.minimumSize = dimension
        it.maximumSize = dimension
        it.addActionListener {
            dataModel.addElement(ElementPanel(dataModel.size))
        }
    }

    private val jPanelList = JPanelList<ElementPanel>(axis = axis, dataModel = dataModel).also {
        val dimension = it.preferredSize
        it.minimumSize = dimension
        it.maximumSize = dimension
    }

    private val jScrollPane = JScrollPane(jPanelList).also {
        val size = JScrollPaneUtil.getScrollBarSize()
        val dimension = when (axis) {
            BoxLayout.Y_AXIS -> {
                Dimension(
                    jPanelList.preferredSize.width + size.width,
                    500
                )
            }
            BoxLayout.X_AXIS -> {
                Dimension(
                    500,
                    jPanelList.preferredSize.height + size.height
                )
            }
            else -> throw IllegalArgumentException("axis: $axis")
        }
        it.preferredSize = dimension
        it.minimumSize = dimension
    }

    init {
        addComponent(
            component = addButton,
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
    }

}