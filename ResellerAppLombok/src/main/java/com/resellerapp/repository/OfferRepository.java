package com.resellerapp.repository;

import com.resellerapp.model.binding.UserBoughtOffersBindingModel;
import com.resellerapp.model.binding.UserOfferInfoBindingModel;
import com.resellerapp.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    @Query("SELECT new com.resellerapp.model.binding.UserOfferInfoBindingModel(o.id,o.description,o.price,o.condition.name) FROM Offer o WHERE o.user.id = :id")
    List<UserOfferInfoBindingModel> findAllOffersByUserId(Long id);

    @Query("SELECT new com.resellerapp.model.binding.UserBoughtOffersBindingModel(o.id,o.price,o.description) FROM Offer o WHERE o.buyer.id = :id")
    List<UserBoughtOffersBindingModel> findBoughtItemsByUserId(Long id);
}
