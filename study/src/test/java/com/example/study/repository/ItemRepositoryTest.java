package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.enumclass.ItemStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        /*
        Item item = new Item();
        item.setName("노트북");
//        item.setPrice(100000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);

         */

        Item item = new Item();
        item.setStatus(ItemStatus.REGISTERED);
        item.setName("삼성 콤퓨터");
        item.setTitle("삼성 콤퓨터 데트크톱");
        item.setContent("2021년 신상 테스크톱");
        item.setPrice(BigDecimal.valueOf(1000000));
        item.setBrandName("SAMSUNG");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("이충완");
//        item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);


    }

    @Test
    public void read() {
        /*
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertTrue(item.isPresent());

//        item.ifPresent(i->{
//            System.out.println(i);
//        });
         */
    }

}
