package com.example.carrinho.model

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String? = null,          // pode ser nula
    val descontoPercentual: Double = 0.0    // padrão: sem desconto
) : Pagavel {
    override fun calcularTotal(): Double = preco * (1 - descontoPercentual / 100.0)
}
