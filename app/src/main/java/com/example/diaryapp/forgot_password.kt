package com.example.diaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class forgot_password : AppCompatActivity() {
    private lateinit var forgotemail: EditText
    private lateinit var resetbtn: Button
    private lateinit var loginback: TextView
    private lateinit var signupback:TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        forgotemail = findViewById(R.id.forgotemail)
        resetbtn = findViewById(R.id.resetbtn)
        loginback = findViewById(R.id.loginback)
        signupback = findViewById(R.id.signupback)
        auth = FirebaseAuth.getInstance()
        loginback.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        signupback.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        resetbtn.setOnClickListener {
            resetpassword()
        }
    }

            private fun resetpassword() {
                val email = forgotemail.text.toString()
                if (email.isBlank()) {
                    Toast.makeText(
                        this@forgot_password,
                        "Please enter your email",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                    auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@forgot_password,
                                    "Email sent successfully to reset your password",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            } else {
                                Toast.makeText(
                                    this@forgot_password,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                }
            }