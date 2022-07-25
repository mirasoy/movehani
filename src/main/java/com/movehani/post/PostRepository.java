package com.movehani.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Repository;

import com.movehani.group.AthleticGroup;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


	List<Post> findByAthleticGroupGroupSn(long l);

	Page<Post> getPostByAthleticGroupGroupSn(long groupSn, Pageable assembler);


}
