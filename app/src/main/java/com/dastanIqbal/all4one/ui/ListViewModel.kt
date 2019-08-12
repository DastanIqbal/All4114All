package com.dastanIqbal.all4one.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dastanIqbal.model.DataM
import com.dastanIqbal.network.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class ListViewModel(var repo: Repository) : ViewModel() {
    private val disposable = CompositeDisposable()

    val repoLiveData = MutableLiveData<List<DataM>>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<Boolean>()


    fun getData(): ListViewModel {
        loadingLiveData.postValue(true)
        disposable.add(
            repo.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<DataM>>() {
                    override fun onSuccess(t: List<DataM>) {
                        loadingLiveData.postValue(false)
                        errorLiveData.postValue(false)
                        repoLiveData.postValue(t)

                    }

                    override fun onError(e: Throwable) {
                        loadingLiveData.postValue(false)
                        errorLiveData.postValue(true)
                    }
                })
        )
        return this
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
