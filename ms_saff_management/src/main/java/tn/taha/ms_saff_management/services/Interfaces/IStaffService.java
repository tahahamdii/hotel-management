package tn.taha.ms_saff_management.services.Interfaces;

import tn.taha.ms_saff_management.entities.Staff;

import java.util.List;

public interface IStaffService {
    public Staff addStaff(Staff staff);

    public Staff GetStaff (int id);

    public Staff update(int id, Staff newStaff);

    public List<Staff> all_staff();
    public boolean DeleteStaff(int id);
}