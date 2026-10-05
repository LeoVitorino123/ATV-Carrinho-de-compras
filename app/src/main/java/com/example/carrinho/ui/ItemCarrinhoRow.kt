package com.example.carrinho.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/** Linha reutilizável: recebe TUDO por parâmetro (nenhum dado fixo de produto). */
@Composable
fun ItemCarrinhoRow(
    nome: String,
    descricao: String?,
    precoUnitario: String,
    quantidade: Int,
    totalBruto: String,
    totalFinal: String,
    descontoPercentual: Int,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = nome,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                if (descontoPercentual > 0) {
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "-$descontoPercentual%",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Text(
                text = descricao ?: "Sem descrição", // tratamento seguro de nulo (sem !!)
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text("$precoUnitario  x$quantidade", style = MaterialTheme.typography.bodyLarge)
                Column(horizontalAlignment = Alignment.End) {
                    if (descontoPercentual > 0) {
                        Text(
                            text = totalBruto,
                            style = MaterialTheme.typography.bodySmall,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                    Text(totalFinal, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}
