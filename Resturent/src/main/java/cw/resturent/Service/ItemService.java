package cw.resturent.Service;

import cw.resturent.Entity.Item;
import cw.resturent.Repository.ItemRepository;
import cw.resturent.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemDTO(item.getId(), item.getName(), item.getPrice()))
                .collect(Collectors.toList());
    }

    public ItemDTO saveItem(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getName(), itemDTO.getPrice());
        Item savedItem = itemRepository.save(item);
        return new ItemDTO(savedItem.getId(), savedItem.getName(), savedItem.getPrice());
    }

    public ItemDTO updateItem(Long id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        Item updatedItem = itemRepository.save(item);
        return new ItemDTO(updatedItem.getId(), updatedItem.getName(), updatedItem.getPrice());
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public ItemDTO getItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        return new ItemDTO(item.getId(), item.getName(), item.getPrice());
    }
}
