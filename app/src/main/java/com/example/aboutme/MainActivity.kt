package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.view.inputmethod.InputMethodManager
import android.content.Context
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("lalugue")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //set value of myName variable in layout file
        binding.myName = myName

        Log.d("BINDING","binding is the following: ")
        Log.d("BINDING", binding.toString())

        //set listener of button
        //variable names of components are changed into camel case upon data binding
        binding.doneButton.setOnClickListener{
            addNickname(it) //it as "self"
        }

    }

    private fun addNickname(view: View){

        //find nickname_edit component
        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //find nickname_text component
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {

            //myName?.nickname = nicknameEdit.text.toString()

            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()

            nicknameText.text = nicknameEdit.text.toString()

            //hide editText
            nicknameEdit.visibility = View.GONE
            //hide button
            doneButton.visibility = View.GONE
            //make nickname appear
            nicknameText.visibility = View.VISIBLE

        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


}
