package thi_module_2.service;

import thi_module_2.entity.Student;
import thi_module_2.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    public static StudentRepository repository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Student student) {
        repository.add(student);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public Student searchById(int id) {
        return repository.searchById(id);
    }

    public List<Student> searchByName(String name) {
        return repository.searchByName(name);
    }
}
