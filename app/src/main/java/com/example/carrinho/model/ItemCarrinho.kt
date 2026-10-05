package com.example.carrinho.model

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {
    override fun calcularTotal(): Double = produto.calcularTotal() * quantidade
}
