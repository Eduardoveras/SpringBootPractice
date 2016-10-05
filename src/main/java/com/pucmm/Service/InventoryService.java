/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Service;

import com.pucmm.Entiy.Equipment;
import com.pucmm.Entiy.Family;
import com.pucmm.Entiy.SubFamily;
import com.pucmm.Repository.EquipmentRepository;
import com.pucmm.Repository.FamilyRepository;
import com.pucmm.Repository.SubFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private SubFamilyRepository subFamilyRepository;

    // Family Related Functions
    public void registerNewFamily(String familyName){
        if (doesFamilyNameExist(familyName))
            throw new IllegalArgumentException("\n\nThe family name: " + familyName + "is unavailable");

        familyRepository.save(new Family(familyName));
    }

    public Family findFamily(String familyKey){
        return familyRepository.findByFamilyKey(familyKey);
    }

    public List<Family> findAllFamilies(){
        return familyRepository.findAll();
    }

    // SubFamily Related Functions
    public void registerSubFamily(String subFamilyName, String familyKey){
        if (!doesFamilyKeyExist(familyKey))
            throw new IllegalArgumentException("\n\nThis family key is invalid");

        if (doesSubFamilyNameExist(subFamilyName))
            throw new IllegalArgumentException("\n\nThis sub-family name: " + subFamilyName + " is unavailable");

        subFamilyRepository.save(new SubFamily(subFamilyName, familyRepository.findByFamilyKey(familyKey)));
    }

    public SubFamily findSubFamily(String subFamilyKey){
        return subFamilyRepository.findBySubFamilyKey(subFamilyKey);
    }

    public List<SubFamily> findAllSubFamiliesOfFamily(String familyKey){
        return subFamilyRepository.findByFamilyKey(familyKey);
    }

    public List<SubFamily> findAllSubFamilies(){
        return subFamilyRepository.findAll();
    }

    // Equipment Related Functions
    public void registerNewEquipment(String equipmentName, String subFamilyKey, Integer stock){
        if (doesEquipmentNameExist(equipmentName))
            throw new IllegalArgumentException("\n\nThis equipment name: " + equipmentName + " is unavailable");

        if (!doesSubFamilyKeyExist(subFamilyKey))
            throw new IllegalArgumentException("\n\nThis subfamily key is invalid");

        if (stock <= 0)
            throw new IllegalArgumentException("\n\nThe stock quantity must be positive");

        equipmentRepository.save(new Equipment(equipmentName, subFamilyRepository.findBySubFamilyKey(subFamilyKey), stock));
    }

    public void restockEquipment(String equipmentId, Integer stock){ // This function ADDS to the already existing stock; DOES NOT MODIFY
        if (!doesEquipmentIdExist(equipmentId))
            throw new IllegalArgumentException("\n\nThis equipment id is invalid");

        if (stock <= 0)
            throw new IllegalArgumentException("\n\nThe stock quantity must be positive");

        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        equipment.setStock(equipment.getStock() + stock);

        equipmentRepository.save(equipment);
    }

    // Auxiliary Functions
    private boolean doesFamilyNameExist(String familyName){
        Family family = familyRepository.findByFamilyName(familyName);

        return (family != null);
    }

    private boolean doesFamilyKeyExist(String familyKey){
        Family family = familyRepository.findByFamilyKey(familyKey);

        return (family != null);
    }

    private boolean doesSubFamilyNameExist(String subFamilyName){
        SubFamily subFamily = subFamilyRepository.findBySubFamilyName(subFamilyName);

        return (subFamily != null);
    }

    private boolean doesSubFamilyKeyExist(String subFamilyKey){
        SubFamily subFamily = subFamilyRepository.findBySubFamilyKey(subFamilyKey);

        return (subFamily != null);
    }

    private boolean doesEquipmentNameExist(String equipmentName){
        Equipment equipment = equipmentRepository.findByEquipmentName(equipmentName);

        return (equipment != null);
    }

    private boolean doesEquipmentIdExist(String equipmentId){
        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        return (equipment != null);
    }
}
