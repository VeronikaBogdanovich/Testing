import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private long groupID = -1;
    private String name;
    private String surname;

    private List<Integer> marks = new ArrayList<>();


    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addValue(int value) {
        if (value <= 10 && value >= 0) {
            this.marks.add(value);
        }
    }

    public void addMarks(int[] marks) {
        for (int mark:
             marks) {
            this.addValue(mark);
        }
    }
    public float getAVG() {
        if(this.marks.size() > 0) {
            float sum = 0;

            for (int mark :
                    this.marks) {
                sum = sum + mark;
            }
            float avg = sum / this.marks.size();
            return avg;
        }

        return -1;
    }
    public int[] getTotalMarks() {
        if(this.marks.size() > 0) {
            int sum = 0;

            for (int mark :
                    this.marks) {
                sum = sum + mark;
            }

            return new int[] {sum, this.marks.size()};
        }

        return new int[] {-1, -1};
    }

    @Override
    public String toString() {
        return "Студент{" + "Имя='" + name + '\'' + ", Фамилия='" + surname + '\''
                + ", Группа=" + groupID + ", Оценки=" + marks + '}';
    }
}

