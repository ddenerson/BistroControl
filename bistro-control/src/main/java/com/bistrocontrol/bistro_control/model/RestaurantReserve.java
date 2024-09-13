package com.bistrocontrol.bistro_control.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserve")
public class RestaurantReserve {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantTable restaurantTable;

    @Column(name = "reserve_date")
    private LocalDateTime reserveDate;

    public RestaurantReserve(Long id, User user, RestaurantTable restaurantTable, LocalDateTime reserveDate) {
        this.id = id;
        this.user = user;
        this.restaurantTable = restaurantTable;
        this.reserveDate = reserveDate;
    }

    public RestaurantReserve(User user, RestaurantTable restaurantTable, LocalDateTime reserveDate) {
        this.user = user;
        this.restaurantTable = restaurantTable;
        this.reserveDate = reserveDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public LocalDateTime getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDateTime reserveDate) {
        this.reserveDate = reserveDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RestaurantReserve other = (RestaurantReserve) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RestaurantReserve [id=" + id + ", user=" + user + ", restaurantTable=" + restaurantTable
                + ", reserveDate=" + reserveDate + "]";
    }
}
