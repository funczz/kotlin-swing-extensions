package com.github.funczz.kotlin.extensions.swing.event_extensions

import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.text.Document

open class FunctionalDocumentListener(
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

fun Document.addDocumentListener(
    onInsertUpdate: (DocumentEvent) -> Unit,
    onRemoveUpdate: (DocumentEvent) -> Unit,
    onChangedUpdate: (DocumentEvent) -> Unit,
) {
    addDocumentListener(
        FunctionalDocumentListener(onInsertUpdate, onRemoveUpdate, onChangedUpdate)
    )
}

fun Document.addDocumentListener(
    f: (DocumentEvent) -> Unit,
) {
    addDocumentListener(FunctionalDocumentListener(f))
}