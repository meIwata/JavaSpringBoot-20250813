package fcu.pbiecs.springdemo.service;

import fcu.pbiecs.springdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
// 處理學生相關的業務邏輯
public class StudentService {
    @Autowired // 自動注入DatabaseService，這樣就可以使用資料庫服務
    private DatabaseService dbService;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM Student";
        try (Connection conn = dbService.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
//                Student student = new Student();
//                student.setStudentId(rs.getInt("student_id"));
//                student.setFirstName(rs.getString("first_name"));
//                student.setLastName(rs.getString("last_name"));
//                student.setBirthday(rs.getString("date_of_birth"));
//                student.setEmail(rs.getString("email"));

                // 也可以使用建構子來創建Student物件
                int studentId = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String birthday = rs.getString("date_of_birth");
                String email = rs.getString("email");
                Student student = new Student(studentId, firstName, lastName, email, birthday);

                students.add(student);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return students;
    }
}
