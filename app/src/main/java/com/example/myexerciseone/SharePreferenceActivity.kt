package com.example.myexerciseone

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class SharePreferenceActivity : AppCompatActivity() {

    lateinit var txtMyName: EditText
    lateinit var btnWrite: Button
    lateinit var btnRead: Button
    lateinit var btnClear: Button
    lateinit var lblShowMe: TextView

    lateinit var lblFileData: TextView
    lateinit var btnFileWrite: Button
    lateinit var btnFileRead: Button
    lateinit var txtFileData: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_share_preference)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        txtMyName = findViewById(R.id.txtMyName)
        btnRead = findViewById(R.id.btnRead)
        btnWrite = findViewById(R.id.btnWrite)
        btnClear = findViewById(R.id.btnClear)
        lblShowMe = findViewById(R.id.lblShowMe)

        var sharePreference = getSharedPreferences("myName",Context.MODE_PRIVATE)

        btnWrite.setOnClickListener(View.OnClickListener { v ->
            var editor = sharePreference.edit()
            editor.putString("name",txtMyName.text.toString())
            editor.commit()
        })
        btnRead.setOnClickListener(View.OnClickListener { v ->
            var name = sharePreference.getString("name","No Value")
            lblShowMe.text = name;
        })
        btnClear.setOnClickListener(View.OnClickListener { v ->
            var editor = sharePreference.edit()
            editor.remove("name")
            editor.commit()
        })

        txtFileData = findViewById(R.id.txtFileData)
        btnFileWrite = findViewById(R.id.btnFileWrite)
        btnFileRead = findViewById(R.id.btnFileRead)
        lblFileData = findViewById(R.id.lblFileData)

        btnFileWrite.setOnClickListener(View.OnClickListener { v->
            baseContext.openFileOutput("myFile.txt", Context.MODE_PRIVATE).use {
                it.write(txtFileData.text.toString().toByteArray())
            }
        })

        btnFileRead.setOnClickListener (View.OnClickListener { v ->
            val file = File(baseContext.filesDir,"myFile.txt")
            lblFileData.text = file.readText()
            Log.i("myApp", file.absolutePath)
        })

    }


}