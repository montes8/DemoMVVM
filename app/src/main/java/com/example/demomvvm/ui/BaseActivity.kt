package com.example.demomvvm.ui

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.demomvvm.R
import com.example.demomvvm.util.AppUtils


abstract class BaseActivity : AppCompatActivity() {

    private var mViewModel: BaseViewModel? = null
    abstract fun getLayout(): Int
    abstract fun setUpView()
    abstract fun getViewModel(): BaseViewModel?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mViewModel = getViewModel()
        observeCommons()
        this.setUpView()
    }

    private fun observeCommons() {
        if (mViewModel != null) {
            mViewModel!!.loadingLiveData.observe(this, Observer { isLoading -> showLoading(isLoading!!) })
            mViewModel!!.attachInternet.observe(this, Observer { isConnect -> errorConnect(isConnect!!) })
            mViewModel!!.errorLiveData.observe(this, Observer { error -> errorMessage(error!!) })
        }
    }

    private fun showLoading(isLoading: Boolean) {
  /*      if (mProgressBar != null)
            if (isLoading) mProgressBar!!.show() else mProgressBar!!.dismiss()*/
    }

    private fun errorConnect(connect : Boolean){
        if (!connect){
            val viewGroup = (this.findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
            AppUtils.showErrorMessage(viewGroup, this, resources.getString(R.string.error))
        }
    }

    private fun errorMessage(string: String){
        val viewGroup = (this.findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
        AppUtils.showErrorMessage(viewGroup, this, string)
    }



}