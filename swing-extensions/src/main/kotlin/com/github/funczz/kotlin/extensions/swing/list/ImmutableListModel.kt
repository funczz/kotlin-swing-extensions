package com.github.funczz.kotlin.extensions.swing.list

import javax.swing.AbstractListModel

class ImmutableListModel<T>(private val data: List<T>) : AbstractListModel<T>() {

    override fun getSize(): Int = data.size

    override fun getElementAt(p0: Int): T = data[p0]

    companion object {
        private const val serialVersionUID: Long = 301466994220212572L
    }
}