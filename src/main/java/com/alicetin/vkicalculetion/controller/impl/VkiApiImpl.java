package com.alicetin.vkicalculetion.controller.impl;

import com.alicetin.vkicalculetion.business.dto.RefarenceVkiDto;
import com.alicetin.vkicalculetion.business.dto.UserVkiDto;
import com.alicetin.vkicalculetion.business.services.IVkiServices;
import com.alicetin.vkicalculetion.controller.IVkiApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
//Class içinde final ve NonNull(boş değer olmayan) olan değişkenleri
//parametre olarak alan bir constructor oluşturur.
// API
@RestController
//Api Controlleri olduğunu bildiriyor.
//gelen verileri değiştirmeden döndürür.
@RequestMapping("/api")
//Url nin kökünü oluşturur ==> http://localhost:3737/api
@CrossOrigin
// CORSS Hatası almamak için
//CorssOrigin web portu ile backend portu farklı ise onu bildiriyoruz.
//@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL)
//buarda değişken olarak atayabiliriz.
//GetMapping  = Veri isterken
//PostMapping = Veri eklerken
//PutMapping  = Veri güncellerken
//@DeleteMapping =Veri silerken
//@Valid = apiye gelen bilgiyi berlirlediğim kritere uygun mu diye kontrol eder.
//@PathVariable = parametre alır speed-data/1   == / ==
//@RequestParam = parametre alır /search?name=ali  == ? ==
//@RequestBody  = obje alır
public class VkiApiImpl implements IVkiApi<UserVkiDto, RefarenceVkiDto> {

    // Variable
    private final IVkiServices iVkiServices;

    //SPEED DATA
    @Override
    @GetMapping("/speed-data/{id}")
    public ResponseEntity<List<UserVkiDto>> vkiServiceSpeedData(@PathVariable(name="id") Long key) {
            return ResponseEntity.ok(iVkiServices.vkiServiceSpeedData(key));
    }

    //DELETE ALL
    @Override
    @GetMapping("/delete/all")
    public ResponseEntity<?> vkiServiceDeleteAll() {
            return ResponseEntity.ok(iVkiServices.vkiServiceDeleteAll());
    }

    //FIND ID
    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<?> vkiServiceFindById(@PathVariable(name = "id")Long id) {
            return ResponseEntity.ok(iVkiServices.vkiServiceFindById(id));
    }

    //FIND BY NAME
    @Override
    @GetMapping("/search")
    public ResponseEntity<List<UserVkiDto>> vkiServiceFindByName(@RequestParam String uName) {
            return ResponseEntity.ok(iVkiServices.vkiServiceFindByName(uName));
    }
    //CREATE
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> vkiServiceCreate(UserVkiDto userVkiDto) {
            return ResponseEntity.ok(iVkiServices.vkiServiceCreate(userVkiDto)) ;
    }

    // LIST ALL
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<UserVkiDto>> vkiServiceList() {

            return ResponseEntity.ok().body(iVkiServices.vkiServiceList());
    }

    //UPDATE
    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> vkiServiceUpdate(@PathVariable(name="id")Long id, @RequestBody UserVkiDto userVkiDto) {
            return ResponseEntity.status(HttpStatus.OK).body(iVkiServices.vkiServiceUpdate(id,userVkiDto));
        }

    //DELETE ID
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> vkiServiceDeleteById(@PathVariable(name="id") Long id) {
       return ResponseEntity.ok(iVkiServices.vkiServiceDeleteById(id));
    }

    //REFERENCE VKI
    @Override
    @GetMapping("/referenceVki")
    public ResponseEntity<List<RefarenceVkiDto>> referenceVkiService() {
        return ResponseEntity.ok().body(iVkiServices.referenceVkiService());
    }
} //End Class RegisterApiIpl
