package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Course;
import com.example.demo.pojo.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/ipos/students")
public class StudentController {
	
	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    
 // --- CREATE OPERATIONS ---
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // --- READ OPERATIONS ---
     // Fetch all students along with their courses
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // --- UPDATE: LINK A STUDENT TO A COURSE ---
    @PutMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> enrollStudentToCourse(
            @PathVariable Long studentId, 
            @PathVariable Long courseId) {
        
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);
        return ResponseEntity.ok(studentRepository.save(student));
    }

    // --- UPDATE: UNLINK A STUDENT FROM A COURSE ---
    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> removeStudentFromCourse(
            @PathVariable Long studentId, 
            @PathVariable Long courseId) {
        
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().remove(course);
        return ResponseEntity.ok(studentRepository.save(student));
    }

    // --- DELETE ENTITIES ---
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        studentRepository.delete(student);
        return ResponseEntity.ok("Student deleted successfully");
    }

 
}
