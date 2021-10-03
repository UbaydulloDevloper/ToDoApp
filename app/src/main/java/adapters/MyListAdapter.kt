package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import classs.date
import com.example.todoapp.R
import kotlinx.android.synthetic.main.item_child_menu.view.*
import kotlinx.android.synthetic.main.todolist_item.view.*

class MyListAdapter(var titileList: List<String>,val map: HashMap<String,ArrayList<String>>):BaseExpandableListAdapter(){
    override fun getGroupCount(): Int = titileList.size

    override fun getChildrenCount(p0: Int): Int =map[titileList[p0]]!!.size

    override fun getGroup(p0: Int): Any  = titileList[p0]

    override fun getChild(p0: Int, p1: Int): Any  = map[titileList[p0]]!![p1]

    override fun getGroupId(p0: Int): Long  = p0.toLong()

    override fun getChildId(p0: Int, p1: Int): Long  = p1.toLong()

    override fun hasStableIds(): Boolean =true

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val item_grup: View =
            p2 ?: LayoutInflater.from(p3?.context).inflate(R.layout.todolist_item, p3, false)
        item_grup.txt_item_todo.text =titileList[p0]

        return item_grup

    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val item_child: View =
            p3 ?: LayoutInflater.from(p4?.context).inflate(R.layout.item_child_menu, p4, false)
        item_child.txt_child_item.text = map[titileList[p0]]!![p1]

        return item_child
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean = true
}