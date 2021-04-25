package com.demo.second;


import com.demo.second.model.Student;
import com.demo.second.model.StudentErrorResponse;
import com.demo.second.model.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> students;
    {
        students = new ArrayList<>();
        students.add(new Student("Ana", "Buse "));
        students.add(new Student("Maria", "Truse "));
        students.add(new Student("Oleg", "Bars "));
        students.add(new Student("Vitalik", "Busk "));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if( studentId >= students.size() || studentId < 0){
            throw new StudentNotFound("Student id not found - "+ studentId);
        }

        return students.get(studentId);
    }

}
