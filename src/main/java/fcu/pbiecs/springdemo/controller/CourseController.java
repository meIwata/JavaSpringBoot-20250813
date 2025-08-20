package fcu.pbiecs.springdemo.controller;

import fcu.pbiecs.springdemo.model.Course;
import fcu.pbiecs.springdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // 允許所有來源的跨域請求
@RestController // 處理HTTP請求的控制器
@RequestMapping("/api/courses") // 定義路徑前綴
public class CourseController {
    @Autowired // 自動注入CourseService，這樣就可以使用課程服務
    private CourseService courseService;

    // 查詢所有課程資料
    @GetMapping
    public List<Course> getCourses() {
     return courseService.getAllCourses();
    }

    // 查詢特定指定id課程資料
    @GetMapping("/{id}") // 完整路徑會是 /api/courses
    public Course getCourse(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    // 刪除特定課程資料
    @DeleteMapping("/{id}") // 完整路徑會是 /api/courses
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourseById(id);
    }

    // 新增課程資料
    @PostMapping
    public String createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
}
