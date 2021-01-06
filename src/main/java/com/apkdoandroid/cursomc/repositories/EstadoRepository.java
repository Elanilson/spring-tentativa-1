package com.apkdoandroid.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apkdoandroid.cursomc.domain.Categoria;
import com.apkdoandroid.cursomc.domain.Estado;
import com.apkdoandroid.cursomc.domain.Produto;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
