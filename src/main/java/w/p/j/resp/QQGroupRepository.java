package w.p.j.resp;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import w.p.j.domain.QQGroup;

/**
 * Created by WPJ587 on 2016/9/26.
 */
@Repository
public interface QQGroupRepository  extends GraphRepository<QQGroup> {
}
