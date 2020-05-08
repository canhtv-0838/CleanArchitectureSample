package com.canh.cleanarchitecturesample.framework

import android.content.Context
import com.canh.cleanarchitecturesample.data.BookmarkDataSource
import com.canh.cleanarchitecturesample.domain.Bookmark
import com.canh.cleanarchitecturesample.domain.Document
import com.canh.cleanarchitecturesample.framework.db.BookmarkEntity
import com.canh.cleanarchitecturesample.framework.db.MajesticReaderDatabase

class RoomBookmarkDataSource(context: Context) : BookmarkDataSource {
    private val bookmarkDao = MajesticReaderDatabase.getInstance(context).bookmarkDao()

    override suspend fun add(document: Document, bookmark: Bookmark) {
        bookmarkDao.addBookmark(
            BookmarkEntity(
                documentUri = document.url,
                page = bookmark.page
            )
        )
    }

    override suspend fun read(document: Document): List<Bookmark> {
        return bookmarkDao.getBookmarks(document.url).map { Bookmark(it.id, it.page) }
    }

    override suspend fun remove(document: Document, bookmark: Bookmark) {
        bookmarkDao.removeBookmark(
            BookmarkEntity(id = bookmark.id, documentUri = document.url, page = bookmark.page)
        )
    }

}