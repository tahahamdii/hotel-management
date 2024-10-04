package tn.taha.ms_saff_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.taha.ms_saff_management.entities.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
