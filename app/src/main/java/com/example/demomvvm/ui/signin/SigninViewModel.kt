package com.example.demomvvm.ui.signin

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.demomvvm.ui.BaseViewModel
import com.example.entity.UserEntity
import com.example.usecases.usecases.UserDBUseCase
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class SigninViewModel(private val userDBUseCase: UserDBUseCase, contextViewModel: Context) : BaseViewModel(contextViewModel) {
    private val subscriber = CompositeDisposable()
    val userDBLiveData = MutableLiveData<UserEntity>()

    fun insertUser(userEntity: UserEntity) {
            subscriber.add(
                Single.create(
                    SingleOnSubscribe<UserEntity> { emitter ->
                        emitter.onSuccess(this.userDBUseCase.insertUser(userEntity))
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
                        { user -> userDBLiveData.postValue(user) },
                        { error -> errorLiveData.value = error.message }
                    ))

    }

    fun subscriberClear() {
        subscriber.clear()
    }
}