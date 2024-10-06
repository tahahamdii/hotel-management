package tn.taha.ms_inventory_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_inventory_management.entities.Item;
import tn.taha.ms_inventory_management.services.ItemServiceImp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/item")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ItemController {
    @Autowired()
    private ItemServiceImp IS;

    @PostMapping()
    public ResponseEntity<Item> add(@RequestBody() Item item){
        return new ResponseEntity<>(IS.addItem(item), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Item> update(@Valid @RequestBody Item item, @PathVariable Long id){
        try {
            Optional<Item> existItem = IS.show_item(id);
            item.setId(id);
            IS.addItem(item);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping (value = "/all")
    public ResponseEntity<List<Item>> getAll(){
        return new ResponseEntity<>(IS.all_items(), HttpStatus.OK);
    }
    @GetMapping (value = "/{id}")
    public Optional<Item> getItem(@PathVariable("id") Long id){
        return IS.show_item(id);
    }
    @DeleteMapping (value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(IS.DeleteItem(id),HttpStatus.OK);
    }
}
