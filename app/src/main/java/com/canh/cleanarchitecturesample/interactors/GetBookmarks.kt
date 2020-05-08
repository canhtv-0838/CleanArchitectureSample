package com.canh.cleanarchitecturesample.interactors

import com.canh.cleanarchitecturesample.data.BookmarkRepository
import com.canh.cleanarchitecturesample.domain.Document

class GetBookmarks(private val bookmarkRepository: BookmarkRepository) {
    suspend operator fun invoke(document: Document) = bookmarkRepository.getBookmarks(document)
}
