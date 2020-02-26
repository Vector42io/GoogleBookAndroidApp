package kg.flaterlab.book

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.my_book_item.view.*

class MyAdapter(private var myDataset: ArrayList<String>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {

        val linearLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_book_item, parent, false) as LinearLayout

        return MyViewHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.linearLayout.text_view.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size

    fun update (myd : ArrayList<String>){
        myDataset = myd
        notifyDataSetChanged()
    }
}
