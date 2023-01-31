package com.example.aboutme


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Pulkit Malhotra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.done.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View) {

        binding.apply {
            myName?.nickname = editText.text.toString()
//            binding.nameText.text = binding.editText.text
            // Invalidate all binding expressions and request a new rebind to refresh UI

            invalidateAll()
            binding.editText.visibility = View.GONE
            view.visibility = View.GONE
            binding.nameText.visibility = View.VISIBLE
        }
        // Hide the keyboard.
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}