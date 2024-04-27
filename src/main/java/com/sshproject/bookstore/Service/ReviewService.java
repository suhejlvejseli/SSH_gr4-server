package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Review;
import com.sshproject.bookstore.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements ReviewServiceInterface {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public int addReview(Review review) {
        Review newReview = new Review(review.getUser_id(), review.getOrdered_book_id(), review.getRating_value(), review.getComment());
        reviewRepository.save(newReview);
        return newReview.getUser_id(); // Or you can return newReview.getId() if it's the review ID you want to return
    }

    @Override
    public void deleteReview(int reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        reviewOptional.ifPresent(reviewRepository::delete);
    }
}
