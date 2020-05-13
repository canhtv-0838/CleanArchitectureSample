package com.canh.cleanarchitecturesample.framework

import android.content.Context
import com.canh.cleanarchitecturesample.data.DocumentDataSource
import com.canh.cleanarchitecturesample.domain.Document
import com.canh.cleanarchitecturesample.framework.db.DocumentEntity
import com.canh.cleanarchitecturesample.framework.db.MajesticReaderDatabase

class RoomDocumentDataSource(val context: Context) : DocumentDataSource {
    private val documentDao = MajesticReaderDatabase.getInstance(context).documentDao()
    override suspend fun add(document: Document) {
        val details = FileUtil.getDocumentDetails(context, document.url)
        return documentDao.addDocument(
            DocumentEntity(document.url, details.name, details.size, details.thumbnail)
        )
    }

    override suspend fun readAll(): List<Document> {
        return documentDao.getDocuments().map {
            Document(
                it.uri,
                it.title,
                it.size,
                it.thumbnailUri
            )
        }
    }

    override suspend fun remove(document: Document) {
        return documentDao.removeDocument(
            DocumentEntity(document.url, document.name, document.size, document.thumbnail)
        )
    }

}