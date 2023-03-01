package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("ranaPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        saveBtn.setOnClickListener{

            val name = name_Et.text.toString()
            val age = age_Et.text.toString().toInt()
            val isAdult = checkBox.isChecked

            editor.apply{
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        loadBtn.setOnClickListener{
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            name_Et.setText(name)
            age_Et.setText(age.toString())
            checkBox.isChecked = isAdult
        }
    }
}