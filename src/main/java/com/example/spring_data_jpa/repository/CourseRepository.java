package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    Page<Course> findByTitleContaining(
            String title,
            Pageable pageable);
}
