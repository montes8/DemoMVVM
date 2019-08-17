package com.example.demomvvm.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.demomvvm.ui.BaseViewModel
import com.example.entity.ProductEntity
import com.example.usecases.usecases.ProductUseCase
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ProductViewModel(private val productUseCase: ProductUseCase, contextViewModel: Context) : BaseViewModel(contextViewModel) {
    private val subscriber = CompositeDisposable()
    val productLiveData = MutableLiveData<ArrayList<ProductEntity>>()

    fun getProduct() {
        if (validateInternet()) {
            subscriber.add(
                Single.create(
                    SingleOnSubscribe<ArrayList<ProductEntity>> { emitter ->
                        emitter.onSuccess(this.productUseCase.getProduct())
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        loadingLiveData.value = true
                    }
                    .doFinally {
                        loadingLiveData.value = false
                    }
                    .subscribe(
                        { product -> productLiveData.postValue(product) },
                        { error -> errorLiveData.value = error.message }
                    ))
        }
    }

    fun subscriberClear() {
        subscriber.clear()
    }
}