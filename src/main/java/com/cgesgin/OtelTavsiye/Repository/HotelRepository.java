package com.cgesgin.OtelTavsiye.Repository;

import com.cgesgin.OtelTavsiye.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    Optional<Hotel> findByEmail(String email);
}
