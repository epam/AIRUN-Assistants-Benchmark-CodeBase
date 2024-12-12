package com.epam.aicode.springpr.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.aicode.springpr.domain.Item;
import com.epam.aicode.springpr.repository.ItemRepository;

@Transactional
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return StreamSupport.stream(itemRepository.findAll(Sort.by("id")).spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Item> get(final Long id) {
        return itemRepository.findById(id);
    }

    public Item create(final Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    public Optional<Item> update(final Long id, final Item item) {
        if (!Objects.equals(id, item.getId())) {
            throw new IllegalArgumentException("IDs don't match");
        }
        if (itemRepository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        Optional<Item> savedItem = Optional.of(itemRepository.save(item));
        return savedItem;
    }

    public void delete(final Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> findExprireByNow() {
        // TODO: add implementation
        return Collections.emptyList();
    }
}
