package com.example.demomvvm.ui.signin



import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import com.example.demomvvm.R
import com.example.demomvvm.ui.BaseActivity
import com.example.demomvvm.ui.BaseViewModel
import com.example.entity.UserEntity
import kotlinx.android.synthetic.main.activity_signin.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SigninActivity : BaseActivity() {



    companion object{
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, SigninActivity::class.java)
            return intent
        }
    }


    private val signinViewModel: SigninViewModel by viewModel(clazz = SigninViewModel::class)

    override fun getLayout(): Int {
        return  R.layout.activity_signin
    }

    override fun setUpView() {

        observerViewModel()

        signinViewModel.insertUser(UserEntity(0,"Gabriela","Soledad Montesinos"))

    }

    private fun observerViewModel(){
        signinViewModel.userDBLiveData.observe(this, Observer { user -> dataUser(user) })
    }

    private fun dataUser(user : UserEntity){
        txtname.text = user.username
        txtfullname.text = user.fullname

    }

    override fun getViewModel(): BaseViewModel? {
       return signinViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        signinViewModel.subscriberClear()
    }

}
