package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.view.inputmethod.InputMethodManager
import android.content.Context


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set listener of button
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it) //it as "self"
        }
    }

    private fun addNickname(view: View){

        //find nickname_edit component
        val editText = findViewById<EditText>(R.id.nickname_edit)
        //find nickname_text component
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //set value of nickname to text in editText
        nicknameTextView.text = editText.text
        //hide editText
        editText.visibility = View.GONE
        //hide button
        view.visibility = View.GONE
        //make nickname appear
        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


}
