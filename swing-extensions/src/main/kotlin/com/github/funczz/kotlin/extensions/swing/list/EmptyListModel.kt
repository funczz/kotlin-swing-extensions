package com.github.funczz.kotlin.extensions.swing.list

import javax.swing.AbstractListModel

class EmptyListModel<T> : AbstractListModel<T>() {

    override fun getSize(): Int = 0

    override fun getElementAt(p0: Int): T = throw IllegalStateException(
        "no such element: %s".format(this)
    )

    companion object {
        private const val serialVersionUID: Long = 301466994220212572L
    }
}