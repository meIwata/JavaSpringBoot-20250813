package fcu.pbiecs.springdemo.controller;

import fcu.pbiecs.springdemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // 處理HTTP請求的控制器
@RequestMapping("/api/students") // 定義路徑前綴
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        // 初始化一些學生資料
        students.add(new Student(1, "Tom", "Doel", "tom@yahoo.com.tw", "2000-01-01"));
        students.add(new Student(2, "Mary", "Wang", "maryw@yahoo.com.tw", "1999-10-01"));
    }

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{id}") // 完整路徑會是 /api/students/{id}
    public Student getStudent(@PathVariable int id) {
        for(Student student : students) {
            if(student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }
}
