package com.example.carrinho.data

import com.example.carrinho.model.ItemCarrinho
import com.example.carrinho.model.Produto

object Catalogo {
    val notebook = Produto(
        nome = "Notebook Dell Inspiron",
        preco = 3499.00,
        descricao = "Um notebook rápido para trabalho e estudos, com processador de última geração e SSD de alta velocidade.",
        descontoPercentual = 5.0
    )
    val mouse = Produto(nome = "Mouse sem fio", preco = 89.90, descricao = null) // sem descrição
    val teclado = Produto(
        nome = "Teclado mecânico RGB",
        preco = 349.90,
        descricao = "Switch azul, ABNT2"
    )
    val monitor = Produto( // nome longo + desconto
        nome = "Monitor Gamer Ultrawide Curvo 34 Polegadas 165Hz HDR com Suporte Ajustável de Altura e Inclinação",
        preco = 2199.00,
        descricao = "Painel VA curvo com taxa de atualização de 165Hz, tempo de resposta de 1ms, HDR10 e entradas HDMI e DisplayPort.",
        descontoPercentual = 10.0
    )
    val webcam = Produto("Webcam Full HD", 199.90, "Resolução 1080p com microfone embutido")
    val headset = Produto("Headset Gamer 7.1", 299.90, "Som surround virtual 7.1 e microfone removível", 15.0)

    val produtos: List<Produto> = listOf(notebook, mouse, teclado, monitor, webcam, headset)


    val carrinhoValidacao: List<ItemCarrinho> = listOf(
        ItemCarrinho(notebook, 2),
        ItemCarrinho(mouse, 1),
        ItemCarrinho(teclado, 1)
    )

    val carrinhoCompleto: List<ItemCarrinho> =
        carrinhoValidacao + listOf(monitor, webcam, headset).map { ItemCarrinho(it, 1) }
}
