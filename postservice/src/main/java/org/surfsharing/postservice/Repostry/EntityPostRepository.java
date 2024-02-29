package org.surfsharing.postservice.Repostry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surfsharing.postservice.Entity.EntityPost;
@Repository
public interface EntityPostRepository extends JpaRepository<EntityPost, Long> {

}