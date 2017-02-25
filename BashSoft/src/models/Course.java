package models;

import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course {

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public Course(String name) {
        this.name = name;
        this.studentsByName = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUsername())) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    student.getUsername(), this.getName()));
        }

        this.studentsByName.put(student.getUsername(), student);
    }
}
