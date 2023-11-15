package com.alicetin.vkicalculetion.business.dto;

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
public final class RefarenceVkiDto extends BaseDto implements Serializable {

    // Serileştirme vapıldı.
    public static final Long serialVersionUID=1L;

    //Variable
    private String vkiExplanation;
    private Integer minReference;
    private Integer maxReference;


} //End Class RegisterDto
