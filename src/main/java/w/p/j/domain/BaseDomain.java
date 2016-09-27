package w.p.j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.io.Serializable;

/**
 * Name：BaseDomain
 * Time：2016/9/26 15:37
 * author：WPJ587
 * description：
 **/
@JsonIdentityInfo(generator = JSOGGenerator.class)

public abstract class BaseDomain implements Serializable {
    private static final long serialVersionUID = -1133011693267559711L;
    @JsonProperty("id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || id == null || getClass() != o.getClass()) return false;

        BaseDomain entity = (BaseDomain) o;

        if (!id.equals(entity.id)) return false;

        return true;
    }
}
