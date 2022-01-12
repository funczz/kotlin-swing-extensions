package io.kotlintest.provided.com.github.funczz.kotlin.extensions.swing.toast_jdialog

import com.github.funczz.kotlin.extensions.util.Gravity
import javax.swing.ButtonGroup
import javax.swing.JRadioButton

class GravityButton(

    private val selection: Gravity? = null,

    private val text: (Gravity) -> String = { it.name },

    private val f: (Gravity) -> Unit = {}

) {

    val center = JRadioButton().also {
        initializeButton(it, Gravity.CENTER.name)
    }

    val north = JRadioButton().also {
        initializeButton(it, Gravity.NORTH.name)
    }

    val north_east = JRadioButton().also {
        initializeButton(it, Gravity.NORTH_EAST.name)
    }

    val east = JRadioButton().also {
        initializeButton(it, Gravity.EAST.name)
    }

    val south_east = JRadioButton().also {
        initializeButton(it, Gravity.SOUTH_EAST.name)
    }

    val south = JRadioButton().also {
        initializeButton(it, Gravity.SOUTH.name)
    }

    val south_west = JRadioButton().also {
        initializeButton(it, Gravity.SOUTH_WEST.name)
    }

    val west = JRadioButton().also {
        initializeButton(it, Gravity.WEST.name)
    }

    val north_west = JRadioButton().also {
        initializeButton(it, Gravity.NORTH_WEST.name)
    }

    val buttons = listOf(
        center,
        north,
        north_east,
        east,
        south_east,
        south,
        south_west,
        west,
        north_west
    )

    val buttonGroup = ButtonGroup().also {
        it.add(center)
        buttons.forEach { b ->
            it.add(b)
        }
    }

    private fun initializeButton(button: JRadioButton, name: String) {
        val gravity = Gravity.getEnum(name)
        if (selection != null && selection == gravity) {
            button.isSelected = true
        }
        button.name = gravity.name
        button.actionCommand = gravity.name
        button.text = text(gravity)
        button.addActionListener {
            f(gravity)
        }
    }
}