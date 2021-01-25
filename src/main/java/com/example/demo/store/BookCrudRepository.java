package com.example.demo.store;

import org.springframework.data.repository.CrudRepository;

public interface BookCrudRepository extends CrudRepository<Book,Integer> {

}
