package models;

import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.LinkedHashMap;

public class Course {

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    public String name;
    public LinkedHashMap<String, Student> studentsByName;

    public Course(String name) {
        this.name = name;
        this.studentsByName = new LinkedHashMap<>();
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.username)) {
            OutputWriter.displayException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    student.username, this.name));
            return;
        }

        this.studentsByName.put(student.username, student);
    }
}
