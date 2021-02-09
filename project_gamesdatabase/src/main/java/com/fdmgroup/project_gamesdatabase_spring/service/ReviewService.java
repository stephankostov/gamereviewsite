package com.fdmgroup.project_gamesdatabase_spring.service;

import com.fdmgroup.project_gamesdatabase_spring.model.Review;
import com.fdmgroup.project_gamesdatabase_spring.repository.ReviewDao;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private static Logger LOGGER = LogManager.getLogger(ReviewService.class);

    @Autowired
    private ReviewDao reviewDao;

    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public void create(Review review) {
        reviewDao.save(review);
    }

    public Optional<Review> retrieve(long reviewId) {
        return reviewDao.findById(reviewId);
    }

    public List<Review> retrieveAll() { return reviewDao.findAll();
    }

    public void update(Review reviewFromDb) {
        Optional<Review> reviewToUpdate = reviewDao.findById(reviewFromDb.getId());
        if (reviewToUpdate.isPresent()) {
            reviewDao.save(reviewFromDb);
        } else {
            LOGGER.info("No such review in database");
        }
    }

    public boolean delete(long reviewId) {
        reviewDao.deleteById(reviewId);
        return true;
    }

}
