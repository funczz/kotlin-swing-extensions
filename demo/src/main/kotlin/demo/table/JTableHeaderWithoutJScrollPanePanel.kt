package demo.table

import com.github.funczz.kotlin.extensions.swing.table.AlternateRowBackgroundJTable
import com.github.funczz.kotlin.extensions.util.FontUtil
import demo.AbstractGridBagJPanel
import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.util.*
import javax.swing.UIManager
import javax.swing.table.DefaultTableModel

class JTableHeaderWithoutJScrollPanePanel : AbstractGridBagJPanel() {

    private val list = listOf(
        "How razorback-jumping frogs can level six piqued gymnasts!",
        "Cozy lummox gives smart squid who asks for job pen.",
        "The quick brown fox jumps over the lazy dog.",
        "Jackdaws love my big sphinx of quartz.",
    )

    private val tableModel = DefaultTableModel(arrayOf("No.", "Pangram"), 0).also {
        val random = Random()
        repeat(10) { i ->
            it.addRow(arrayOf(i.toString(), list[random.nextInt(list.size)]))
        }
    }

    private val jTable = AlternateRowBackgroundJTable(
        rowBackground = UIManager.getColor("Table.background"),
        alternateRowBackground = Color.LIGHT_GRAY,
        dm = tableModel
    ).also {
        it.columnModel.also { cm ->
            val c = cm.getColumn(0)
            c.maxWidth = FontUtil.getStringMaxWidth(it, "9999")
        }
        val dimension = Dimension(600, 300)
        it.preferredSize = dimension
        it.minimumSize = dimension
    }

    private val jTableHeader = jTable.tableHeader

    init {
        addComponent(
            component = jTableHeader,
            gridx = 0,
            gridy = 0,
            fill = GridBagConstraints.HORIZONTAL,
            weightx = 1.0,
        )
        addComponent(
            component = jTable,
            gridx = 0,
            gridy = 1,
            fill = GridBagConstraints.BOTH,
            weightx = 1.0,
            weighty = 1.0,
        )
    }

    companion object {
        private const val serialVersionUID: Long = -4150331078978921543L
    }

}