package com.expense.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.demo.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
