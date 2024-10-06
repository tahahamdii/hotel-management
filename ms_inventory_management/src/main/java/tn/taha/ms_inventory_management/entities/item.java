package tn.taha.ms_inventory_management.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    public enum ItemCategory {
        LINENS,
        TOILETRIES,
        CLEANING_SUPPLIES,
        FOOD,
        OTHER
    }

    public enum ItemUnit {
        PIECE, GRAM, LITER, PACK, SET;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    @Enumerated(EnumType.STRING)
    private ItemCategory category;
    @Enumerated(EnumType.STRING)
    private ItemUnit unit;

    private int quantity;


}