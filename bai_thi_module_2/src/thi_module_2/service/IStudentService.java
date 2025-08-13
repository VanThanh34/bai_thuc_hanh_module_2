package thi_module_2.service;


import thi_module_2.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void add(Student student);

    boolean delete(int id);

    Student searchById(int id);

}

