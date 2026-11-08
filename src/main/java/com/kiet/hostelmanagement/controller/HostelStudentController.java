package com.kiet.hostelmanagement.controller;

import com.kiet.hostelmanagement.entity.HostelStudent;
import com.kiet.hostelmanagement.repository.HostelStudentRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class HostelStudentController {

    private final HostelStudentRepository repository;

    public HostelStudentController(HostelStudentRepository repository) {
        this.repository = repository;
    }

    // 1. Add Student
    @PostMapping
    public ResponseEntity<HostelStudent> addStudent(
            @RequestBody HostelStudent student) {

        student.setId(null);

        HostelStudent savedStudent = repository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedStudent);
    }

    // 2. Get All Students
    @GetMapping
    public List<HostelStudent> getAllStudents() {

        return repository.findAll();
    }

    // 3. Get Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<HostelStudent> getStudentById(
            @PathVariable Integer id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Update Student
    @PutMapping("/{id}")
    public ResponseEntity<HostelStudent> updateStudent(
            @PathVariable Integer id,
            @RequestBody HostelStudent student) {

        return repository.findById(id).map(existingStudent -> {

            existingStudent.setStudentName(student.getStudentName());
            existingStudent.setRollNumber(student.getRollNumber());
            existingStudent.setHostelName(student.getHostelName());
            existingStudent.setRoomNumber(student.getRoomNumber());
            existingStudent.setFee(student.getFee());

            HostelStudent updatedStudent =
                    repository.save(existingStudent);

            return ResponseEntity.ok(updatedStudent);

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Integer id) {

        if (!repository.existsById(id)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found");
        }

        repository.deleteById(id);

        return ResponseEntity.ok("Student deleted successfully");
    }
}