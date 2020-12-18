package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var singUpEmailEditText: EditText
    private lateinit var signUpPasswordEditText: EditText
    private lateinit var registerButton: Button
    
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        singUpEmailEditText = findViewById(R.id.signUpEmailEditText)
        signUpPasswordEditText = findViewById(R.id.signInPasswordEditText)
        registerButton = findViewById(R.id.signUpButton)

        registerButton.setOnClickListener {
            val email = singUpEmailEditText.text.toString()
            val password = singUpEmailEditText.text.toString()


            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Empty",Toast.LENGTH_SHORT).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener {task ->
                            if(task.isSuccessful){
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }else{
                                Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show()
                            }

                }
            }
        }


    }
}