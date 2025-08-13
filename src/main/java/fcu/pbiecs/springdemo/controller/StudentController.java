package fcu.pbiecs.springdemo.controller;

import fcu.pbiecs.springdemo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*") // 允許所有來源的跨域請求
@RestController // 處理HTTP請求的控制器
@RequestMapping("/api/students") // 定義路徑前綴
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        // 初始化一些學生資料
        students.add(new Student(1, "Tom", "Doel", "tom@yahoo.com.tw", "2000-01-01"));
        students.add(new Student(2, "Mary", "Wang", "maryw@yahoo.com.tw", "1999-10-01"));
    }

    // 查詢所有學生資料
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }


    // 查詢特定學生資料
    @GetMapping("/{id}") // 完整路徑會是 /api/students/{id}
    public Student getStudent(@PathVariable int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    // 刪除特定學生資料
    @DeleteMapping("/{id}") // 完整路徑會是 /api/students/{id}
    public String deleteStudent(@PathVariable int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                students.remove(student);
                return "Student with ID " + id + " deleted successfully.";
            }
        }
        return "Student with ID " + id + " not found.";
    }


    // 新增學生資料
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        student.setStudentId(students.get(students.size() - 1).getStudentId() + 1);
        students.add(student);
        return student;
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                updatedStudent.setStudentId(id);
                students.set(i, updatedStudent);
                return updatedStudent;
            }
        }
        return null; // 如果找不到學生，返回null
    }
}
