package com.lessons.yt.test.Domain.service;

import com.lessons.yt.test.Application.dto.request.CreateStudentDto;
import com.lessons.yt.test.Application.dto.response.StudentGeneralDto;
import com.lessons.yt.test.Domain.entity.Student;
import com.lessons.yt.test.Domain.exception.StudentNotFoundException;
import com.lessons.yt.test.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private  StudentRepository studentRepository;


    public ResponseEntity<StudentGeneralDto> getStudent(Integer id) {
        StudentGeneralDto studentGeneralDto = new StudentGeneralDto();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentGeneralDto.setId(student.getId());
            studentGeneralDto.setName(student.getName());
            studentGeneralDto.setGrade(student.getGrade());
            return ResponseEntity.ok(studentGeneralDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    public ResponseEntity<Student> addStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        student.setName(createStudentDto.getName());
        student.setAddress(createStudentDto.getAddress());
        student.setEmail(createStudentDto.getEmail());
        student.setGrade(createStudentDto.getGrade());
        student.setPassword(createStudentDto.getPassword());
        studentRepository.save(student);
        ResponseEntity<Student> responseEntity = ResponseEntity.ok(student);
        return responseEntity;
    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student Deleted Sucessfully!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> updateStudent(Integer id, String newName) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            log.info("Student is found and the student is "+id);
            Student student = optionalStudent.get();
            student.setName(newName);
            studentRepository.save(student);
            return ResponseEntity.ok("Student updated successfully!");

        }else{
            throw new StudentNotFoundException("student not found");

        }
    }
}
