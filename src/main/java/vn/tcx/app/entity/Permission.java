package vn.tcx.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * An permission to do something
 */
@Entity
@Table(name = "quyen")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Setter
@Builder
public class Permission extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 7278280293100145621L;

	@Id
	@NotNull
	@Column(name = "ma_quyen", nullable = false)
    private String maQuyen;
	
	@NotNull
    @Size(max = 200)
    @Column(length = 200, name="ten_quyen", nullable = false)
    private String tenQuyen;
	
    @Column(name = "so_thu_tu", nullable = false)
    private int soThuTu;
    
    @Size(max = 500)
    @Column(length = 500, name="mo_ta")
    private String moTa;

}
