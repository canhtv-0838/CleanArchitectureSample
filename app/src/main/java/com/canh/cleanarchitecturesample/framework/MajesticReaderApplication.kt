package com.canh.cleanarchitecturesample.framework

import android.app.Application
import com.canh.cleanarchitecturesample.data.BookmarkRepository
import com.canh.cleanarchitecturesample.data.DocumentRepository
import com.canh.cleanarchitecturesample.interactors.*

class MajesticReaderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val bookmarkRepository = BookmarkRepository(RoomBookmarkDataSource(this))
        val documentRepository = DocumentRepository(
            RoomDocumentDataSource(this),
            InMemoryOpenDocumentSource()
        )
    MajesticViewModelFactory.inject(
        this,
        Interactors(
            addBookmark = AddBookmark(bookmarkRepository),
            getBookmarks = GetBookmarks(bookmarkRepository),
            deleteBookmark = RemoveBookmark(bookmarkRepository),
            addDocument = AddDocument(documentRepository),
            getDocuments = GetDocuments(documentRepository),
            removeDocument = RemoveDocument(documentRepository),
            getOpenDocument = GetOpenDocument(documentRepository),
            setOpenDocument = SetOpenDocument(documentRepository)
        )
    )
    }
}