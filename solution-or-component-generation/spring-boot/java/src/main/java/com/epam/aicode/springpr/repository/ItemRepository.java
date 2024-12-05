package com.epam.aicode.springpr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epam.aicode.springpr.domain.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, CrudRepository<Item, Long> {

}
