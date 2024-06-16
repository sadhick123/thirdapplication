package com.sadhick.thirdapplication


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name: EditText?= null
    var number: EditText?= null
    var dob: EditText?= null
    var feildofstudy: EditText?= null
    var yes: RadioButton?= null
    var no: RadioButton?= null
    var btn:Button?=null
    var n=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        feildofstudy = findViewById(R.id.feildofstudy)
        dob = findViewById(R.id.dob)
        yes = findViewById(R.id.yes)
        no = findViewById(R.id.no)
        btn = findViewById(R.id.)

        btn?.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
            if (name?.text.toString().trim().isNullOrEmpty()) {
                name?.error = "Enter your name"
            } else if (number?.text.toString().trim().isNullOrEmpty()) {
                number?.error = "Enter your number"
            } else if ((number?.text?.trim()?.length ?: 0) < 10) {
                number?.error = "Number should be valid and should be of 10 digits"
            } else if (dob?.text?.toString()?.trim().isNullOrEmpty()) {
                dob?.error = "Enter your dob"
            } else if(feildofstudy?.text?.isNullOrBlank() == true && yes?.isChecked == true) {
                feildofstudy?.error = "Field of Study is Empty"
            }else {
                var a = 10
                var intent = Intent(this, ThirdActvity3::class.java)
                intent.putExtra("name", name?.text?.toString()?.trim())
                intent.putExtra("number", number?.text?.toString()?.trim())
                intent.putExtra("dob", dob?.text?.trim()?.toString()?.toInt())
                startActivity(intent)
            }
        }
        yes?.setOnClickListener {
            Toast.makeText(this, "Yes is clicked", Toast.LENGTH_SHORT).show()
        }
        no?.setOnClickListener {
            Toast.makeText(this, "No is clicked", Toast.LENGTH_SHORT).show()
        }

        yes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                n=true
                feildofstudy?.visibility = View.VISIBLE
            }else{
                n=false
                feildofstudy?.visibility = View.INVISIBLE
            }
        }
    }
}