package com.example.carrinho

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.carrinho.data.Catalogo
import com.example.carrinho.domain.gerarRelatorio
import com.example.carrinho.ui.CarrinhoScreen

private const val TAG = "CARRINHO"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MaterialTheme {
                var incluirExtras by remember { mutableStateOf(false) }
                val itens = if (incluirExtras) Catalogo.carrinhoCompleto else Catalogo.carrinhoValidacao

                LaunchedEffect(itens) {
                    gerarRelatorio(itens).forEach { Log.d(TAG, it) }
                }

                CarrinhoScreen(
                    itens = itens,
                    incluirExtras = incluirExtras,
                    onIncluirExtrasChange = { incluirExtras = it }
                )
            }
        }
    }
}
