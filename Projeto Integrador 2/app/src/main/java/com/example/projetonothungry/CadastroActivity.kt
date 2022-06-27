package com.example.projetonothungry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetonothungry.databinding.RegisterLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

class CadastroActivity : AppCompatActivity() {


    private lateinit var binding : RegisterLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RegisterLayoutBinding.inflate(layoutInflater)

        binding.buttonVoltar.setOnClickListener{

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        setContentView(binding.root)

    }
}