package com.example.fruitsandvegetables

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import okhttp3.internal.notifyAll
import java.security.AccessController.getContext
import kotlin.collections.ArrayList


class BlogRecyclerAdapter(val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG: String = "AppDebug"

    private var items: List<Receipt> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is BlogViewHolder -> {
                holder.bind(items.get(position),itemClickListener)
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<Receipt>){
        items = blogList

    }


    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val name =itemView.findViewById<TextView>(R.id.name)
        val price = itemView.findViewById<TextView>(R.id.price)
        val quantity = itemView.findViewById<TextView>(R.id.quantity)
        val total= itemView.findViewById<TextView>(R.id.total)

        fun bind(receipt: Receipt,clickListener: OnItemClickListener){
            name.setText(receipt.fruitsName)
            price.setText(receipt.fruitsPrice)
            quantity.setText(receipt.quantity)
            total.setText(receipt.totalPrice)

            itemView.setOnClickListener {
                clickListener.onItemClicked(receipt)
            }

        }

    }

}

interface OnItemClickListener{
    fun onItemClicked(receipt: Receipt)
}
