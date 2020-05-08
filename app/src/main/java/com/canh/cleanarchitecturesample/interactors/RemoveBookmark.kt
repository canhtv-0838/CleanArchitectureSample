package com.canh.cleanarchitecturesample.interactors

import com.canh.cleanarchitecturesample.data.BookmarkRepository
import com.canh.cleanarchitecturesample.domain.Bookmark
import com.canh.cleanarchitecturesample.domain.Document

class RemoveBookmark(private val bookmarkRepository: BookmarkRepository) {
    suspend operator fun invoke(document: Document, bookmark: Bookmark) =
        bookmarkRepository.removeBookmark(document, bookmark)
}