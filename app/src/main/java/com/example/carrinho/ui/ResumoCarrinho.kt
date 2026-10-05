package com.example.carrinho.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResumoCarrinho(subtotal: String, descontos: String, total: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxWidth(), tonalElevation = 3.dp) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            LinhaResumo("Subtotal", subtotal, MaterialTheme.typography.bodyLarge)
            LinhaResumo("Descontos", "-$descontos", MaterialTheme.typography.bodyLarge)
            HorizontalDivider()
            LinhaResumo("TOTAL", total, MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
private fun LinhaResumo(rotulo: String, valor: String, estilo: androidx.compose.ui.text.TextStyle) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(rotulo, style = estilo)
        Text(valor, style = estilo)
    }
}
