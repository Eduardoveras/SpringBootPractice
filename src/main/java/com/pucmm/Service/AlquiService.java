/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Service;

import com.pucmm.Repository.ReceiptRepository;
import com.pucmm.Repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlquiService {
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private ReceiptRepository receiptRepository;


}
