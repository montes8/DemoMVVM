package com.example.demomvvm.ui



import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvm.util.AppUtils


open class BaseViewModel (val context: Context) : ViewModel() {
    val loadingLiveData = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<String>()
    val attachInternet = MutableLiveData<Boolean>()

    fun validateInternet(): Boolean {
        if (AppUtils.isConnected(context)) {
            return true
        }
        attachInternet.postValue(false)
        return false
    }
}