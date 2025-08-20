package fcu.pbiecs.springdemo.controller;

import fcu.pbiecs.springdemo.model.Enrollment;
import fcu.pbiecs.springdemo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // 允許所有來源的跨域請求
@RestController // 處理HTTP請求的控制器
@RequestMapping("/api/enrollments") // 定義路徑前綴
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    // 查詢所有選課
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    // 查詢某學生的所有選課
    @GetMapping("/{studentId}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable int studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }

    // 新增選課
    @PostMapping("/{studentId}/{courseId}")
    public String addEnrollment(@PathVariable int studentId, @PathVariable int courseId) {
        return enrollmentService.addEnrollment(studentId, courseId);
    }

    // 刪除選課
    @DeleteMapping("/{studentId}/{courseId}")
    public String deleteEnrollment(@PathVariable int studentId, @PathVariable int courseId) {
        return enrollmentService.deleteEnrollment(studentId, courseId);
    }
}
