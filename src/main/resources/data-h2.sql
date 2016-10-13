INSERT INTO users (username, firstname, lastname, pass, permission) VALUES ('admin', 'Administration', '', 'admin', TRUE );

INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('1', 'Carlos', 'Camacho', '809xxxxxxx', 'Santiago');
INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('2', 'Maximo', 'Perez', '809xxxxxxx', 'Santiago');
INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('3', 'Lisibonny', 'Beato', '809xxxxxxx', 'Santiago');
INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('4', 'Roberto', 'Abrue', '809xxxxxxx', 'Santo Domingo');

INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NFECK', 'Muebles');
INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NFRDK', 'Maquinaria');
INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NARDK', 'Dispositivos');

INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVYIB', 'Mesas', 'PUCMM-FA-NFECK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JAYIB', 'Motores', 'PUCMM-FA-NFRDK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVAIB', 'Computadoras', 'PUCMM-FA-NARDK');

INSERT INTO equipment (equipment_id, equipment_name, stock, sub_family_skey) VALUES ('PUCMM-E-87YJVGH', 'Desktop', 50, 'PUCMM-SFA-JVAIB');
INSERT INTO equipment (equipment_id, equipment_name, stock, sub_family_skey) VALUES ('PUCMM-E-8765VGH', 'Laptop', 1, 'PUCMM-SFA-JVAIB');

//INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c3ecwc', true, 100.54, '20-NOV-2016', '9-OCT-2016', '3', 'PUCMM-E-8765VGH');
//INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c4rcwc', true, 100.54, '9-OCT-2016', '1-OCT-2016', '4', 'PUCMM-E-8765VGH');