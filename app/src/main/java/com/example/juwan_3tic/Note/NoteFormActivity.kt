package com.example.my_apps.Note

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.juwan_3tic.Data.AppDatabase
import com.example.juwan_3tic.Data.Entity.NoteEntity
import com.example.juwan_3tic.databinding.ActivityNoteFormBinding
import com.example.my_apps.data.AppDatabase
import com.example.my_apps.data.entity.NoteEntity
import com.example.my_apps.databinding.ActivityNoteFormBinding
import kotlinx.coroutines.launch

class NoteFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.btnSaveNote.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()

            if (title.isBlank() || content.isBlank()) {
                Toast.makeText(
                    this, "Isi semua kolom!", Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            binding.btnSaveNote.isEnabled = false
            lifecycleScope.launch {
                try {
                    db.noteDao().insert(
                        NoteEntity(title = title, content = content)
                    )
                    finish()
                } catch (e: Exception) {
                    binding.btnSaveNote.isEnabled = true
                    Toast.makeText(
                        this@NoteFormActivity,
                        "Gagal menyimpan catatan",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}