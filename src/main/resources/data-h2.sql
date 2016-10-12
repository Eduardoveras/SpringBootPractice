INSERT INTO users (username, firstname, lastname, pass, permission) VALUES ('admin', 'Administration', '', 'admin', TRUE );

INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('1', 'Carlos', 'Camacho', '809xxxxxxx', 'Santiago');

INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NFECK', 'Muebles');
INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NFRDK', 'Maquinaria');
INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NARDK', 'Dispositivos');

INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVYIB', 'Mesas', 'PUCMM-FA-NFECK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JAYIB', 'Motores', 'PUCMM-FA-NFRDK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVAIB', 'Computadoras', 'PUCMM-FA-NARDK');

