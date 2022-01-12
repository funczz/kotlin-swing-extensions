package com.github.funczz.kotlin.extensions.swing.list

import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import java.util.*
import javax.swing.BoxLayout
import javax.swing.JPanel
import javax.swing.ListModel
import javax.swing.event.ListDataEvent
import javax.swing.event.ListDataListener

class JPanelList<T : JPanel> constructor(

    axis: Int,

    listModel: ListModel<T>,

    ) : JPanel(null) {

    constructor(axis: Int, data: List<T>) : this(
        axis = axis,
        listModel = ImmutableListModel(data)
    )

    constructor(axis: Int, data: Vector<T>) : this(
        axis = axis,
        listModel = ImmutableListModel(data)
    )

    private val listDataListener = object : ListDataListener {
        override fun intervalAdded(p0: ListDataEvent) {
            fireChanged()
        }

        override fun intervalRemoved(p0: ListDataEvent) {
            fireChanged()
        }

        override fun contentsChanged(p0: ListDataEvent) {
            fireChanged()
        }
    }

    private var listModel: ListModel<T> = EmptyListModel()

    fun set(listModel: ListModel<T>) {
        this.listModel.removeListDataListener(listDataListener)
        this.listModel = listModel
        this.listModel.addListDataListener(listDataListener)
        fireChanged()
    }

    fun set(data: List<T>) {
        set(ImmutableListModel(data))
    }

    fun set(data: Vector<T>) {
        set(ImmutableListModel(data))
    }

    fun fireChanged() {
        removeAll()
        repeat(listModel.size) {
            val element = listModel.getElementAt(it)
            add(element)
            revalidate()
        }
        repaint()
    }

    init {
        layout = BoxLayout(this, axis)

        addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent?) {
                fireChanged()
            }
        })
        set(listModel)
    }

    companion object {
        private const val serialVersionUID: Long = -7792372006070652471L
    }

}