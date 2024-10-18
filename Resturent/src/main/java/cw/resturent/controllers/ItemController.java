package cw.resturent.controllers;

import cw.resturent.Service.ItemService;
import cw.resturent.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO) {
        return itemService.saveItem(itemDTO);
    }

    @PutMapping("/{id}")
    public ItemDTO updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(id, itemDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Deleted";
    }

    @GetMapping("/{id}")
    public ItemDTO getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }
}
