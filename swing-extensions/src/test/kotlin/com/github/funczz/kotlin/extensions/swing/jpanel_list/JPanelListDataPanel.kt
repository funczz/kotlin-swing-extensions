package com.github.funczz.kotlin.extensions.swing.jpanel_list

import com.github.funczz.kotlin.extensions.util.JScrollPaneUtil
import io.kotlintest.provided.AbstractGridBagJPanel
import java.awt.GridBagConstraints
import javax.swing.DefaultListModel
import javax.swing.JScrollPane
import javax.swing.ListModel

class JPanelListDataPanel(

    axis: Int,

    listData: List<ElementPanel>,

    ) : AbstractGridBagJPanel() {

    private val dataModel: ListModel<ElementPanel>

    private val jPanelList: JPanelList<ElementPanel>

    private val jScrollPane: JScrollPane

    init {
        jPanelList = JPanelList<ElementPanel>(axis = axis, listData = listData).also {
            val dimension = it.preferredSize
            it.minimumSize = dimension
            it.maximumSize = dimension
        }
        dataModel = jPanelList.getModel()

        jScrollPane = JScrollPane(jPanelList).also {
            val size = JScrollPaneUtil.getScrollBarSize()
            val dimension = when (axis) {
                javax.swing.BoxLayout.Y_AXIS -> {
                    java.awt.Dimension(
                        jPanelList.preferredSize.width + size.width,
                        500
                    )
                }
                javax.swing.BoxLayout.X_AXIS -> {
                    java.awt.Dimension(
                        500,
                        jPanelList.preferredSize.height + size.height
                    )
                }
                else -> throw IllegalArgumentException("axis: $axis")
            }
            it.preferredSize = dimension
            it.minimumSize = dimension
        }

        addComponent(
            component = jScrollPane,
            gridx = 0,
            gridy = 0,
            fill = GridBagConstraints.BOTH,
            weightx = 1.0,
            weighty = 1.0,
        )
    }

}