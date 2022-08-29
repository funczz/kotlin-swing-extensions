package com.github.funczz.kotlin.extensions.swing.icon

import java.io.Serializable
import javax.swing.Icon

interface IAnimatedIcon : Icon, Serializable {

    fun next()

    fun isRunning(): Boolean

    fun setRunning(running: Boolean)

}