package com.example.myexerciseone

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmFormActivity : AppCompatActivity() {

    lateinit var lblName: TextView
    lateinit var lblPhone: TextView
    lateinit var  lblEmail: TextView
    lateinit var lblStatus: TextView
    lateinit var lblTac: TextView
    lateinit var lblCountry: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm_form)


        lblName = findViewById(R.id.lblName) as TextView
        lblEmail = findViewById(R.id.lblEmail) as TextView
        lblPhone = findViewById(R.id.lblPhone) as TextView
        lblTac = findViewById(R.id.lblTac) as TextView
        lblStatus = findViewById(R.id.lblStatus) as TextView
        lblCountry = findViewById(R.id.lblCountry) as TextView


        val bundle: Bundle? = intent.extras
        var name: String? = bundle?.getString("NAME")
        var phone: String? = bundle?.getString("PHONE")
        var email: String? = bundle?.getString("EMAIL")
        var status: String? = bundle?.getString("STATUS")
        var tac: Boolean? = bundle?.getBoolean("TAC")
        var country: String? = bundle?.getString("COUNTRY")


        lblName.text = name
        lblPhone.text = phone
        lblEmail.text = email
        lblStatus.text = status
        lblTac.text = "$tac" // change string eg: tac.toString()
        lblCountry.text = country

        val btnexit = findViewById(R.id.btnexit) as Button
        btnexit.setOnClickListener(View.OnClickListener { v ->
            finish()
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnExit)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}