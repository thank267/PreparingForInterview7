package ru.geekbrain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrain.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
