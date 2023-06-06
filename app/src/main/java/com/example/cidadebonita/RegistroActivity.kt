package com.example.cidadebonita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cidadebonita.databinding.ActivityRegistroBinding
import com.example.empregaeu4.RegistrarUsuario
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegistroBinding
    private  lateinit var dbRef : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btRegistro = binding.btCadResgistro
        var edNomeRegistro = binding.edNomeRegistro
        var edPassRegistro = binding.edPassRegistro
        var edEmailRegistro = binding.edEmailRegistro

        dbRef = FirebaseDatabase.getInstance().getReference("usuario")

        btRegistro.setOnClickListener {

            val empNome = edNomeRegistro.text.toString()
            val empSenha = edPassRegistro.text.toString()
            val empEmail = edEmailRegistro.text.toString()
            val empId = dbRef.push().key!!

            if(empNome.isEmpty()){
                edNomeRegistro.error = "insira um nome"
            }

            if(empSenha.isEmpty()){
                edNomeRegistro.error = "insira uma senha"
            }

            if(empEmail.isEmpty()){
                edNomeRegistro.error = "insira um email"
            }

            val usuario = RegistrarUsuario(empId, empNome, empSenha, empEmail)

            dbRef.child(empId).setValue(usuario).addOnCompleteListener{
                Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                edNomeRegistro.text.clear()
                edEmailRegistro.text.clear()
                edPassRegistro.text.clear()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
            }

            val inten = Intent(this, Tela2Activity::class.java)
            startActivity(inten)


        }
    }
}