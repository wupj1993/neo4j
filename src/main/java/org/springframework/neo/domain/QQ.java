package org.springframework.neo.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Name：QQ
 * Time：2016/2/3 23:10
 * author：WPJ587
 * description：QQ实体
 **/

public class QQ {
    private static final String LIVE_DIE_FRIEND="生死之交";
    private static final String STRANGER_FRIEND="陌生人";
    private static final String COMMON_FRIEND="普通朋友";
    @GraphId
    private Long id;
    private String QQName;
    private String QQNumber;
    private String Other;

    public QQ(String QQName, String QQNumber) {
        this.QQName = QQName;
        this.QQNumber = QQNumber;
    }
    // 生死之交
    private Set<QQ> liveDie=new HashSet<>();
    private Set<QQ> stanger=new HashSet<>();
    private Set<QQ> common=new HashSet<>();
    @Relationship(type = LIVE_DIE_FRIEND)
    public Set<QQ> getLiveDie() {
        return liveDie;
    }
    @Relationship(type = LIVE_DIE_FRIEND)
    public void setLiveDie(Set<QQ> liveDie) {
        this.liveDie.clear();
        this.liveDie = liveDie;
    }
    @Relationship(type = STRANGER_FRIEND)
    public void setStanger(Set<QQ> stanger) {
        this.stanger.clear();
        this.stanger = stanger;
    }
    @Relationship(type = STRANGER_FRIEND)
    public Set<QQ> getStanger() {
        return stanger;
    }
    @Relationship(type = COMMON_FRIEND)
    public Set<QQ> getCommon() {
        return common;
    }
    @Relationship(type = COMMON_FRIEND)
    public void setCommon(Set<QQ> common) {
        this.common.clear();
        this.common = common;
    }

    public void addQQToLiveDie(QQ otherQQ){
        liveDie.add(otherQQ);
        // 把关系对称
        otherQQ.liveDie.add(this);
    }
    public void addQQToCommon(QQ otherQQ){
        common.add(otherQQ);
        otherQQ.common.add(this);
    }
    public void addQQToStranger(QQ otherQQ){
        stanger.add(otherQQ);
        otherQQ.stanger.add(this);
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQQName() {
        return QQName;
    }

    public void setQQName(String QQName) {
        this.QQName = QQName;
    }

    public String getQQNumber() {
        return QQNumber;
    }

    public void setQQNumber(String QQNumber) {
        this.QQNumber = QQNumber;
    }
}
