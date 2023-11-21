package com.movielike.app.dao;

import com.movielike.app.domain.ReviewDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReviewDao {

    @Autowired
    SqlSession session;

    String namespace = "com.movielike.app.dao.reviewMapper.";

    public List<ReviewDto> selectBestReview(int movId) {
        return session.selectList(namespace + "selectBestReview", movId);
    }

    public int insertReview(ReviewDto reviewDto) {
        return session.insert(namespace + "insertReview", reviewDto);
    }

    public List<ReviewDto> selectMovieReviewList(Map<String, Integer> map) {
        return session.selectList(namespace + "selectMovieReviewList", map);
    }

    public int selectReviewLikeOne(ReviewDto reviewDto) {
        return session.selectOne(namespace + "selectReviewLikeOne", reviewDto);
    }


    public int insertReviewLike(ReviewDto reviewDto) {
        return session.insert(namespace + "insertReviewLike", reviewDto);
    }

    public int updateReviewLike(Map<String, Integer> map) {
        return session.update(namespace + "updateReviewLike", map);
    }

    public int deleteReviewLike(ReviewDto reviewDto) {
        return session.delete(namespace + "deleteReviewLike", reviewDto);
    }
}
