package com.canh.cleanarchitecturesample.presentation.library

import android.app.Application
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.canh.cleanarchitecturesample.domain.Document
import com.canh.cleanarchitecturesample.framework.Interactors
import com.canh.cleanarchitecturesample.framework.MajesticViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LibraryViewModel(application: Application, interactors: Interactors) :
    MajesticViewModel(application, interactors) {
    val documents: MutableLiveData<List<Document>> = MutableLiveData()

    fun loadDocuments() {
        GlobalScope.launch {
            documents.postValue(interactors.getDocuments())
        }
    }

    fun addDocument(uri: Uri) {
        GlobalScope.launch {
            with(Dispatchers.IO) {
                interactors.addDocument(Document(uri.toString(), "", 0, ""))
            }
            loadDocuments()
        }
    }

    fun setOpenDocument(document: Document) {
        interactors.setOpenDocument(document)
    }
}