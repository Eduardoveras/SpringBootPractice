/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Service;

import Entiy.Family;
import Entiy.SubFamily;
import Repository.EquipmentRepository;
import Repository.FamilyRepository;
import Repository.SubFamilyRepository;
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
}
