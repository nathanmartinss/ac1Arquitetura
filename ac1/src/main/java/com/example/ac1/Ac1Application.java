package com.example.ac1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.ac1.model.Produto;
import com.example.ac1.model.Categoria;
import com.example.ac1.repository.ProdutoRepository;
import com.example.ac1.repository.CategoriaRepository;

@SpringBootApplication
public class Ac1Application implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria();
		categoria1.setCatNome("Jogos");
		categoria1.setCatDescricao("Consoles de Video Game");
		categoriaRepository.save(categoria1);

		Categoria categoria2 = new Categoria();
		categoria2.setCatNome("Celulares");
		categoria2.setCatDescricao("iPhones");
		categoriaRepository.save(categoria2);

		Produto produto1 = new Produto();
		produto1.setProdNome("PS5");
		produto1.setIdCategoria(categoria1.getIdCategoria());
		produtoRepository.save(produto1);

		Produto produto2 = new Produto();
		produto1.setProdNome("iPhone 15");
		produto1.setIdCategoria(categoria1.getIdCategoria());
		produtoRepository.save(produto2);

		System.out.println("Produtos: " + produtoRepository.findAll());
		System.out.println("Categorias: " + categoriaRepository.findAll());
	}
}
