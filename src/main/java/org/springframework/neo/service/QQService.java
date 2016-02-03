package org.springframework.neo.service;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.query.Pagination;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.neo.domain.QQ;
import org.springframework.neo.domain.World;
import org.springframework.neo.repo.QQRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Name：QQService
 * Time：2016/2/3 23:36
 * author：WPJ587
 * description：QQ业务
 **/
@Service
@Transactional
public class QQService {
    @Autowired
    QQRepository qqRepository;
    @Autowired
    Session session;
    // 获取qq号总数
    public long getNumberOfQQ() {
        return qqRepository.count();
    }
    // 创建qq
    public QQ createQQ(String QQname, String QQnumber) {
        return qqRepository.save(new QQ(QQname, QQnumber));
    }
    // 获取所有qq
    public Iterable<QQ> getAllWorlds() {
        return qqRepository.findAll();
    }
    // 根据id 获取qq
    public QQ findQQById(Long id) {
        return qqRepository.findOne(id);
    }
    // 根据qq号获取与他相关的人
    public Iterable<QQ> findAllByNumberOfMoons(int numberOfMoons) {
        return findByProperty("QQNumber", numberOfMoons);
    }
    private Iterable<QQ> findByProperty(String propertyName, Object propertyValue) {
        return session.loadAll(QQ.class, new Filter(propertyName, propertyValue));
    }
    public Iterable<QQ> findAllQQs(Pagination paging) {
        return session.loadAll(QQ.class, paging, 0);

    }
    public Iterable<QQ> findAllQQs(Sort sort) {
        return qqRepository.findAll(sort, 0);

    }
    // 根据深度遍历
    public Iterable<QQ> findByProperty(String propertyName, Object propertyValue, int depth) {
        return session.loadAll(QQ.class, new Filter(propertyName, propertyValue), depth);
    }
    // 分页获取
    public Page<QQ> findAllQQs(Pageable pageable) {
        return qqRepository.findAll(pageable, 0);
    }
    public Iterable<QQ> findAllQQs(Sort sort, int depth) {
        return qqRepository.findAll(sort, depth);
    }

}
