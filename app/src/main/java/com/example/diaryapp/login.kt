package com.example.diaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: TextInputEditText
    private lateinit var signup: TextView
    private lateinit var login: Button
    private lateinit var resetpassword: TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        email = findViewById(R.id.emailText)
        password = findViewById(R.id.passwordbutton)
        signup = findViewById(R.id.signuptext)
        login = findViewById(R.id.loginbtn)
        resetpassword = findViewById(R.id.resetpassword)
        signup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        resetpassword.setOnClickListener {
            val intent = Intent(this, forgot_password::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            loginUser()
        }

    }

    private fun loginUser() {
        val emailid = email.text.toString()
        val pass = password.text.toString()
        if (emailid.isBlank()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass.isBlank()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT)
                .show()
            return
        }
        auth.signInWithEmailAndPassword(emailid, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val intent = Intent(this@Login, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@Login,
                    it.exception!!.message.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
