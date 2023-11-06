package com.alicetin.vkicalculetion.data.entity;

import com.hamitmizrak.tech_3_springreact.data.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
//Getter - Setter, toString gibi metotların otomatik oluşturur.
//Kullanımı
//XX xx = XX.builder()
//       .name("metin")
//       .build();
//       System.out.println(xx.getName()); => @Builder get otmatik oluşturdu

// ENTITY
@Entity
//veritabanının tablo kısmını,Veritabanındaki verilerle bağlantıyı ve sorguları otomatik olşturur.
@Table(name = "referenceVki")
//Tabloya isim veriyoruz. Yazmazsak RegisterEntity (classın ismi) olarak oluşturur.
public class ReferenceVkiEntity extends BaseEntity implements Serializable {

    // Serileştirme yapıldı.
    public static final Long serialVersionUID = 1L;

    //Variable
    //Tabloda sütun oluşturuyoruz. nullable=null değeri alabilme ,updatable=güncellenebilir ,insertable=yazılabilir
    // columnDefinition=sütunun tipi
    @Column(name = "vki_explanation")
    private String vkiExplanation;

    @Column(name = "min_reference")
    private Integer minRreference;

    @Column(name = "max_reference")
    private Integer maxReference;
}//End Class

