package w.p.j.domain;

import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Name：QQGroup
 * Time：2016/9/26 15:39
 * author：WPJ587
 * description：qq群
 **/

public class QQGroup extends BaseDomain {
    private static final long serialVersionUID = 4300663468995800728L;
    /**
     * qq群号
     */
    private String number;
    /**
     * qq 群名
     */
    private String name;
    /**
     * 群主
     */
    @Relationship(type = "群主",direction=Relationship.INCOMING)
    private QQ master;
    /**
     * qq群成员
     */
    @Relationship(type = "GROUP_MEMBER",direction = "成员")
    private Set<QQ> member;

    public QQGroup() {
        this.member = new HashSet<>();
    }

    public Set<QQ> getMember() {
        return member;
    }

    public void setMember(Set<QQ> member) {
        this.member = member;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QQ getMaster() {
        return master;
    }

    public void setMaster(QQ master) {
        this.master = master;
    }
}
