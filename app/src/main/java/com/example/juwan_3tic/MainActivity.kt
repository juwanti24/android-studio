package com.example.juwan_3tic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.juwan_3tic.Pertemuan5.LimaActivity
import com.example.juwan_3tic.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nama=intent.getStringExtra("nama")
        val umur=intent.getIntExtra("umur",0)

        Log.w("hasil","Nama: $nama umur: $umur")
        binding.btnKembali.setOnClickListener {
//            val intent= Intent(this@MainActivity, LoginActivity::class.java)
//            startActivity(intent)
            finish()
        }

        binding.idusername.setText(nama)
//        binding.idusername.text=nama

        binding.btnSnackBar.setOnClickListener {
        Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
            .setAction("Tampilan"){
                val intent= Intent(this@MainActivity, LoginActivity::class.java)
                  startActivity(intent)
                Log.e("Info Snackbar","Snackbar ditutup")
            }
            .show()
        }

        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    val intent= Intent(this@MainActivity, LimaActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("Batal") { dialog, _ ->

                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()


        }
        binding.btnLima.setOnClickListener {

                    val intent= Intent(this@MainActivity, LimaActivity::class.java)
                    startActivity(intent)


        }

    }
}