package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.*;
import com.klu.service.CourseManager;

@RestController
@RequestMapping("/courses")
@ResponseBody
public class CourseController 
{
    @Autowired
    CourseManager cm;

    // Insert
    @PostMapping("/insert")
    public String insert(@RequestBody Course c1)
    {
        return cm.insertData(c1);
    }

    // Get All
    @GetMapping("/getall")
    public List<Course> getAll()
    {
        return cm.getAllData();
    }

    // Get By Id
    @GetMapping("/getbyid/{id}")
    public Course getById(@PathVariable Long id)
    {
        return cm.getDataById(id);
    }

    // Update
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Course c2)
    {
        return cm.updateAllData(id, c2);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        return cm.deleteData(id);
    }

    // Search
    @GetMapping("/search/{title}")
    public List<Course> search(@PathVariable String title)
    {
        return cm.searchByTitle(title);
    }
}