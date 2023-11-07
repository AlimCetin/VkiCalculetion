package com.alicetin.vkicalculetion.business.services.impl;


import com.alicetin.vkicalculetion.bean.ModelMapperBeanClass;
import com.alicetin.vkicalculetion.business.dto.RefarenceVkiDto;
import com.alicetin.vkicalculetion.business.dto.UserVkiDto;
import com.alicetin.vkicalculetion.business.services.IVkiServices;
import com.alicetin.vkicalculetion.data.entity.ReferenceVkiEntity;
import com.alicetin.vkicalculetion.data.entity.UserVkiEntity;
import com.alicetin.vkicalculetion.data.repository.IReferanceVkiRepository;
import com.alicetin.vkicalculetion.data.repository.IVkiRepository;
import com.alicetin.vkicalculetion.exception.Resource404NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

// LOMBOK
@RequiredArgsConstructor

// SERVICE
// Asıl is Yükünü yapan yer
@Service
public class VkiServicesImpl implements IVkiServices<UserVkiDto, UserVkiEntity, RefarenceVkiDto, ReferenceVkiEntity> {

    // Injection
    private final IVkiRepository iVkiRepository;
    private final IReferanceVkiRepository iReferanceVkiRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;

    @Override
    // Entity => Dto
    public UserVkiDto entityToDto(UserVkiEntity userVkiEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(userVkiEntity, UserVkiDto.class);
    }
    @Override
    //Dto => Entity
    public UserVkiEntity dtoToEntity(UserVkiDto userVkiDto) {
        return modelMapperBeanClass.modelMapperMethod().map(userVkiDto, UserVkiEntity.class);
    }
    @Override
    // Entity => Dto
    public RefarenceVkiDto entityToDtoRef(ReferenceVkiEntity referenceVkiEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(referenceVkiEntity, RefarenceVkiDto.class);
    }
    @Override
    //Dto => Entity
    public ReferenceVkiEntity dtoToEntityRef(RefarenceVkiDto refarenceVkiDto) {
        return modelMapperBeanClass.modelMapperMethod().map(refarenceVkiDto, ReferenceVkiEntity.class);
    }


    //Url ye girilen değer kadar veri oluşturuyoruz.
    @Override
    public List<UserVkiDto> vkiServiceSpeedData(Long key) {
        List<UserVkiDto> userVkiDtoList=new ArrayList<>();
        Random random = new Random();
        if (key != null) {
            for (int i = 1; i <=key ; i++) {
                UserVkiDto userVkiDto=UserVkiDto
                        .builder()
                        .uName("name "+(i%3))
                        .uKilo(random.nextInt(120))
                        .uHeight(random.nextInt(25)*10)
                        .build();
                UserVkiEntity userVkiEntity = dtoToEntity(userVkiDto);
                iVkiRepository.save(userVkiEntity);
                userVkiDto.setId(userVkiEntity.getId());
                userVkiDto.setSystemDate(userVkiEntity.getSystemDate());
                userVkiDtoList.add(userVkiDto);
            }
        }
        return userVkiDtoList;
    }
    // DeleteAll
    @Override
    public String vkiServiceDeleteAll() {
        iVkiRepository.deleteAll();
        return iVkiRepository.findAll().toString();
    }
    //FIND ID
    @Override
    public UserVkiDto vkiServiceFindById(Long id) {
        Optional<UserVkiEntity> findUserVkiEntity=iVkiRepository.findById(id);
        findUserVkiEntity.orElseThrow(()->new Resource404NotFoundException(id+ " nolu id yoktur"));
        UserVkiDto userVkiDto=entityToDto(findUserVkiEntity.get());
            return userVkiDto;

    }
    //FindByName
    @Override
    public UserVkiDto vkiServiceFindByName(String name) {
        Optional<UserVkiEntity> FindBySurnameEntity = iVkiRepository.findByRegistername(name);
        FindBySurnameEntity.orElseThrow(()->new Resource404NotFoundException(name+ " nolu id yoktur"));
        UserVkiDto userVkiDto = entityToDto(FindBySurnameEntity.get());
            return userVkiDto;
    }
    //Create
    @Transactional
    //Veritabanında değişiklik olduğunda  yazılan diğer yerleride etkiler.
    @Override
    public UserVkiDto vkiServiceCreate(UserVkiDto userVkiDto) {
            if (userVkiDto != null) {
                UserVkiEntity userVkiEntity = dtoToEntity(userVkiDto);
                iVkiRepository.save(userVkiEntity);
                userVkiDto.setId(userVkiEntity.getId());
                userVkiDto.setSystemDate(userVkiEntity.getSystemDate());
            }
            return userVkiDto;
    }
    //All List
    @Override
    public List<UserVkiDto> vkiServiceList() {
        Iterable<UserVkiEntity> userVkiEntityIterable = iVkiRepository.findAll();
        List<UserVkiDto> userVkiDtoList=new ArrayList<>();
        for(UserVkiEntity entity: userVkiEntityIterable ){
            // Entity Listesini ==> Dto Listesine çeviriyor / list e ekliyor.
            userVkiDtoList.add(entityToDto(entity));
        }
        return userVkiDtoList;
    }
    //Update
    @Transactional
    @Override
    public UserVkiDto vkiServiceUpdate(Long id, UserVkiDto userVkiDto) {
        // Öncelikle kaydını bulmalısın.
        UserVkiDto registerFindDto= vkiServiceFindById(id);
        //Entity Instance
        UserVkiEntity userVkiEntity = null;
        if(registerFindDto!=null){
            userVkiEntity=dtoToEntity(userVkiDto);
            // Set etmek için boş bir Dto nun Entitysi oluşturduk.
            userVkiEntity.setId(userVkiDto.getId());
            userVkiEntity.setUName(userVkiDto.getUName());
            userVkiEntity.setUKilo(userVkiDto.getUKilo());
            userVkiEntity.setUHeight(userVkiDto.getUHeight());
            iVkiRepository.save(userVkiEntity);
        }
        return entityToDto(userVkiEntity);
    }
    //DeleteById
    @Transactional
    @Override
    public UserVkiDto vkiServiceDeleteById(Long id) {
        // Öncelikle kaydını bulunsun
        UserVkiDto registerFindDto= vkiServiceFindById(id);
        if(registerFindDto!=null){
            iVkiRepository.deleteById(id);
        }
        return registerFindDto;
    }
    //Vki referans değerlerini gönderiyoruz.
    @Override
    public List<RefarenceVkiDto> referenceVkiService() {
        Iterable<ReferenceVkiEntity> refaeranceEntityIterable = iReferanceVkiRepository.findAll();
        List<RefarenceVkiDto> referanceDtoList=new ArrayList<>();
        for(ReferenceVkiEntity entity: refaeranceEntityIterable ){
            // Entity Listesini ==> Dto Listesine çeviriyor / list e ekliyor.
            referanceDtoList.add(entityToDtoRef(entity));
        }
        return referanceDtoList;
    }
} //End Class RegisterImpl
