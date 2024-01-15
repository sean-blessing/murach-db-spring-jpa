package com.murach.web;

import com.murach.db.LineItemRepo;
import com.murach.model.LineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/line-items")
public class LineItemController {

    @Autowired
    LineItemRepo lineItemRepo;

    @GetMapping("/")
    public List<LineItem> getAll() {
        return lineItemRepo.findAll();
    }
    @GetMapping("/{id}")
    public Optional<LineItem> get(@PathVariable int id) {
        return lineItemRepo.findById(id);
    }

    @PostMapping("/")
    public LineItem add(@RequestBody LineItem lineItem) {
        return lineItemRepo.save(lineItem);
    }

    @PutMapping("/")
    public LineItem update(@RequestBody LineItem lineItem) {
        return lineItemRepo.save(lineItem);
    }

    @DeleteMapping("/{id}")
    public Optional<LineItem> delete(@PathVariable int id){
        Optional<LineItem> lineItem = lineItemRepo.findById(id);
        if (lineItem.isPresent()) {
            lineItemRepo.deleteById(id);
        }
        return lineItem;
    }

}
