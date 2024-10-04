package tn.taha.ms_saff_management.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.taha.ms_saff_management.entities.Staff;
import tn.taha.ms_saff_management.repository.StaffRepository;
import tn.taha.ms_saff_management.services.Interfaces.IStaffService;

import java.util.Date;
import java.util.List;
@Service
public class StaffServiceImp implements IStaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Override
    public Staff addStaff(Staff staff) {

        return this.staffRepository.save(staff);
    }

    @Override
    public Staff GetStaff(int id) {
        if (staffRepository.findById(id).isPresent()) {
            Staff staff = staffRepository.findById(id).get();

            return staff;
        }else {
            return null;
        }

    }
}
