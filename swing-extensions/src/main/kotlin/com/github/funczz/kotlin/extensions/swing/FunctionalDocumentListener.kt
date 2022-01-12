package com.github.funczz.kotlin.extensions.swing

import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.text.Document

open class FunctionalDocumentListener constructor(
    private val onInsertUpdate: (DocumentEvent) -> Unit,
    private val onRemoveUpdate: (DocumentEvent) -> Unit,
    private val onChangedUpdate: (DocumentEvent) -> Unit,
) : DocumentListener {

    constructor(f: (DocumentEvent) -> Unit) : this(f, f, f)

    override fun insertUpdate(e: DocumentEvent) {
        onInsertUpdate(e)
    }

    override fun removeUpdate(e: DocumentEvent) {
        onRemoveUpdate(e)
    }

    override fun changedUpdate(e: DocumentEvent) {
        onChangedUpdate(e)
    }

}

fun Document.addFunctionalDocumentListener(
    onInsertUpdate: (DocumentEvent) -> Unit,
    onRemoveUpdate: (DocumentEvent) -> Unit,
    onChangedUpdate: (DocumentEvent) -> Unit,
) {
    addDocumentListener(
        FunctionalDocumentListener(onInsertUpdate, onRemoveUpdate, onChangedUpdate)
    )
}

fun Document.addFunctionalDocumentListener(
    f: (DocumentEvent) -> Unit,
) {
    addDocumentListener(FunctionalDocumentListener(f))
}