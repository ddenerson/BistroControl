package com.bistrocontrol.bistro_control.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bistrocontrol.bistro_control.model.RestaurantReserve;

@Repository
public interface RestaurantReserveRepository extends CrudRepository<RestaurantReserve, Long> {

    List<RestaurantReserve> findByReserveDate(LocalDate reserveDate);

    List<RestaurantReserve> findByReserveDateAndReserveTime(LocalDate date, LocalTime time);

    List<RestaurantReserve> findByUserId(Long id);
  
}
