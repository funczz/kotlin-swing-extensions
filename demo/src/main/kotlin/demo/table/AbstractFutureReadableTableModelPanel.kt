package demo.table

import com.github.funczz.kotlin.extensions.util.FontUtil
import demo.AbstractGridBagJPanel
import java.awt.GridBagConstraints
import java.util.*
import javax.swing.JScrollPane
import javax.swing.JTable

class AbstractFutureReadableTableModelPanel : AbstractGridBagJPanel() {

    private val list = listOf(
        "How razorback-jumping frogs can level six piqued gymnasts!",
        "Cozy lummox gives smart squid who asks for job pen.",
        "The quick brown fox jumps over the lazy dog.",
        "Jackdaws love my big sphinx of quartz.",
    )

    private val tableData = mutableListOf<Pair<String, String>>().also {
        val random = Random()
        repeat(999) { i ->
            it.add(Pair(i.toString(), list[random.nextInt(list.size)]))
        }
    }

    private val tableModel = AbstractFutureReadableTableModelImpl(tableData = tableData)

    private val jTable = JTable(tableModel).also {
        it.columnModel.also { cm ->
            val c = cm.getColumn(0)
            c.maxWidth = FontUtil.getStringMaxWidth(it, "9999")
        }
    }

    private val jScrollPane = JScrollPane(jTable)

    init {
        addComponent(
            component = jScrollPane,
            gridx = 0,
            gridy = 0,
            fill = GridBagConstraints.BOTH,
            weightx = 1.0,
            weighty = 1.0,
        )
    }

    companion object {
        private const val serialVersionUID: Long = 2444730889904188356L
    }

}