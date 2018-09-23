import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group {
    private long id;
    private List<Student> students = new ArrayList<>();

    public Group() {
        this.id = (new Date()).getTime();
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setGroupID(this.id);
    }

    public void addStudents(ArrayList<Student> students) {
        for (Student student:
                students) {
            this.addStudent(student);
        }
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public float getAVG() {
        if (this.students.size() > 0) {
            float sum = 0;
            int size = 0;

            System.out.println(this.toString());

            for (Student student :
                    this.students) {
                if(student.getTotalMarks() == new int[]{-1,-1}) {
                    continue;
                }

                int[] totalMarks = student.getTotalMarks();
                size = size + totalMarks[1];
                sum = sum + totalMarks[0];
            }
            float avg = sum / size;
            return avg;
        }

        return -1;
    }
    @Override
    public String toString() {
        return "Группа"  + students + ';';
    }
}
