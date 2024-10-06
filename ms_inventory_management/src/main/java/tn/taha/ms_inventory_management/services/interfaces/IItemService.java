package tn.taha.ms_inventory_management.services.interfaces;


import tn.taha.ms_inventory_management.entities.Item;

import java.util.List;
import java.util.Optional;

public interface IItemService {
    public Item addItem(Item item);


    Optional<Item> show_item(Long id);

    public List<Item> all_items();
    public boolean DeleteItem(Long id);
}
