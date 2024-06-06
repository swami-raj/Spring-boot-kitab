package com.libarary.Library.service;

import com.libarary.Library.dao.KitabDao;
import com.libarary.Library.dto.KitabDto;
import com.libarary.Library.entity.Kitab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KitabService {
    @Autowired
    KitabDao kitabdao;


    public String add(KitabDto kitabdto) {
        Kitab kitab=new Kitab();
        kitab.setName(kitabdto.getName());
        kitab.setAuthor(kitabdto.getAuthor());
        kitab.setCost(kitabdto.getCost());
        kitabdao.save(kitab);
        return "success";
    }
    public String addall(List<KitabDto> kitabdto){
        kitabdto.forEach(e->{
            Kitab kitab=new Kitab();
            kitab.setName(e.getName());
            kitab.setAuthor(e.getAuthor());
            kitab.setCost(e.getCost());
            kitabdao.save(kitab);

        });
        return "Saved successfully";
    }

    public void delete(int id) {
        kitabdao.deleteById(id);

    }

    public List<KitabDto> getall() {

        List<Kitab> kitabdata=new ArrayList<>();
        kitabdata.addAll(kitabdao.findAll()) ;
        List<KitabDto>kitabdtos=new ArrayList<>();

        kitabdata.forEach(e->{
            KitabDto kitabdto =new KitabDto();
            kitabdto.setId(e.getId());
            kitabdto.setName(e.getName());
            kitabdto.setAuthor(e.getAuthor());
            kitabdto.setCost(e.getCost());
            kitabdtos.add(kitabdto);
        });
        return kitabdtos;
    }


    public KitabDto getdetail(int id) {
        KitabDto dto = new KitabDto();
        Optional<Kitab> optionalUser = kitabdao.findById(id);
        if (optionalUser.isPresent()) {
            Kitab user = optionalUser.get();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setCost(user.getCost());
            dto.setAuthor(user.getAuthor());
        }
        return dto;
    }

    public List<KitabDto> getByName(String name) {
        List<Kitab> kitabList = kitabdao.findByName(name);
        if (kitabList.isEmpty()) {
            return new ArrayList<>();
        }
        return kitabList.stream().map(kitab -> {
            KitabDto dto = new KitabDto();
            dto.setId(kitab.getId());
            dto.setName(kitab.getName());
            dto.setAuthor(kitab.getAuthor());
            dto.setCost(kitab.getCost());
            return dto;
        }).collect(Collectors.toList());
    }

    public List<KitabDto> getByAuthor(String author) {
        List<Kitab> kitabauthorList = kitabdao.findByAuthor(author);
        if (kitabauthorList.isEmpty()) {
            return new ArrayList<>();
        }
        return kitabauthorList.stream().map(e -> {
            KitabDto dto = new KitabDto();
            dto.setId(e.getId());
            dto.setName(e.getName());
            dto.setAuthor(e.getAuthor());
            dto.setCost(e.getCost());
            return dto;
        }).collect(Collectors.toList());
    }

}
