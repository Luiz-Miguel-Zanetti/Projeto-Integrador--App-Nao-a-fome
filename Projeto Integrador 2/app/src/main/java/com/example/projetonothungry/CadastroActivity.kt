package com.example.projetonothungry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetonothungry.databinding.RegisterLayoutBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

class CadastroActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var binding: RegisterLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RegisterLayoutBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()

        binding.buttonCadastrar.setOnClickListener {
            val email = binding.editEmailRegistro.text.toString()
            val senha = binding.editSenhaCadastro.text.toString()
            val confirmsenha = binding.editConfirmSenha.text.toString()

            cadastroUser(email, senha, confirmsenha)

        }

        binding.buttonVoltar.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        setContentView(binding.root)

    }


    fun cadastroUser(email: String, senha: String, confirmsenha: String) {

        val intent = Intent(this, LoginActivity::class.java)
        if (email.isNotEmpty() &&
            senha.isNotEmpty() &&
            confirmsenha.isNotEmpty()
        ) {
            if (senha == confirmsenha) {
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(
                            this, "Cadastro efetuado com sucesso!",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            it.exception.toString(), Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                Toast.makeText(this, "As senhas não são iguais!", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Prencha todos os campos!", Toast.LENGTH_LONG).show()
        }
    }
}