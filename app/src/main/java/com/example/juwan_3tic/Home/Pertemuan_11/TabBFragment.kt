package com.example.juwan_3tic.Home.Pertemuan_11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.juwan_3tic.R
import com.example.juwan_3tic.databinding.FragmentTabABinding
import com.example.juwan_3tic.databinding.FragmentTabBBinding

class TabBFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_b, container, false)
    }
}