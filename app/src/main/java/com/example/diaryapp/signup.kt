package com.example.diaryapp

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import android.os.Bundle

import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.google.android.material.textfield.TextInputEditText

class Signup : AppCompatActivity() {
    private lateinit var fullname: EditText
    private lateinit var email: EditText
    private lateinit var password: TextInputEditText
    private lateinit var confirmPassword: TextInputEditText
    private lateinit var signup: Button
    private lateinit var login: TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()
        fullname = findViewById(R.id.fullName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.passwordtext)
        confirmPassword = findViewById(R.id.confirmPasswordtext)
        signup = findViewById(R.id.signup)
        login = findViewById(R.id.login)
        login.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        signup.setOnClickListener {
            signupUser()
        }
      //  login.setOnClickListener {
       //     val intent = Intent(this, Login:class.java)
        //    startActivity(intent)
       // }
    }

    private fun signupUser() {
        val emailid = email.text.toString()
        val pass = password.text.toString()
        val confirmp = confirmPassword.text.toString()
        if (emailid.isBlank() || pass.isBlank() || confirmp.isBlank()) {
            Toast.makeText(this, "Email and Password can not be blank", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass != confirmp) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        auth.createUserWithEmailAndPassword(emailid, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val intent=Intent(this@Signup,MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@Signup,
                    it.exception!!.message.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
