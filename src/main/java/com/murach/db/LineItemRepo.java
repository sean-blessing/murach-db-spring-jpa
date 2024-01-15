package com.murach.db;

import com.murach.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {
}
