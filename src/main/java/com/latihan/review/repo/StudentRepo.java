package com.latihan.review.repo;

import com.latihan.review.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepo
{
    void save(Student student);
    Map<String,Object> findAll();
    Object findByName(String name);
    void update(Student student);
    void deleteByName(String name);
}
