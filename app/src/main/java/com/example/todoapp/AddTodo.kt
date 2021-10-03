package com.example.todoapp

import Cache.MyShafePreferens
import adapters.DateLevel
import adapters.MyAdapterSpiner
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import classs.date
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodo : AppCompatActivity() {
    private lateinit var mySpinnerAdapter: MyAdapterSpiner
    lateinit var list: ArrayList<DateLevel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        levelLode()

        MyShafePreferens.init(this)

        mySpinnerAdapter = MyAdapterSpiner(list)
        spinner_level.adapter = mySpinnerAdapter



        add_list.setOnClickListener {
            val name = todo_name.text.toString().trim()
            val description = description.text.toString().trim()
            val create_date = create_date.text.toString().trim()
            val dedline = dedline.text.toString().trim()

            val degree = list[spinner_level.selectedItemPosition]

            if (name != "" && description != "" && create_date != "" && dedline != "") {

                val arrayList = MyShafePreferens.objectsString

                arrayList.add(date(name, description, create_date, dedline, degree, "open"))

                MyShafePreferens.objectsString = arrayList

                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Ma'lumotlar yetarli emas!!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun levelLode() {
        list = ArrayList()

        list.add(DateLevel("Urgent", R.drawable.flag_qizil))
        list.add(DateLevel("High", R.drawable.flag_sariq))
        list.add(DateLevel("Normal", R.drawable.flag_kok))
        list.add(DateLevel("Low", R.drawable.flag_kulrang))

    }
}