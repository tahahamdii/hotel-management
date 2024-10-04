package tn.taha.ms_saff_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.taha.ms_saff_management.entities.Tasks;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer> {
    @Query("SELECT tasks FROM Tasks tasks  where tasks.staff.idStaff =:staffid")
    List<Tasks> findByStaff_IdStaff(@Param("staffid")int staffid);
}
