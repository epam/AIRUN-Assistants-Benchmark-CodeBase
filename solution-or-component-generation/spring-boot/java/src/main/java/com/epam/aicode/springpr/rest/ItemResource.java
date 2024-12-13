package com.epam.aicode.springpr.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.aicode.springpr.domain.Item;
import com.epam.aicode.springpr.model.ItemDTO;
import com.epam.aicode.springpr.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping(value = ItemResource.BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemResource {
    public static final String BASE_URI = "/api/items";

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemResource(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<Item> items = itemService.findAll();
        List<ItemDTO> dtos = items.stream().map(this::convertToDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(":expired")
    public ResponseEntity<List<ItemDTO>> getExpiredItems() {
        List<Item> items = itemService.findExpiredByNow();
        List<ItemDTO> dtos = items.stream().map(this::convertToDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    private ItemDTO convertToDto(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

    private Item convertToEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }

}
