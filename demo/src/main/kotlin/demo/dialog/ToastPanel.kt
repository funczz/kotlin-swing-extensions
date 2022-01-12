package demo.dialog

import com.github.funczz.kotlin.extensions.swing.addFunctionalDocumentListener
import com.github.funczz.kotlin.extensions.swing.dialog.Toast
import com.github.funczz.kotlin.extensions.util.FontUtil
import com.github.funczz.kotlin.extensions.util.Gravity
import com.github.funczz.kotlin.extensions.util.JFrameUtil
import demo.AbstractGridBagJPanel
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.GridBagConstraints
import javax.swing.*
import javax.swing.border.EtchedBorder

class ToastPanel : AbstractGridBagJPanel() {

    private var gravity = Gravity.SOUTH

    private var offsetX = 0

    private var offsetY = 0

    private val gravityButtonPanel = JPanel(FlowLayout()).also {
        val gravityButton = GravityButton(selection = Gravity.SOUTH) {
            gravity = it
        }
        gravityButton.buttons.forEach { b ->
            it.add(b)
        }
        it.border = EtchedBorder(EtchedBorder.LOWERED)
    }

    private val offsetFieldPanel = JPanel().also {
        val x = JTextField("0").also {
            val color = it.foreground
            it.document.addFunctionalDocumentListener { _ ->
                try {
                    offsetX = it.text.toInt()
                    it.foreground = color
                } catch (e: NumberFormatException) {
                    it.foreground = Color.RED
                }
            }
        }
        val y = JTextField("0").also {
            val color = it.foreground
            it.document.addFunctionalDocumentListener { _ ->
                try {
                    offsetY = it.text.toInt()
                    it.foreground = color
                } catch (e: NumberFormatException) {
                    it.foreground = Color.RED
                }
            }
        }
        val boxWidth = FontUtil.getStringMaxWidth(x, "999")
        it.layout = BoxLayout(it, BoxLayout.X_AXIS)
        it.add(JLabel("Offset X "))
        it.add(x)
        it.add(Box.createRigidArea(Dimension(boxWidth, 0)))
        it.add(JLabel("Offset Y "))
        it.add(y)
    }

    private val jTextField = JTextArea().also {
        val dimension = Dimension(200, it.preferredSize.height * 5)
        it.preferredSize = dimension
        it.minimumSize = dimension
    }

    private val jButton = JButton("通知").also {
        it.addActionListener { _ ->
            val text = jTextField.text
            if (text.isBlank()) return@addActionListener
            val owner = JFrameUtil.getOwner(it)
            val toast = Toast.makeText(
                owner = owner,
                text = jTextField.text,
                duration = Toast.LENGTH_SHORT,
                background = Color.GREEN,
                gravity = gravity
            )
            toast.offsetX = offsetX
            toast.offsetY = offsetY
            toast.show()
        }
    }

    init {
        addComponent(
            component = jTextField,
            gridx = 0,
            gridy = 0,
            fill = GridBagConstraints.HORIZONTAL,
            weightx = 1.0,
        )
        addComponent(
            component = jButton,
            gridx = 1,
            gridy = 0,
            anchor = GridBagConstraints.EAST,
        )
        addComponent(
            component = gravityButtonPanel,
            gridx = 0,
            gridy = 1,
            gridwidth = 2,
            fill = GridBagConstraints.BOTH,
            weightx = 1.0,
            weighty = 0.5,
        )
        addComponent(
            component = offsetFieldPanel,
            gridx = 0,
            gridy = 2,
            gridwidth = 2,
            fill = GridBagConstraints.HORIZONTAL,
            weightx = 1.0,
        )
        addComponent(
            component = Box.createVerticalStrut(jTextField.preferredSize.height * 2),
            gridx = 0,
            gridy = 3,
            fill = GridBagConstraints.VERTICAL,
            weighty = 0.5,
        )
    }

    companion object {
        private const val serialVersionUID: Long = 8120392201331623866L
    }

}