package demo

import javax.swing.UIManager

object UIManagerUtil {

    fun printDefaults() {
        UIManager.getDefaults().forEach { (k, v) ->
            println("UIManager.getDefaults: $k=$v")
        }
    }

}