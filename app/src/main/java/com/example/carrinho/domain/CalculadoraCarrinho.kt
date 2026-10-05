package com.example.carrinho.domain

import com.example.carrinho.model.ItemCarrinho
import java.text.NumberFormat
import java.util.Locale

fun subtotalBruto(itens: List<ItemCarrinho>): Double =
    itens.sumOf { it.produto.preco * it.quantidade }

fun totalFinal(itens: List<ItemCarrinho>): Double =
    itens.sumOf { it.calcularTotal() }

fun descontoTotal(itens: List<ItemCarrinho>): Double =
    subtotalBruto(itens) - totalFinal(itens)

fun itensComDesconto(itens: List<ItemCarrinho>): List<ItemCarrinho> =
    itens
        .filter { it.produto.descontoPercentual > 0 }
        .sortedByDescending { it.calcularTotal() }

fun formatarMoeda(valor: Double): String =
    NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(valor)

fun gerarRelatorio(itens: List<ItemCarrinho>): List<String> {
    val comDesconto = itensComDesconto(itens)
    val linhas = comDesconto.map {
        "• ${it.produto.nome} (-${it.produto.descontoPercentual.toInt()}%) -> ${formatarMoeda(it.calcularTotal())}"
    }
    val somaComDesconto = comDesconto.map { it.calcularTotal() }.fold(0.0) { acc, v -> acc + v }
    return listOf("===== RELATÓRIO: ITENS COM DESCONTO =====") +
        linhas +
        "-----------------------------------------" +
        "Subtotal destes itens: ${formatarMoeda(somaComDesconto)}" +
        "Subtotal bruto carrinho: ${formatarMoeda(subtotalBruto(itens))}" +
        "Descontos aplicados:     ${formatarMoeda(descontoTotal(itens))}" +
        "TOTAL FINAL:             ${formatarMoeda(totalFinal(itens))}"
}
