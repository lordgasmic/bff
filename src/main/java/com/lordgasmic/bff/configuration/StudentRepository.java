package com.lordgasmic.bff.configuration;

import com.lordgasmic.bff.configuration.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    Student save(Student student);

}
