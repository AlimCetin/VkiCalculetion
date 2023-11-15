package com.alicetin.vkicalculetion.data.entity;

import com.alicetin.vkicalculetion.data.BaseEntity;
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
@Table(name = "userVki")
//Tabloya isim veriyoruz. Yazmazsak RegisterEntity (classın ismi) olarak oluşturur.
public class UserVkiEntity extends BaseEntity implements Serializable {

    // Serileştirme yapıldı.
    public static final Long serialVersionUID = 1L;

    //Variable
    //Tabloda sütun oluşturuyoruz. nullable=null değeri alabilme ,updatable=güncellenebilir ,insertable=yazılabilir
    // columnDefinition=sütunun tipi
    @Column(name = "u_name")
    private String uName;

    @Column(name = "u_kilo")
    private Float uKilo;

    @Column(name = "u_height")
    private Float uHeight;
}//End Class

