package com.cgesgin.OtelTavsiye;

import com.cgesgin.OtelTavsiye.Entity.Hotel;
import com.cgesgin.OtelTavsiye.Entity.HotelBuilder;
import com.cgesgin.OtelTavsiye.Repository.HotelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HotelRepositoryTests {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveHotelTest(){

        Hotel hotel= HotelBuilder.builder("Sky Star",5)
                .setAward(false)
                .setEmail("hello@gamil.com")
                .build();

        hotelRepository.save(hotel);

        Assertions.assertThat(hotel.getId()).isGreaterThan(0);

    }
    @Test
    @Order(2)
    @Rollback(value = false)
    public void getHotelTest(){

        Hotel hotel=hotelRepository.findById(1).get();

        Assertions.assertThat(hotel.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    @Rollback(value = false)
    public void getListHotelTest(){

        List<Hotel> hotel = hotelRepository.findAll();

        Assertions.assertThat(hotel.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void UpdateHotelTest(){

        Hotel hotel=hotelRepository.findById(1).get();
        hotel.setAward(true);

        hotelRepository.save(hotel);

        Assertions.assertThat(hotel.isAward()).isTrue();
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteHotelTest(){

        Hotel hotel=hotelRepository.findById(1).get();
        hotelRepository.delete(hotel);


        Hotel h1 = null;

        Optional<Hotel> optionaldeleted = hotelRepository.findByEmail("hello@gmail.com");

        if(optionaldeleted.isPresent()){
            h1 = optionaldeleted.get();
        }

        Assertions.assertThat(h1).isNull();
    }
}
