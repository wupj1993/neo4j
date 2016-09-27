package w.p.j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import w.p.j.domain.QQ;
import w.p.j.resp.QQRepository;

/**
 * Name：QQServiceImpl
 * Time：2016/9/26 15:52
 * author：WPJ587
 * description：qq业务层
 **/
@org.springframework.stereotype.Service("qqService")
public class QQServiceImpl extends GenericService<QQ>  implements QQService{
    @Autowired
    private QQRepository qqRepository;
    @Override
    public GraphRepository<QQ> getRepository() {
        return qqRepository;
    }
}
