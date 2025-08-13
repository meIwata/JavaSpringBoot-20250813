package fcu.pbiecs.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String birthday;
}
