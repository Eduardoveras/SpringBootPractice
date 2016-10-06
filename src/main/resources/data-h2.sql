INSERT INTO users (username, firstname, lastname, pass, permission) VALUES ('admin', 'Administration', '', 'admin', TRUE );

INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('33234-2313-45', 'Carlos', 'Camacho', '809xxxxxxx', 'Santiago');

INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NFECK', 'Muebles');

INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVYIB', 'Mesas', 'PUCMM-FA-NFECK');

