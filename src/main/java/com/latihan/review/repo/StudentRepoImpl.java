package com.latihan.review.repo;

import com.latihan.review.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Service
public class StudentRepoImpl implements StudentRepo {

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private HashOperations hashOperations;

    @PostConstruct
    public void setHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Student student) {
        hashOperations.put("STUDENT",student.getName(),student);
    }

    @Override
    public Map<String,Object> findAll() {
        return hashOperations.entries("STUDENT");
    }

    @Override
    public Object findByName(String name) {
        return hashOperations.get("STUDENT",name);
    }

    @Override
    public void update(Student student) {
        hashOperations.put("STUDENT",student.getName(),student);
    }

    @Override
    public void deleteByName(String name) {
        hashOperations.delete("STUDENT",name);
    }
}
