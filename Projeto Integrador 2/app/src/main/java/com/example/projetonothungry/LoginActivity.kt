package com.example.projetonothungry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.widget.Toast
import com.example.projetonothungry.databinding.LoginLayoutBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginLayoutBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.buttonEntrar.setOnClickListener {
            val email = binding.editEmailLogin.text.toString()
            val senha = binding.editSenhaLogin.text.toString()
            loginUser(email, senha)

        }

        binding.textButtonCadastraSe.setOnClickListener {

            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)

        }

    }

    fun loginUser(email: String, senha: String) {

        if (email.isEmpty() ||
                senha.isEmpty()) {
            Toast.makeText(this, "Prencha os campos!", Toast.LENGTH_SHORT).show()
        } else {
            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Email ou senha inválida", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}