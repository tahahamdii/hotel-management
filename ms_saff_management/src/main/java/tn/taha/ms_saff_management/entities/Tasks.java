package tn.taha.ms_saff_management.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTask;
    private String label;
    private String ToDo;
    @Temporal(TemporalType.DATE)
    private Date date;

    private String startTime;

    private String endTime;

    @JsonIgnore
    @ManyToOne
    Staff staff;
    @Override
    public String toString() {
        return "Tasks{" +
                "idTask=" + idTask +
                ", label='" + label + '\'' +
                ", ToDo='" + ToDo + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}