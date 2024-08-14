package com.example.myexerciseone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txtName: EditText
    lateinit var txtPhone: EditText
    lateinit var txtEmail: EditText
    lateinit var rdoGroup: RadioGroup
    lateinit var rbtnemploy: RadioButton
    lateinit var rbtnunemploy: RadioButton
    lateinit var rbtnstudent: RadioButton
    lateinit var chkTerms: CheckBox
    lateinit var spinner: Spinner
    lateinit var btnSave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtName = findViewById<EditText>(R.id.txtName)
        txtPhone = findViewById<EditText>(R.id.txtPhone)
        txtEmail = findViewById<EditText>(R.id.txtEmail)
        rdoGroup = findViewById<RadioGroup>(R.id.rdoGroup)
        rbtnemploy = findViewById<RadioButton>(R.id.rbtnemploy)
        rbtnunemploy = findViewById<RadioButton>(R.id.rbtnunemploy)
        rbtnstudent = findViewById<RadioButton>(R.id.rbtnstudent)
        chkTerms = findViewById<CheckBox>(R.id.chkTerms)
        spinner = findViewById<Spinner>(R.id.spinner)
        btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener(View.OnClickListener { v->

            val intent = Intent(this, ConfirmFormActivity::class.java)
            intent.putExtra("NAME", txtName.text.toString())
            intent.putExtra("PHONE", txtPhone.text.toString())
            intent.putExtra("EMAIL", txtEmail.text.toString())
            var status = rbtnemploy.toString()
            if(rbtnemploy.isChecked)
                status = rbtnemploy.text.toString()
            if(rbtnunemploy.isChecked)
                status = rbtnunemploy.text.toString()
            if(rbtnstudent.isChecked)
                status = rbtnstudent.text.toString()
            intent.putExtra("STATUS", status)
            intent.putExtra("TAC",chkTerms.isChecked)
            intent.putExtra("COUNTRY", spinner.selectedItem.toString())

            startActivity(intent)

            //Toast.makeText(baseContext, "Hello World", Toast.LENGTH_SHORT).show()

            // SnackBar
            //Snackbar.make(v, "I am snackbar", Snackbar.LENGTH_LONG)
            //    .setAction("Undo", View.OnClickListener { vChild->})
            //    .setActionTextColor(Color.WHITE)
            //    .show();

            // Alert Dialog
            //AlertDialog.Builder(this).setTitle("Confirm").setMessage("Are you sure?").show()


            //
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnExit)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    open fun saveButtonClickHandler(v:View){

    }
}