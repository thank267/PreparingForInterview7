package ru.geekbrain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrain.entities.Student;
import ru.geekbrain.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentepository;

    public List<Student> findAll() {
        return studentepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentepository.findById(id);
    }

    public void deleteById(Long id) {
        studentepository.deleteById(id);
    }

    public Student save(Student student) {
        return studentepository.save(student);
    }

    @Transactional
    public Student update(Student student) {
        Student studentNew = studentepository.findById(student.getId()).orElseThrow();
        studentNew.setName(student.getName());
        studentNew.setMark(student.getMark());
        return studentNew;
    }
}
