package ru.geekbrain.converters;

import org.springframework.stereotype.Component;
import ru.geekbrain.dto.StudentDto;
import ru.geekbrain.entities.Student;

@Component
public class StudentConverter {
    public static Student dtoToEntity(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getName(), studentDto.getMark());
    }

    public static StudentDto entityToDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getMark());
    }
}
