package com.canh.cleanarchitecturesample.interactors

import com.canh.cleanarchitecturesample.data.BookmarkRepository
import com.canh.cleanarchitecturesample.domain.Bookmark
import com.canh.cleanarchitecturesample.domain.Document

class AddBookmark(private val bookmarkRepository: BookmarkRepository) {
    suspend operator fun invoke(document: Document, bookmark: Bookmark) =
        bookmarkRepository.addBookmark(document, bookmark)
}