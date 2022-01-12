package com.github.funczz.kotlin.extensions.swing.animated_icon_label

import javax.swing.Icon

interface IAnimatedIcon : Icon {

    fun next()

    fun isRunning(): Boolean

    fun setRunning(running: Boolean)

}