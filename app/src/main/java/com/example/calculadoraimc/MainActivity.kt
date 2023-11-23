package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperando os componentes da tela
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edtPeso)
        val edtAltura: EditText = findViewById(R.id.edtAltura)

        // Adicionando um evento de click no botão
        btnCalcular.setOnClickListener {
            val alturaStr: String = edtAltura.text.toString()
            val pesoStr: String = edtPeso.text.toString()

            // Verificando se os campos foram preenchidos
            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()
                val result: Float = peso / (altura * altura)

                // Criando uma intent para abrir a tela de resultado
                val intent = Intent(this, ResultActivity::class.java)
                    // Passando o resultado para a tela de resultado
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                // Exibindo uma mensagem de erro
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}