package com.fdmgroup.project_gamesdatabase.repository;

import com.fdmgroup.project_gamesdatabase.model.Game;
import com.fdmgroup.project_gamesdatabase.model.Review;
import com.fdmgroup.project_gamesdatabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ReviewDao extends JpaRepository<Review, Long> {

    @Query("SELECT AVG(rating) FROM Review WHERE game=:game")
    Optional<Double> getAverageGameRating(@Param("game") Game game);

    Optional<Review> getByUserAndGame(@Param("user") User user, @Param("game") Game game);

}
