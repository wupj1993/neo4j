package org.springframework.neo.repo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.neo.domain.QQ;
import org.springframework.stereotype.Repository;

/**
 * Name：QQRepository
 * Time：2016/2/3 23:35
 * author：WPJ587
 * description：QQ号实体
 **/
@Repository
public interface QQRepository extends GraphRepository<QQ> {
}
