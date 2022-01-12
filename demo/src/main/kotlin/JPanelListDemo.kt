import demo.list.JPanelListElementPanel
import demo.list.JPanelListPanel
import demo.start
import javax.swing.BoxLayout
import javax.swing.DefaultListModel
import javax.swing.JFrame

class JPanelListDemo {

    companion object {

        private val data: List<JPanelListElementPanel> = mutableListOf<JPanelListElementPanel>().also {
            repeat(20) { i ->
                it.add(JPanelListElementPanel(i))
            }
        }

        private val listModel: DefaultListModel<JPanelListElementPanel> =
            DefaultListModel<JPanelListElementPanel>().also {
                data.forEach { e ->
                    it.addElement(e)
                }
            }

        @JvmStatic
        fun main(args: Array<String>) {
            //JFrame().start(ElementPanel(0))
            //JFrame().start(JPanelListDataPanel(axis = BoxLayout.X_AXIS, data = listData))
            JFrame().start(JPanelListPanel(axis = BoxLayout.Y_AXIS, listModel = listModel))
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}