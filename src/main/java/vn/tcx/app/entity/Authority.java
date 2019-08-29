package vn.tcx.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "vai_tro")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class Authority extends AbstractAuditingEntity implements Serializable {

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
    public String toString() {
        return "VaiTro{" +
            "tenVaiTro='" + tenVaiTro + '\'' +
            "}";
    }

}
