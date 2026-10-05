package com.example.carrinho.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carrinho.domain.*
import com.example.carrinho.model.ItemCarrinho

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarrinhoScreen(
    itens: List<ItemCarrinho>,
    incluirExtras: Boolean,
    onIncluirExtrasChange: (Boolean) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Meu Carrinho", style = MaterialTheme.typography.titleLarge)
                }
            })
        },
        bottomBar = {
            ResumoCarrinho(
                subtotal = formatarMoeda(subtotalBruto(itens)),
                descontos = formatarMoeda(descontoTotal(itens)),
                total = formatarMoeda(totalFinal(itens))
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Incluir demais produtos do catálogo",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(checked = incluirExtras, onCheckedChange = onIncluirExtrasChange)
                }
            }
            items(itens) { item ->
                ItemCarrinhoRow(
                    nome = item.produto.nome,
                    descricao = item.produto.descricao,
                    precoUnitario = formatarMoeda(item.produto.preco),
                    quantidade = item.quantidade,
                    totalBruto = formatarMoeda(item.produto.preco * item.quantidade),
                    totalFinal = formatarMoeda(item.calcularTotal()),
                    descontoPercentual = item.produto.descontoPercentual.toInt()
                )
            }
        }
    }
}
