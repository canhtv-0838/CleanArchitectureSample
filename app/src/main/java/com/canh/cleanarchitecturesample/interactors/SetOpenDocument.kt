package com.canh.cleanarchitecturesample.interactors

import com.canh.cleanarchitecturesample.data.DocumentRepository
import com.canh.cleanarchitecturesample.domain.Document

class SetOpenDocument(private val documentRepository: DocumentRepository) {
    operator fun invoke(document: Document) = documentRepository.setOpenDocument(document)
}