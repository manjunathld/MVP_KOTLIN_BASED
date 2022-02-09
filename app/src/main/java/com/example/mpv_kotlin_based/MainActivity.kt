package com.example.mpv_kotlin_based

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mpv_kotlin_based.model.CountriesService
import com.example.mpv_kotlin_based.model.CountryModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var mCompositeDisposable: CompositeDisposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCompositeDisposable = CompositeDisposable()

        mCompositeDisposable.add(CountriesService().getCountries()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onResponse, this::onError))
    }

    private fun onResponse(countryModelList: List<CountryModel>) {
        for (index in 0..(countryModelList.size - 1)) {
            Log.d("Req Success", ""+countryModelList[index].countryID)
        }
    }

    private fun onError(error: Throwable) {
        Log.d("Req Fail", ""+error.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::mCompositeDisposable.isInitialized) {
            mCompositeDisposable.clear()
        }
    }

}