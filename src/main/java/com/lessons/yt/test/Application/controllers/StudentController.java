package com.lessons.yt.test.Application.controllers;

import com.lessons.yt.test.Application.dto.request.CreateStudentDto;
import com.lessons.yt.test.Application.dto.response.StudentGeneralDto;
import com.lessons.yt.test.Domain.entity.Student;
import com.lessons.yt.test.Domain.service.StudentService;
import com.lessons.yt.test.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentGeneralDto> getStudent(@RequestParam Integer id){
        return studentService.getStudent(id);
    }


    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody CreateStudentDto createStudentDto){ //(@RequestParam String name,@RequestParam String address...)
        return studentService.addStudent(createStudentDto);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestParam Integer id,@RequestParam String newName){
        return studentService.updateStudent(id, newName);
    }

}
