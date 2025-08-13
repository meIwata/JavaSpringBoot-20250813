package fcu.pbiecs.springdemo.controller;

import fcu.pbiecs.springdemo.model.Teacher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/teachers") // 定義路徑前綴
@CrossOrigin("*")
@RestController // 處理HTTP請求的控制器
public class TeacherController {
//    private List<Teacher> teachers = new ArrayList<>();
//    public TeacherController() {
//        // 初始化一些教師資料
//        teachers.add(new Teacher(1, "Alice", "Chang",
}
