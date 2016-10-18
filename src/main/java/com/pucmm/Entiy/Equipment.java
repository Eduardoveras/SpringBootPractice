/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Entiy;

import org.apache.mina.util.Base64;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "equipment")
public class Equipment implements Serializable{
    // Attributes
    @Id
    private String equipmentId;
    private String equipmentName;
    @Column(length = 5000000)
    private Byte[] image;
    @ManyToOne
    private SubFamily subFamily;
    private Integer stock;

    // Constructors
    public Equipment(){

    }

    public Equipment(String equipmentName, Byte[] image, SubFamily subFamily, Integer stock){
        this.setEquipmentId("PUCMM-E-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setEquipmentName(equipmentName);
        this.setImage(image);
        this.setSubFamily(subFamily);
        this.setStock(stock);
    }

    // Auxiliary Function
    public Family getFamily(){
        return subFamily.getFamily();
    }

    // Getters and Setters
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public SubFamily getSubFamily() {
        return subFamily;
    }

    public void setSubFamily(SubFamily subFamily) {
        this.subFamily = subFamily;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        if(this.image == null)
            return null;

        byte[] imgBytesAsBase64 = Base64.encodeBase64(toPrimitives(this.image));
        return new String(imgBytesAsBase64);
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    // Auxiliary Function
    private byte[] toPrimitives(Byte[] buffer) {

        byte[] bytes = new byte[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            bytes[i] = buffer[i];
        }
        return bytes;

    }
}
