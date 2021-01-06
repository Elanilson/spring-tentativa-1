package com.apkdoandroid.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apkdoandroid.cursomc.domain.Categoria;
import com.apkdoandroid.cursomc.domain.Cidade;
import com.apkdoandroid.cursomc.domain.Estado;
import com.apkdoandroid.cursomc.domain.Produto;
import com.apkdoandroid.cursomc.repositories.CategoriaRepository;
import com.apkdoandroid.cursomc.repositories.CidadeRepository;
import com.apkdoandroid.cursomc.repositories.EstadoRepository;
import com.apkdoandroid.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria  cat1 = new Categoria(null, " informatica");
		Categoria  cat2 = new Categoria(null, " office");
		
		Produto p1 = new Produto(null,"computador",3000.00);
		Produto p2 = new Produto(null,"impresora",3800.00);
		Produto p3 = new Produto(null,"mouse",300.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null,"para");
		Estado est2 = new Estado(null,"Macapa");
		
		Cidade c1 = new Cidade(null,"belem",est1);
		Cidade c2 = new Cidade(null,"macap",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2));
	}

}
