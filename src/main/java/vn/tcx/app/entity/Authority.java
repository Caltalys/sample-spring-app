package vn.tcx.app.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "vai_tro")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 200)
    @Id
    @Column(length = 200, name="ten_vai_tro")
    private String tenVaiTro;

    @Size(max = 500)
    @Column(length = 500, name="mo_ta")
    private String moTa;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Authority)) {
            return false;
        }
        return Objects.equals(tenVaiTro, ((Authority) o).tenVaiTro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tenVaiTro);
    }

    @Override
    public String toString() {
        return "VaiTro{" +
            "tenVaiTro='" + tenVaiTro + '\'' +
            "}";
    }

}
