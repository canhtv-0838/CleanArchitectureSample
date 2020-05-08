package com.canh.cleanarchitecturesample.interactors

import com.canh.cleanarchitecturesample.data.DocumentRepository
import com.canh.cleanarchitecturesample.domain.Document

class RemoveDocument(private val documentRepository: DocumentRepository) {
    suspend operator fun invoke(document: Document) = documentRepository.removeDocument(document)
}