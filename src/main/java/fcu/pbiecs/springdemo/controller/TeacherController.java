package fcu.pbiecs.springdemo.controller;

import fcu.pbiecs.springdemo.model.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/teachers") // 定義路徑前綴
@CrossOrigin("*")
@RestController // 處理HTTP請求的控制器
public class TeacherController {
    private List<Teacher> teachers = new ArrayList<>();

    public TeacherController() {
        // 初始化一些教師資料
        teachers.add(new Teacher(1, "Alice", "alice@o365.fcu.edu.tw", 30));
        teachers.add(new Teacher(2, "David", "david@o365.fcu.edu.tw", 30));
    }

    // 查詢所有教師資料
    @RequestMapping
    public List<Teacher> getTeachers() {
        return teachers;
    }

    // 查詢特定指定id教師資料
    @GetMapping("/{id}") // 完整路徑會是 /api/teachers/{id}
    public Teacher getTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == id) {
                return teacher;
            }
        }
        return null; // 如果找不到，返回null
    }

    // 刪除特定教師資料
    @DeleteMapping("/{id}") // 完整路徑會是 /api/teachers/{id}
    public String deleteTeacher(@PathVariable int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == id) {
                teachers.remove(teacher);
                return "Teacher with ID " + id + " deleted successfully.";
            }
        }
        return "Teacher with ID " + id + " not found.";
    }

    // 新增教師資料
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        teacher.setTeacherId(teachers.get(teachers.size() - 1).getTeacherId() + 1); // 設定新的教師ID為目前最後一個教師ID加1
        teachers.add(teacher); // 將新教師加入列表
        return teacher; // 返回新增的教師資料
    }

    // 更新教師資料
    @PutMapping("/{id}") // 完整路徑會是 /api/teachers
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher updatedTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherId() == id) {
                updatedTeacher.setTeacherId(id); // 確保更新的教師ID與路徑中的ID一致
                teachers.set(i, updatedTeacher); // 更新教師資料
                return updatedTeacher; // 返回更新後的教師資料
            }
        }
        return null; // 如果找不到，返回null
    }
}
