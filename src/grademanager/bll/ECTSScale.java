package grademanager.bll;

import grademanager.be.Grade;

public class ECTSScale implements IGradeScale
{
    @Override
    public String[] getAllGrades() {
        return new String[] { "A", "B", "C", "D", "E", "FX", "F" };
    }

    @Override
    public Grade createGrade(String studentName, String gradeDescription) {
        switch (gradeDescription)
        {
            case FAILED_DESCRIPTION:
                return new Grade(studentName, "FX");
            case BELOW_AVERAGE_DESCRIPTION:
                return new Grade(studentName, "E");
            case AVERAGE_DESCRIPTION:
                return new Grade(studentName, "C");
            case PERFECT_DESCRIPTION:
                return new Grade(studentName, "A");
        }
        return null;
    }
}
