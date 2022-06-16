package com.example.spinner1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val languages = resources.getStringArray(R.array.Languages)
        val os=resources.getStringArray(R.array.os)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner3=findViewById<Spinner>(R.id.spinner3)



        if (spinner != null && spinner3!=null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, os)
            spinner.adapter = adapter
            spinner3.adapter = adapter2
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    spinner3.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View, position: Int, id: Long
                        ) {
                            val toast1 = Toast.makeText(
                                this@MainActivity,
                                getString(R.string.selected_item) + " " + languages[position] + "  " + getString(
                                    R.string.selected_os
                                ) + " " +
                                        "" + os[position], Toast.LENGTH_LONG
                            )
                            toast1.show()
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }

    }
}