package com.example.todoapp

import Cache.MyShafePreferens
import adapters.MyListAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_to_dolist.*

class toDolist : AppCompatActivity() {
    lateinit var titlelist: ArrayList<String>
    lateinit var map: HashMap<String, ArrayList<String>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_dolist)

        MyShafePreferens.init(this)
        arrayga()

        expanded_menu.setOnChildClickListener { expandableListView, view, grup, child, l ->
            val intent = Intent(this, listAboute::class.java)
            intent.putExtra("key0", map[titlelist[grup]]?.get(child))
            startActivity(intent)
            true
        }

    }

    fun arrayga() {
        titlelist = ArrayList()
        map = HashMap()

        titlelist.add("Open")
        titlelist.add("Development")
        titlelist.add("Uploading")
        titlelist.add("Reject")
        titlelist.add("Closed")

        val arrayOpen = ArrayList<String>()
        val arrayDevelopment = ArrayList<String>()
        val arrayUploading = ArrayList<String>()
        val arrayReject = ArrayList<String>()
        val arrayClosed = ArrayList<String>()


        val list = MyShafePreferens.objectsString

        for (i in list) {

            if (i.sorting == "open") {
                arrayOpen.add(i.name)
            }
            if (i.sorting == "development") {
                arrayDevelopment.add(i.name)
            }
            if (i.sorting == "uploading") {
                arrayUploading.add(i.name)
            }
            if (i.sorting == "reject") {
                arrayReject.add(i.name)
            }
            if (i.sorting == "closed") {
                arrayClosed.add(i.name)
            }
        }
            map[titlelist[0]] = arrayOpen
            map[titlelist[1]] = arrayDevelopment
            map[titlelist[2]] = arrayUploading
            map[titlelist[3]] = arrayReject
            map[titlelist[4]] = arrayClosed

        }




    override fun onStart() {
        super.onStart()
        MyShafePreferens.init(this)
        arrayga()
        val spiner1 = MyListAdapter(titlelist, map)
        expanded_menu.setAdapter(spiner1)
    }
}

