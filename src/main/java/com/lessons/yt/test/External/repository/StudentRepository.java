package com.lessons.yt.test.External.repository;

import com.lessons.yt.test.Domain.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByName(String name);
}

