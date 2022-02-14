package method;

import common.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Qbss
 * @date 2021/5/6
 * @desc
 */
public class Solution690 {

//    private static  int sum = 0;

    public static void main(String[] args) {

        Employee e1 = new Employee(1,5, Arrays.asList(2,3));
        Employee e2 = new Employee(2,3,Arrays.asList(4));
        Employee e3 = new Employee(3,4,new ArrayList<>());
        Employee e4 = new Employee(4,1,new ArrayList<>());

        List<Employee> employees = Arrays.asList(e1, e2, e3,e4);
//        List<Employee> employees = Arrays.asList(e4);

        int importance = getImportance(employees, 1);
        System.out.println(importance);
    }


    public static int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(employee -> employee.getId(), Function.identity()));
        dealImportance(employeeMap.get(id), employeeMap);
        return employeeMap.get(id).getImportance();
    }


    private static void dealImportance(Employee e, Map<Integer, Employee> em) {
        if (e == null) {
            return;
        }
        if (e.getSubordinates().size() != 0) {
            for (int i = 0; i < e.getSubordinates().size(); i++) {
                Integer no = e.getSubordinates().get(i);
                dealImportance(em.get(no), em);
                e.setImportance(e.getImportance()+em.get(no).getImportance());
            }
        }
    }

}
