package com.github.funczz.kotlin.extensions.util

import java.awt.Dimension
import java.awt.Point
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities

object JFrameUtil {

    fun getOwner(component: JComponent): JFrame =
        SwingUtilities.getWindowAncestor(component) as JFrame

    fun getLocation(owner: JFrame, dimension: Dimension, gravity: Gravity, offsetX: Int, offsetY: Int): Point {
        val (x, y) = when (gravity) {
            Gravity.CENTER -> Pair(getCenter(owner, dimension.width), getMiddle(owner, dimension.height))
            Gravity.NORTH -> Pair(getCenter(owner, dimension.width), getTop(owner))
            Gravity.NORTH_EAST -> Pair(getRight(owner, dimension.width), getTop(owner))
            Gravity.EAST -> Pair(getRight(owner, dimension.width), getMiddle(owner, dimension.height))
            Gravity.SOUTH_EAST -> Pair(getRight(owner, dimension.width), getBottom(owner, dimension.height))
            Gravity.SOUTH -> Pair(getCenter(owner, dimension.width), getBottom(owner, dimension.height))
            Gravity.SOUTH_WEST -> Pair(getLeft(owner), getBottom(owner, dimension.height))
            Gravity.WEST -> Pair(getLeft(owner), getMiddle(owner, dimension.height))
            Gravity.NORTH_WEST -> Pair(getLeft(owner), getTop(owner))
        }
        return Point(x + offsetX, y + offsetY)
    }

    fun getLeft(owner: JFrame): Int {
        return owner.location.x + owner.insets.left
    }

    fun getCenter(owner: JFrame, width: Int): Int {
        return owner.location.x + ((owner.width - width) / 2)
    }

    fun getRight(owner: JFrame, width: Int): Int {
        return owner.location.x + owner.width - width - owner.insets.right
    }

    fun getTop(owner: JFrame): Int {
        return owner.location.y + owner.insets.top
    }

    fun getMiddle(owner: JFrame, height: Int): Int {
        val top = owner.insets.top
        val bottom = owner.insets.bottom
        return owner.location.y + ((owner.height - height - top - bottom) / 2) + top
    }

    fun getBottom(owner: JFrame, height: Int): Int {
        return owner.location.y + owner.height - height - owner.insets.bottom
    }

}

enum class Gravity {
    CENTER,
    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST,
    NORTH_WEST;

    companion object {

        @JvmStatic
        fun getEnum(name: String): Gravity {
            return when (name) {
                CENTER.name -> CENTER
                NORTH.name -> NORTH
                NORTH_EAST.name -> NORTH_EAST
                EAST.name -> EAST
                SOUTH_EAST.name -> SOUTH_EAST
                SOUTH.name -> SOUTH
                SOUTH_WEST.name -> SOUTH_WEST
                WEST.name -> WEST
                NORTH_WEST.name -> NORTH_WEST
                else -> throw IllegalArgumentException("Gravity name mismatch: %s".format(name))
            }
        }

    }
}
