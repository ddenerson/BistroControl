package com.bistrocontrol.bistro_control.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bistrocontrol.bistro_control.model.ReservedTableStatus;
import com.bistrocontrol.bistro_control.model.RestaurantTable;


@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long>{ 
    
    @Query("SELECT rt FROM RestaurantTable rt LEFT JOIN RestaurantReserve r ON rt.id = r.restaurantTable.id" +
    " AND r.reserveDate = :reserveDate AND r.reserveTime = :reserveTime WHERE r.id IS NULL")
    List<RestaurantTable> findAvailableTables(@Param("reserveDate") LocalDate reserveDate, @Param("reserveTime") LocalTime reserveTime);

    @Query("SELECT new com.bistrocontrol.bistro_control.model.ReservedTableStatus(rt.id, rt.seats, r.id, " +
    "CASE WHEN r.id IS NOT NULL THEN 'Reservada' ELSE 'Disponível' END) " +
    "FROM RestaurantTable rt " +
    "LEFT JOIN RestaurantReserve r ON rt.id = r.restaurantTable.id " +
    "AND r.reserveDate = :reserveDate " +
    "AND r.reserveTime = :reserveTime")
    List<ReservedTableStatus> findTableStatus(@Param("reserveDate") LocalDate reserveDate, @Param("reserveTime") LocalTime reserveTime);
}
