package tn.taha.ms_inventory_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.taha.ms_inventory_management.entities.Item;
import tn.taha.ms_inventory_management.repositories.ItemRepository;
import tn.taha.ms_inventory_management.services.interfaces.IItemService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements IItemService {
    @Autowired
    private ItemRepository IR;


    @Override
    public Item addItem(Item item) {
        return this.IR.save(item);
    }

    @Override
    public Optional<Item> show_item(Long id) {

        Item equipe = IR.findById(id).orElseThrow(() -> new RuntimeException(
                        "equipe with Id" + id + " does not exist"
                )
        );
        return IR.findById(id);
    }

    @Override
    public List<Item> all_items() {
        return this.IR.findAll();
    }

    @Override
    public boolean DeleteItem(Long id) {
        if(this.IR.findById(id).isPresent()){
            this.IR.deleteById(id);
            return true;
        }

        return false;
    }
}