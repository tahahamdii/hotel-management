package tn.taha.ms_saff_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_saff_management.entities.Staff;
import tn.taha.ms_saff_management.services.StaffServiceImp;

import java.util.List;

@RestController
@RequestMapping(value = "/api/staff")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class StaffController {

    @Autowired
    private StaffServiceImp staffService;

    @PostMapping("add")
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    // Endpoint to retrieve a staff member by ID
    @GetMapping("getstaff/{id}")
    public Staff getStaff(@PathVariable int id) {
        return staffService.GetStaff(id);
    }


    @PutMapping("edit/{id}")
    public Staff updateStaff(@PathVariable int id, @RequestBody Staff newStaff) {
        return staffService.update(id, newStaff);
    }

    @GetMapping("all")
    public List<Staff> getAllStaff() {
        return staffService.all_staff();
    }


    @DeleteMapping("delete/{id}")
    public boolean deleteStaff(@PathVariable int id) {
        return staffService.DeleteStaff(id);
    }
}
