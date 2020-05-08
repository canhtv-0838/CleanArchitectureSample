package com.canh.cleanarchitecturesample.data

import com.canh.cleanarchitecturesample.domain.Bookmark
import com.canh.cleanarchitecturesample.domain.Document

interface BookmarkDataSource {
    suspend fun add(document: Document, bookmark: Bookmark)
    suspend fun read(document: Document): List<Bookmark>
    suspend fun remove(document: Document, bookmark: Bookmark)
}