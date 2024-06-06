package com.libarary.Library.dao;

import com.libarary.Library.entity.Kitab;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KitabDao extends CrudRepository<Kitab,Integer> {
    public List<Kitab> findAll();
    List<Kitab> findByName(String name);
    List<Kitab> findByAuthor(String author);

}
