package common;

import java.util.List;

/**
 * @author Qbss
 * @date 2021/5/6
 * @desc 690题员工类
 */
public class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee() {
    }

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}
