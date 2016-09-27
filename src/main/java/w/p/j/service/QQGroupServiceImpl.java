package w.p.j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import w.p.j.domain.QQGroup;
import w.p.j.resp.QQGroupRepository;

/**
 * Name：QQGroupServiceImpl
 * Time：2016/9/26 16:21
 * author：WPJ587
 * description：qq群主
 */
@org.springframework.stereotype.Service
public class QQGroupServiceImpl extends GenericService<QQGroup> implements QQGroupService {
    @Autowired
    private QQGroupRepository qqGroupRepository;
    @Override
    public GraphRepository<QQGroup> getRepository() {

        return qqGroupRepository;
    }


}
