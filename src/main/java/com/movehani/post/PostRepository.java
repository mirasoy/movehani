package com.movehani.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movehani.group.AthleticGroup;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


	List<Post> findByAthleticGroupGroupSn(long l);


}
