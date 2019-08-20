package com.example.demomvvm.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.R

import com.example.entity.ProductEntity
import kotlinx.android.synthetic.main.molde_item_product.view.*

class ListaProductoAdapter(var onClick: ((ProductEntity) -> Unit)? = null) : RecyclerView.Adapter<ListaProductoAdapter.ProductoViewHolder>() {

    private var productos : List<ProductEntity>? = null

    fun addList(productos : List<ProductEntity>){
        this.productos = productos

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_item_product,parent,false)
        return ProductoViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(productos){return 0}
        return checkedUser.size
    }


    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos!![position]

        holder.nombreProducto.text = producto.nombre
        holder.precioproducto.text = "$/ "+producto.precio.toString()
        holder.itemView.setOnClickListener {
            onClick?.invoke(producto)
        }

    }

    class ProductoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val nombreProducto = itemView.nomdre_producto
        val precioproducto = itemView.precio_producto



    }

}