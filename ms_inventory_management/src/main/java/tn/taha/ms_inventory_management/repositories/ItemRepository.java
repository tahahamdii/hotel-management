package tn.taha.ms_inventory_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.taha.ms_inventory_management.entities.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
