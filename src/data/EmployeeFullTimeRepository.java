package data;

import data.entities.EmployeeFullTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class EmployeeFullTimeRepository implements IEmployeeFullTimeRepository, Comparator<EmployeeFullTime> {
    // Đọc file Nhân Viên Full Time
    FacetoryFile facetoryFile;
    ArrayList<EmployeeFullTime> employeeFullTimes;
    public EmployeeFullTimeRepository(){
        facetoryFile = new FacetoryFile<EmployeeFullTime>();
        employeeFullTimes = facetoryFile.readFile("employeefulltime.data.txt");
    }
    //Check thông tin trùng
    @Override
    public EmployeeFullTime getInfoEmployeeFullTime(String info){
        return employeeFullTimes.stream().filter(
                o -> ("+"+info).equals(o.getPhone()) ||
                        info.equals(o.getCmnd())).findFirst().orElse(null);
    }

    // Ghi file khi thêm mới nhân viên FT
    @Override
    public void addEmployeeFullTimes(EmployeeFullTime employeeFullTime){
        employeeFullTimes.add(employeeFullTime);
        facetoryFile.writeFile("employeefulltime.data.txt", employeeFullTimes);
        System.out.println("Thêm nhân viên thành công..!");
    }

    // Lấy tên của nhân viên qua cmnd
    @Override
    public String getNameByCmnd(String cmnd){
        EmployeeFullTime employeeFullTime = new EmployeeFullTime();
        employeeFullTime = employeeFullTimes.stream().filter(
                o -> cmnd.equals(o.getCmnd())).findFirst().orElse(null);
        if(employeeFullTime != null)
            return employeeFullTime.getName();
        return cmnd;
    }

    // Tính lương nhân viên FT
    @Override
    public boolean displaySalaryEmployeeFullTime(String cmnd) {
        EmployeeFullTime employeeFullTime;
        employeeFullTime = employeeFullTimes.stream().filter(
                o -> cmnd.equals(o.getCmnd())).findFirst().orElse(null);
        if (employeeFullTime != null) {
            System.out.println("Lương của nhân viên " + employeeFullTime.getName() + " là: " + employeeFullTime.calculateSalary());
            return true;
        }
        return false;
    }

    //Ghi lại file khi sửa nhân viên
    @Override
    public void updateEmployeeFullTime(String cmnd, EmployeeFullTime updateEmployeeFullTime){
        for (int i = 0; i < employeeFullTimes.size(); i++) {
            if(cmnd.equals(employeeFullTimes.get(i).getCmnd())){
                employeeFullTimes.set(i,updateEmployeeFullTime);
                facetoryFile.writeFile("employeefulltime.data.txt",employeeFullTimes);
                System.out.println("Update thành công ..!");
            }
        }
    }

    // Ghi lại file khi xóa nhân viên
@Override
    public void deleteEmployee(String cmnd) {
        for (int i = 0; i < employeeFullTimes.size(); i++) {
            if(cmnd.equals(employeeFullTimes.get(i).getCmnd())){
                employeeFullTimes.remove(i);
                facetoryFile.writeFile("employeefulltime.data.txt", employeeFullTimes);
                System.out.println("Xóa thành công..!");
            }
        }
    }

    //sort
    @Override
    public int compare(EmployeeFullTime o1, EmployeeFullTime o2) {
        return o1.getName().compareTo(o2.getName());
    }

    // Lấy ra nhân viên PT đang làm và sắp xếp
    @Override
    public ArrayList<EmployeeFullTime> getEmployeeFullTimeTrue() {
        ArrayList<EmployeeFullTime> listEPFTtrue = new ArrayList<>();
        for (int i = 0; i < employeeFullTimes.size(); i++) {
            if(employeeFullTimes.get(i).isStatus())
                listEPFTtrue.add(employeeFullTimes.get(i));
        }
        Collections.sort(listEPFTtrue, new EmployeeFullTimeRepository());
        return listEPFTtrue;
    }

    //Lấy ra nhân viên đang nghỉ và sắp xếp
    @Override
    public ArrayList<EmployeeFullTime> getEmployeeFullTimeFalse() {
        ArrayList<EmployeeFullTime> listEPFTfalse = new ArrayList<>();
        for (int i = 0; i < employeeFullTimes.size(); i++) {
            if(!employeeFullTimes.get(i).isStatus())
                listEPFTfalse.add(employeeFullTimes.get(i));
        }
        Collections.sort(listEPFTfalse, new EmployeeFullTimeRepository());
        return listEPFTfalse;
    }

    // Ghi lại file khi đổi trạng thái
    @Override
    public void changeStatusEmployeeFullTime(String cmnd, Boolean status) {
        for (int i = 0; i < employeeFullTimes.size(); i++) {
            if (cmnd.equals(employeeFullTimes.get(i).getCmnd())) {
                employeeFullTimes.get(i).setStatus(status);
                facetoryFile.writeFile("employeefulltime.data.txt", employeeFullTimes);
                System.out.println("Thay đổi thành công ..!");
            }
        }
    }
    // Tìm kiếm nhân viên
    @Override
    public EmployeeFullTime[] searchEmployee(String name){
        return employeeFullTimes.stream().filter(
                o -> name.equals(o.getName())).toArray(EmployeeFullTime[]::new);
    }
}
