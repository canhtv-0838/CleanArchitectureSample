package com.canh.cleanarchitecturesample.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class MajesticViewModel(application: Application, protected val interactors: Interactors) :
    AndroidViewModel(application) {
}