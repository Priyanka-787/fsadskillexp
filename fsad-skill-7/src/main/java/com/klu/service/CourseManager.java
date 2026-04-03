package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.exception.CourseNotFoundException;
import com.klu.entity.*;
import com.klu.repository.CourseRepository;

@Service
public class CourseManager 
{
    @Autowired
    CourseRepository cr;

    public String insertData(Course c1)
    {
        cr.save(c1);
        return "Insertion was done successfully";
    }

    public List<Course> getAllData()
    {
        return cr.findAll();
    }

    public Course getDataById(Long id)
    {
        Optional<Course> c2 = cr.findById(id);

        if(c2.isPresent())
        {
            return c2.get();
        }
        else
        {
            throw new CourseNotFoundException("Course not exist with id : " + id);
        }
    }

    public String updateAllData(Long id, Course c2)
    {
        Optional<Course> c3 = cr.findById(id);

        if(c3.isPresent())
        {
            Course c4 = c3.get();
            c4.setTitle(c2.getTitle());
            c4.setDuration(c2.getDuration());
            c4.setFee(c2.getFee());

            cr.save(c4);
            return "Course updated successfully";
        }
        else
        {
            throw new CourseNotFoundException("Course not exist with id : " + id);
        }
    }

    public String deleteData(Long id)
    {
        Optional<Course> c2 = cr.findById(id);

        if(c2.isPresent())
        {
            cr.deleteById(id);
            return "Course deleted successfully";
        }
        else
        {
            throw new CourseNotFoundException("Course not exist with id : " + id);
        }
    }

    public List<Course> searchByTitle(String title)
    {
        List<Course> list = cr.findByTitleContainingIgnoreCase(title);

        if(list.isEmpty())
        {
            throw new CourseNotFoundException("No courses found with title : " + title);
        }

        return list;
    }
}