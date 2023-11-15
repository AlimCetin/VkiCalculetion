package com.alicetin.vkicalculetion.controller;
import org.springframework.http.ResponseEntity;

import java.util.List;
// ResponseEntity sınıfı HttpEntity sınıfına ek olarak builder tasarım desenini kullanarak
// isteğe yanıt olarak header bilgisi, HTTP durum kodu gibi bilgileri eklemeyi sağlar
// D:RegiterDto
// F:ReferenceDto
public interface IVkiApi<D,F> {

    // SPEED DATA
    public ResponseEntity<List<D>> vkiServiceSpeedData(Long key);

    // ALL DELETE
    public ResponseEntity<?> vkiServiceDeleteAll();

    //FIND ID
    public ResponseEntity<?> vkiServiceFindById(Long id);

    // FIND SURNAME
    public ResponseEntity<List<D>> vkiServiceFindByName(String uName);

    // CREATE
    public ResponseEntity<?> vkiServiceCreate(D d);

    // LIST
    public ResponseEntity<List<D>> vkiServiceList();

    // UPDATE
    public ResponseEntity<?> vkiServiceUpdate(Long id, D d);

    // DELETE ID
    public ResponseEntity<?> vkiServiceDeleteById(Long id);

    //REFERENCE VKI
    public ResponseEntity<List<F>> referenceVkiService();

} //End Interface IRegisterApi

