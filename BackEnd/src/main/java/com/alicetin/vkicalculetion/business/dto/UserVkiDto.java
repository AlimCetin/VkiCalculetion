package com.alicetin.vkicalculetion.business.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// LOMBOK
@Data
//Veritabanı olduğunu belirliyor.
@AllArgsConstructor
//Clasın içindeki tüm Variable olduğu constructor
@NoArgsConstructor
//Boş bir Construtor
@Builder
// //Getter - Setter, toString gibi metotların otomatik oluşturur.
public final class UserVkiDto extends BaseDto implements Serializable {

    // Serileştirme vapıldı.
    public static final Long serialVersionUID=1L;

    //Variable
    @NotEmpty(message = "Adınızı boş olamaz.")
    private String uName;

    @NotEmpty(message = "Kilonuz boş olamaz.")
    private Float uKilo;

    @NotEmpty(message = "Boyunuz boş olamaz.")
    private Float uHeight;

} //End Class RegisterDto
