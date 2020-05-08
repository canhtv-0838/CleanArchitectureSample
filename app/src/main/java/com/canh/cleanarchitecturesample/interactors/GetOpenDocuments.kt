package com.canh.cleanarchitecturesample.interactors

import com.canh.cleanarchitecturesample.data.DocumentRepository

class GetOpenDocuments(private val openDocumentRepository: DocumentRepository) {
    operator fun invoke() = openDocumentRepository.getOpenDocument()
}