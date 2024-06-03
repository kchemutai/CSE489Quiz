package miu.edu.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Integer Id;
    private String firstName;
    private String lastName;
    private Long salary;
}
