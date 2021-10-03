package com.example.todoapp

import Cache.MyShafePreferens
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import classs.date
import kotlinx.android.synthetic.main.activity_list_aboute.*

class listAboute : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_aboute)

        MyShafePreferens.init(this)
        val pisition = intent.getStringExtra("key0")

        val list = MyShafePreferens.objectsString
        var plan1 = date()
        var index = 0



        for (i in list) {
            if (i.name == pisition) {
                plan1 = i
                index = list.indexOf(i)
                description.text = i.name
                degree_image.setImageResource(i.degree!!.image)
                degree_text.text = i.degree?.name
                create_date.text = i.create_date
                dedline.text = i.dedline

                when (i.sorting) {
                    "open" -> open_radio.isChecked = true
                    "development" -> development_radio.isChecked = true
                    "uploading" -> uploading_radio.isChecked = true
                    "reject" -> reject_radio.isChecked = true
                    "closed" -> closed_radio.isChecked = true
                }
                break
            }
        }

        ok_list.setOnClickListener {
            var radioSelect = ""
            if (open_radio.isChecked) radioSelect = "open"
            if (development_radio.isChecked) radioSelect = "development"
            if (uploading_radio.isChecked) radioSelect = "uploading"
            if (reject_radio.isChecked) radioSelect = "reject"
            if (closed_radio.isChecked) radioSelect = "closed"

            plan1.sorting = radioSelect
            list[index] = plan1
            MyShafePreferens.objectsString = list
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}