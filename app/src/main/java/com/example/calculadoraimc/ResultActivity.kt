package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Recuperando o resultado passado pela MainActivity
        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.0f)

        // Exibindo o resultado na tela
        tvResult.text = result.toString()

        // Classificando o resultado
        val classificacao = if (result < 18.5f) {
            "Abaixo do peso"
        } else if (result in 18.5f..24.9f) {
            "Peso normal"
        } else if (result in 25.0f..29.9f) {
            "Sobrepeso"
        } else if (result in 30.0f..39.9f) {
            "Obesidade Grau I"
        } else {
            "Obesidade Grau II"
        }

        // Exibindo a classificação na tela
        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}