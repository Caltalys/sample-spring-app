package vn.tcx.app.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "vai_tro")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max = 200)
    @Column(length = 200, name="ma_vai_tro")
    private String maVaiTro;

    @NotNull
    @Size(max = 200)
    @Column(length = 200, name="ten_vai_tro")
    private String tenVaiTro;
    
    @Size(max = 500)
    @Column(length = 500, name="mo_ta")
    private String moTa;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "vaitro_quyen",
        joinColumns = {@JoinColumn(name = "vai_tro_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "ma_quyen", referencedColumnName = "ma_quyen")}
        )
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    @Builder.Default
    private Set<Permission> quyens = new HashSet<>();

}
