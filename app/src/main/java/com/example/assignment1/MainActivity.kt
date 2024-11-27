package com.example.assignment1

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etName = findViewById<EditText>(R.id.etName)
        val etContact = findViewById<EditText>(R.id.etContact)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val contact = etContact.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val address = etAddress.text.toString().trim()

            when {
                TextUtils.isEmpty(name) -> etName.error = "Name is required"
                TextUtils.isEmpty(contact) -> etContact.error = "Contact number is required"
                contact.length != 10 -> etContact.error = "Contact must be 10 digits"
                TextUtils.isEmpty(email) -> etEmail.error = "Email is required"
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                    etEmail.error = "Enter a valid email"
                TextUtils.isEmpty(password) -> etPassword.error = "Password is required"
                TextUtils.isEmpty(address) -> etAddress.error = "Address is required"
                else -> {
                    Toast.makeText(this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

