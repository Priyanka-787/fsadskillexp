package com.klu.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.klu.entity.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>
{
    List<Course> findByTitleContainingIgnoreCase(String title);
}