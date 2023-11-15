package com.alicetin.vkicalculetion.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//LOMBOK
@Getter
@Setter

// abstract CLASS
@MappedSuperclass
//Entity clasını miras almasıiçin yapıyoruz.
@JsonIgnoreProperties(value={},allowGetters = true)
//JsonIgnoreProperties= datadan gelen id ,systemDate verileri gösterme
// json buradaki verileri göz ardı etme

abstract public class BaseEntity implements Serializable {

    // Serileştirme yapıldı.
    public static final Long serialVersionUID=1L;

    // ID : import jakarta.persistence.Id;
    @Id
    //Primary key olarak Id verildi.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Otomatik olarak oluşturuyor.
    @Column(name = "id")
    protected  Long id;

    // DATE
    @Builder.Default // Lombok Default
    @Temporal(TemporalType.TIMESTAMP)
    //şu anki zamanı gösteriyor.
    protected Date systemDate;

} //End Class
