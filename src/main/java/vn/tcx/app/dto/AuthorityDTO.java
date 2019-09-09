package vn.tcx.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AuthorityDTO {

    private Long id;
    
    @NotBlank
    @Size(min = 1, max = 200)
    private String maVaiTro;

    @NotBlank
    @Size(min = 1, max = 200)
    private String tenVaiTro;
    
    private String moTa;
    
    private boolean daXoa = false;
}
