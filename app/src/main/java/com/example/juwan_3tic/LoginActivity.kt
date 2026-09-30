package com.example.juwan_3tic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.juwan_3tic.databinding.ActivityLoginBinding
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val btnLogin : Button = findViewById(R.id.btnLogin)
//        val username : EditText = findViewById(R.id.editusername)
//        val pw : EditText = findViewById(R.id.editpw)

        binding.btnLogin.setOnClickListener {
            val user = binding.editusername.text.toString()
            val pass = binding.editpw.text.toString()

            val intent= Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("nama","Alamak")
            intent.putExtra("Umur",25)
            startActivity(intent)

            Log.d("Username",user)
            Log.d("password",pass)
            Toast.makeText(this, "username: $user Password: $pass", Toast.LENGTH_LONG).show()
        }


    }
}