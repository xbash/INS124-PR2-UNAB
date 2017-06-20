DROP TABLE Empleado;

CREATE TABLE Empleado (
Employee_ID INTEGER(11), 
Nombre VARCHAR(30),
CONSTRAINT PK_Empleado PRIMARY KEY(Employee_ID)
);

INSERT INTO Empleado VALUES(2223, 'Juan'),(3368, 'Sonia'), (4434, 'Pablo'), (5478, 'Manuel');
