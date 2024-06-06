package com.libarary.Library.dao;

import com.libarary.Library.entity.Signup;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthDao extends CrudRepository<Signup,Integer>{
    boolean existsByMail(String mail);
    Optional<Signup> findByMail(String mail);

}
