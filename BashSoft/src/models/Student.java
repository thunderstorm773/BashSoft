package models;

import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

    private String username;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;

    public Student(String username) {

        this.setUsername(username);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if (username == null || username.equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.NULL_OR_EMPTY_VALUE);
        }

        this.username = username;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    public void enrollInCourse(Course course) {
        if (this.enrolledCourses.containsKey(course.getName())) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    this.getUsername(), course.getName()));
        }

        this.enrolledCourses.put(course.getName(), course);
    }

    public void setMarksInCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
        }

        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    private double calculateMark(int[] scores) {

        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
