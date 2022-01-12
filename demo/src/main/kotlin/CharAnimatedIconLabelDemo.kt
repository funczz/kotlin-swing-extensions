import demo.icon.CharAnimatedIconLabelPanel
import demo.start
import java.awt.Color
import javax.swing.JFrame

class CharAnimatedIconLabelDemo {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            JFrame().start(CharAnimatedIconLabelPanel(char = '>', fontColor = Color.BLUE, repeat = 5, delay = 500))
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}