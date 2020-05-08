package com.canh.cleanarchitecturesample.data

import com.canh.cleanarchitecturesample.domain.Document

interface DocumentDataSource {
    suspend fun add(document: Document)
    suspend fun readAll(): List<Document>
    suspend fun remove(document: Document)
}
