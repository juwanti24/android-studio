package com.example.juwan_3tic.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.juwan_3tic.Home.Pertemuan5.LimaActivity
import com.example.juwan_3tic.Home.Pertemuan9.NinthActivity
import com.example.juwan_3tic.LoginActivity
import com.example.juwan_3tic.R
import com.example.juwan_3tic.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nama=requireActivity().intent.getStringExtra("nama")
        val umur=requireActivity().intent.getIntExtra("umur",0)

        Log.w("hasil","Nama: $nama umur: $umur")
        binding.btnKembali.setOnClickListener {
//            val intent= Intent(this@MainActivity, LoginActivity::class.java)
//            startActivity(intent)
            requireActivity().finish()
        }

        binding.idusername.setText(nama)
//        binding.idusername.text=nama

        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("batal"){
                    val intent= Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }

        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireActivity())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    val intent= Intent(requireContext(), LimaActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("Batal") { dialog, _ ->

                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()


        }
        binding.btnLima.setOnClickListener {

            val intent= Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)


        }
        binding.btntonine.setOnClickListener {

            val intent= Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)


        }
        super.onViewCreated(view, savedInstanceState)
    }


    }
