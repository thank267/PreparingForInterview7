package ru.geekbrain.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrain.converters.StudentConverter;
import ru.geekbrain.dto.StudentDto;
import ru.geekbrain.entities.Student;
import ru.geekbrain.services.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> findAll() {
        return studentService.findAll().stream().map(StudentConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable Long id) {
        return StudentConverter.entityToDto(studentService.findById(id).orElseThrow());
    }

    @PostMapping
    public StudentDto saveNewStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.save(StudentConverter.dtoToEntity(studentDto));
        return StudentConverter.entityToDto(student);
    }

    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.update(StudentConverter.dtoToEntity(studentDto));
        return StudentConverter.entityToDto(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
