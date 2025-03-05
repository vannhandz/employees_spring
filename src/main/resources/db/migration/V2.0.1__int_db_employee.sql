CREATE TABLE department
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)       NULL,
    CONSTRAINT pk_department PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id               INT AUTO_INCREMENT NOT NULL,
    name             VARCHAR(255)       NULL,
    birth            date               NULL,
    gender           VARCHAR(255)       NULL,
    salary           DOUBLE             NULL,
    phone            VARCHAR(255)       NULL,
    id_department_id INT                NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_IDDEPARTMENT FOREIGN KEY (id_department_id) REFERENCES department (id);

