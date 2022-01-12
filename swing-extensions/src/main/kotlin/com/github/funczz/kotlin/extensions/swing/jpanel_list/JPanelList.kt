package com.github.funczz.kotlin.extensions.swing.jpanel_list

import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import java.util.*
import javax.swing.*
import javax.swing.event.ListDataEvent
import javax.swing.event.ListDataListener

class JPanelList<T : JPanel> @JvmOverloads constructor(

    axis: Int,

    dataModel: ListModel<T>? = null,

) : JPanel(null) {

    constructor(axis: Int, listData: List<T>): this(axis = axis) {
        setModel(listData)
    }

    constructor(axis: Int, listData: Vector<T>): this(axis = axis) {
        setModel(listData)
    }

    private val noDataModel: ListModel<T> = object : AbstractListModel<T>() {
        override fun getSize(): Int = 0
        override fun getElementAt(i: Int): T = throw IndexOutOfBoundsException("No Data Model")
    }

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

    private var dataModel: ListModel<T> = noDataModel


    fun getModel(): ListModel<T> = dataModel

    fun setModel(dataModel: ListModel<T>?) {
        val model = dataModel ?: noDataModel
        this.dataModel.removeListDataListener(listDataListener)
        this.dataModel = model
        this.dataModel.addListDataListener(listDataListener)
        fireChanged()
    }

    fun setModel(listData: List<T>) {
        val dataModel = object : AbstractListModel<T>() {
            override fun getSize(): Int = listData.size
            override fun getElementAt(i: Int): T = listData[i]
        }
        setModel(dataModel)
    }

    fun setModel(listData: Vector<T>) {
        val dataModel = object : AbstractListModel<T>() {
            override fun getSize(): Int = listData.size
            override fun getElementAt(i: Int): T = listData[i]
        }
        setModel(dataModel)
    }

    fun fireChanged() {
        removeAll()
        val model = getModel()
        repeat(model.size) {
            val element = model.getElementAt(it)
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
        setModel(dataModel)
    }

}