package com.canh.cleanarchitecturesample.interactors

import com.canh.cleanarchitecturesample.data.DocumentRepository
import com.canh.cleanarchitecturesample.domain.Document

class AddDocument(private val documentRepository: DocumentRepository) {
    suspend operator fun invoke(document: Document) = documentRepository.addDocument(document)
}