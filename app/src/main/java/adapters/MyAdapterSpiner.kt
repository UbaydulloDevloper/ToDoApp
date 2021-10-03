package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.todoapp.R
import kotlinx.android.synthetic.main.item_spinner.view.*
import java.util.logging.Level

class MyAdapterSpiner(val list: List<DateLevel>):BaseAdapter(){
    override fun getCount(): Int= list.size

    override fun getItem(p0: Int): Any  = list[p0]
    override fun getItemId(p0: Int): Long =  p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val itemView:View

        if (p1==null){
            itemView = LayoutInflater.from(p2?.context).inflate(R.layout.item_spinner,p2 ,false)
        }else{
            itemView = p1
        }

        itemView.imageView_level.setImageResource(list[p0].image)
        itemView.text_level.text = list[p0].name

        return itemView
    }
}