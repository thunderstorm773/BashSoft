package models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.InvalidStringException;
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
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStringException();
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUsername())) {
            throw new DuplicateEntryInStructureException(student.getUsername(), this.name);
        }

        this.studentsByName.put(student.getUsername(), student);
    }
}
