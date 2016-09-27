package w.p.j.domain;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Name：QQ
 * Time：2016/9/26 15:35
 * author：WPJ587
 * description：qq用户信息
 **/
@NodeEntity
public class QQ  extends BaseDomain{
    private static final long serialVersionUID = -3929963858388442438L;
    /**
     * QQ号码
     */
    private String number;
    /**
     * QQ 使用年限
     */
    private float age;
    /**
     * qq名字
     */
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
