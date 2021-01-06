package com.apkdoandroid.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apkdoandroid.cursomc.domain.Categoria;
import com.apkdoandroid.cursomc.repositories.CategoriaRepository;
import com.sun.el.stream.Optional;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	
	public Categoria buscar (Integer id)   {
		
		java.util.Optional<Categoria> obj =  catRepo.findById(id);
		return obj.orElseThrow(() -> new  com.apkdoandroid.cursomc.services.exception.ObjectNotFoundException("Objeto não encontrado id:"+id+", tipo: "+Categoria.class.getName()));
		
	}

}
