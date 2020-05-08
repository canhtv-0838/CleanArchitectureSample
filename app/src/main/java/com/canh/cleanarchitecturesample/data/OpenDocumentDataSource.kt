package com.canh.cleanarchitecturesample.data

import com.canh.cleanarchitecturesample.domain.Document

interface OpenDocumentDataSource {
    fun setOpenDocument(document: Document)
    fun getOpenDocument(): Document
}
