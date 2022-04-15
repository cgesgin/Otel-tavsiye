package com.cgesgin.OtelTavsiye.Controller;

import com.cgesgin.OtelTavsiye.Entity.Hotel;
import com.cgesgin.OtelTavsiye.Exception.ResourceNotFoundException;
import com.cgesgin.OtelTavsiye.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelRepository repository;

    @GetMapping("/list")
    public List<Hotel> findAllHotels() {
        return repository.findAll();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resume not exist with id :" + id));;
        return ResponseEntity.ok(hotel);
    }

    @PostMapping("/add")
    public Hotel addProduct(@RequestBody Hotel hotel) {
        return repository.save(hotel);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id,@RequestBody Hotel updateHotel) {
        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CV not exist with id :" + id));

        hotel.setName(updateHotel.getName());
        hotel.setAward(updateHotel.isAward());
        hotel.setWifi(updateHotel.isWifi());
        hotel.setVentilation(updateHotel.isVentilation());
        hotel.setIscarPark(updateHotel.isIscarPark());
        hotel.setStarRating(updateHotel.getStarRating());
        hotel.setEmail(updateHotel.getEmail());

        Hotel update= repository.save(hotel);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable int id) {
        Hotel hotel=repository.getById(id);
        repository.delete(hotel);
    }
}
