package com.github.funczz.kotlin.extensions.swing.table_extensions

import java.awt.Color
import javax.swing.ListSelectionModel
import javax.swing.table.TableColumnModel
import javax.swing.table.TableModel

open class AlternateRowBackgroundJTable @JvmOverloads constructor(
    private val rowBackground: Color,
    private val alternateRowBackground: Color,
    dm: TableModel? = null,
    cm: TableColumnModel? = null,
    sm: ListSelectionModel? = null
) : AbstractAlternateRowBackgroundJTable(dm, cm, sm) {

    override fun getRowBackground(): Color {
        return rowBackground
    }

    override fun getAlternateRowBackground(): Color {
        return alternateRowBackground
    }

}