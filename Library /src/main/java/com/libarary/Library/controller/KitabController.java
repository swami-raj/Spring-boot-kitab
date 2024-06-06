package com.libarary.Library.controller;

import com.libarary.Library.dao.KitabDao;
import com.libarary.Library.dto.KitabDto;
import com.libarary.Library.dto.SignupDto;
import com.libarary.Library.entity.Kitab;
import com.libarary.Library.service.KitabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KitabController {
    @Autowired
    KitabService kitabservice;

    @Autowired
    KitabDao kitabdao;
    @PostMapping("/pustak")
    public String add(@RequestBody KitabDto kitabdto){

        return kitabservice.add(kitabdto);
    }
    @PostMapping("/pustakall")
    public String pustakAll(@RequestBody List<KitabDto>kitabdto){

        return kitabservice.addall(kitabdto);
    }
    @DeleteMapping("/pustak/{id}")
    public void deleteus(@PathVariable int id){

        kitabservice.delete(id);
    }
    @GetMapping("/pustak")
    public List<KitabDto>getall(){
        return kitabservice.getall();
    }
    @GetMapping("/pustak/{id}")
    public KitabDto getbyid(@PathVariable int id){
        return kitabservice.getdetail(id);
    }

    @GetMapping("pustak/name/{name}")
    public Object getByName(@PathVariable String name) {
        List<KitabDto> books = kitabservice.getByName(name);
        if (books.isEmpty()) {
            return "Book not found";
        }
        return books;
    }

    @GetMapping("pustak/author/{author}")
    public Object getByAuthor(@PathVariable String author) {
        List<KitabDto> books = kitabservice.getByAuthor(author);
        if (books.isEmpty()) {
            return "Book not found";
        }
        return books;
    }


}
