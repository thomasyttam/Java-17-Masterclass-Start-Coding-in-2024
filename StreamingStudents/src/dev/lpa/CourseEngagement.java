package dev.lpa;

import java.time.LocalDate;
import java.time.Period;

public class CourseEngagement {

    private final Course course;
    private final LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate,
                            String engagementType) {
        this.course = course;
        this.enrollmentDate = this.lastActivityDate = enrollmentDate;
        this.engagementType = engagementType;
    }

//    public Course getCourse() {
//        return course;
//    }
    public String getCourseCode() {
        return course.courseCode();
    }

//    public LocalDate getEnrollmentDate() {
//        return enrollmentDate;
//    }
    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }

    public String getEngagementType() {
        return engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

//    public LocalDate getLastActivityDate() {
//        return lastActivityDate;
//    }
    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }

    public String getLastActivityMonth() {
        return "%tb".formatted(lastActivityDate); // %tb abbreviated month name, eg. Jan
    }

    public double getPercentComplete() {
        return lastLecture * 100.0 / course.lectureCount();
    }

    public int getMonthsSinceActive() {

        LocalDate now = LocalDate.now();
        var months = Period.between(lastActivityDate, now).toTotalMonths(); // first calculate the days and convert to months
        return (int) months;
    }

    void watchLecture(int lectureNumber, LocalDate currentDate) {

        lastLecture = Math.max(lectureNumber, lastLecture);
        lastActivityDate = currentDate;
        engagementType = "Lecture " + lastLecture;
    }

    @Override
    public String toString() {
        return "%s: %s %d %s [%d]".formatted(course.courseCode(),
                getLastActivityMonth(), getLastActivityYear(), engagementType,
                getMonthsSinceActive());
    }
}
