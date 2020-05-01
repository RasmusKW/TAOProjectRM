package com.example.demo.Service;

import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepo;
import com.example.demo.Repository.ItemRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepoJPA itemRepo;

    public List<Item> fetchAllItems(){
        return itemRepo.findAll();

    }

    public void addItem(Item i){
        itemRepo.save(i);
    }

    public void deleteItem(int id){
        itemRepo.deleteById(id);
    }

    public Item findItemById(int id){
        return itemRepo.getOne(id);

    }

    public void updateItem(Item i){
        itemRepo.save(i);
    }

}
