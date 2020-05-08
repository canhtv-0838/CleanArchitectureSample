package com.canh.cleanarchitecturesample.framework

import com.canh.cleanarchitecturesample.data.OpenDocumentDataSource
import com.canh.cleanarchitecturesample.domain.Document

class InMemoryOpenDocumentSource : OpenDocumentDataSource {
    private var openDocument: Document = Document.EMPTY
    override fun setOpenDocument(document: Document) {
        openDocument = document
    }

    override fun getOpenDocument() = openDocument
}
