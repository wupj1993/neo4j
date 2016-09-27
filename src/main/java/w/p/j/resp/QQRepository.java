package w.p.j.resp;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import w.p.j.domain.QQ;

/**
 * Name：QQRepository
 * Time：2016/9/26 15:54
 * author：WPJ587
 * description：qq操作的Repository
 **/
@Repository
public interface QQRepository extends GraphRepository<QQ> {

}
