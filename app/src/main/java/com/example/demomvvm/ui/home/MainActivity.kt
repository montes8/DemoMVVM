package com.example.demomvvm.ui.home


import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demomvvm.R
import com.example.demomvvm.ui.BaseActivity
import com.example.demomvvm.ui.BaseViewModel
import com.example.entity.ProductEntity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {



    private val productViewModel: ProductViewModel by viewModel(clazz = ProductViewModel::class)

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun setUpView() {


        productViewModel.getProduct()


        productViewModel.productLiveData.observe(this, Observer { product -> getProduct(product) })
    }


    private fun getProduct(productModel: ArrayList<ProductEntity>) {
        val productoAdapter = ListaProductoAdapter()
        my_recyclerview.layoutManager = LinearLayoutManager(this)
        my_recyclerview.adapter = productoAdapter
        productoAdapter.addList(productModel)


    }
    override fun getViewModel(): BaseViewModel? {
        return productViewModel
    }

}
