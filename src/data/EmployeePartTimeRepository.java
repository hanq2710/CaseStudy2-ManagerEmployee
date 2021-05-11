package data;

import data.entities.EmployeePartTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class EmployeePartTimeRepository implements IEmployeePartTimeRepository, Comparator<EmployeePartTime> {
    // Đọc file Nhân Viên Part Time
    FacetoryFile facetoryFile;
    ArrayList<EmployeePartTime> employeePartTimes;
    public EmployeePartTimeRepository(){
        facetoryFile = new FacetoryFile<EmployeePartTime>();
        employeePartTimes = facetoryFile.readFile("employeeparttime.data.txt");
    }
    // Kiểm tra thông tin đã tồn tại hay chưa
    @Override
    public EmployeePartTime getInfoEmployeePartTime(String info){
       return employeePartTimes.stream().filter(
               o ->("+" + info).equals(o.getPhone()) ||
                        info.equals(o.getCmnd())).findFirst().orElse(null);
    }
    // Ghi nhân viên mới
    @Override
    public void addEmployeePartTime(EmployeePartTime employeePartTime){
        employeePartTimes.add(employeePartTime);
        facetoryFile.writeContact("employeeparttime.data.txt",employeePartTimes);
        System.out.println("Thêm thành công..!");
    }

    // Chỉnh ghi file chỉnh sửa nhân viên
    @Override
    public void updateEmployeePartTime(String cmnd, EmployeePartTime updateEmployeePartTime){
        for (int i = 0; i < employeePartTimes.size(); i++) {
            if(cmnd.equals(employeePartTimes.get(i).getCmnd())){
                employeePartTimes.set(i,updateEmployeePartTime);
                facetoryFile.writeContact("employeeparttime.data.txt",employeePartTimes);
                System.out.println("Update thành công ..!");
            }
        }
    }
    // Ghi file khi xóa nhân viên
    @Override
    public void deleteEmployeePartTime(String cmnd) {
        for (int i = 0; i < employeePartTimes.size(); i++) {
            if(cmnd.equals(employeePartTimes.get(i).getCmnd())){
                employeePartTimes.remove(i);
                facetoryFile.writeContact("employeeparttime.data.txt", employeePartTimes);
                System.out.println("Xóa thành công..!");
            }
        }
    }

    // lấy tên nhân viên bằng cmnd
    @Override
    public String getNameByCmndPartTime(String cmnd){
        EmployeePartTime employeePartTime;
        employeePartTime = employeePartTimes.stream().filter(
                o -> cmnd.equals(o.getCmnd())).findFirst().orElse(null);
        if(employeePartTime != null)
            return employeePartTime.getName();
        return cmnd;
    }

    // trả về lương của nhân viên Part Time
    @Override
    public boolean displaySalaryEmployeePartTime(String cmnd) {
        EmployeePartTime employeePartTime;
        employeePartTime = employeePartTimes.stream().filter(
                o -> cmnd.equals(o.getCmnd())).findFirst().orElse(null);
        if (employeePartTime != null) {
            System.out.println("Lương của nhân viên " + employeePartTime.getName() + " là: " + employeePartTime.calculateSalary());
            return true;
        }
        return false;
    }

    //Sort
    @Override
    public int compare(EmployeePartTime o1, EmployeePartTime o2) {
        return o1.getName().compareTo(o2.getName());
    }

    // Lấy nhân viên PT đang True và sort
    @Override
    public ArrayList<EmployeePartTime> getEmployeePartTimeTrue() {
        ArrayList<EmployeePartTime> listEPPTtrue = new ArrayList<>();
        for (int i = 0; i < employeePartTimes.size(); i++) {
            if(employeePartTimes.get(i).isStatus())
                listEPPTtrue.add(employeePartTimes.get(i));
        }
        Collections.sort(listEPPTtrue, new EmployeePartTimeRepository());
        return listEPPTtrue;
    }
    // Lấy nhân viên PT đang Fasle và sort
    @Override
    public ArrayList<EmployeePartTime> getEmployeePartTimeFalse() {
        ArrayList<EmployeePartTime> listEPPTfalse = new ArrayList<>();
        for (int i = 0; i < employeePartTimes.size(); i++) {
            if(!employeePartTimes.get(i).isStatus())
                listEPPTfalse.add(employeePartTimes.get(i));
        }
        Collections.sort(listEPPTfalse, new EmployeePartTimeRepository());
        return listEPPTfalse;
    }

    //Ghi file khi cập nhật trạng thái nhân viên
    @Override
    public void changeStatusEmployeePartTime(String cmnd, boolean status) {
        for (int i = 0; i < employeePartTimes.size(); i++) {
            if (cmnd.equals(employeePartTimes.get(i).getCmnd())) {
                employeePartTimes.get(i).setStatus(status);
                facetoryFile.writeContact("employeeparttime.data.txt", employeePartTimes);
                System.out.println("Thay đổi thành công..!!");
            }
        }
    }

    //Tìm kiếm nhân viên PT
    @Override
    public EmployeePartTime[] searchEmployeePartTime(String name){
        return employeePartTimes.stream().filter(
                o -> name.equals(o.getName())).toArray(EmployeePartTime[]::new);
    }
}
