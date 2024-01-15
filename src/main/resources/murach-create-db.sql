DROP DATABASE IF EXISTS murach;
CREATE DATABASE murach;
USE murach;

-- Create the tables
CREATE TABLE Products (
    ProductCode varchar(10)     PRIMARY KEY     NOT NULL,
    Description varchar(255)    UNIQUE          NOT NULL,
    Price       DOUBLE          NOT NULL
);

CREATE TABLE LineItems (
    LineItemID  INTEGER PRIMARY KEY     NOT NULL AUTO_INCREMENT, 
    InvoiceID   INTEGER                 NOT NULL,
    ProductCode varchar(10)             NOT NULL,
    Quantity    INTEGER                 NOT NULL,
    FOREIGN KEY(ProductCode) REFERENCES Products(ProductCode),
    CONSTRAINT li_pdt unique (InvoiceID, ProductCode)
);

-- Populate the Products table
INSERT INTO Products VALUES
('java', 'Murach''s Java Programming', 57.50);

INSERT INTO Products VALUES
('jsp', 'Murach''s Java Servlets and JSP', 57.50);

INSERT INTO Products VALUES
('mysql', 'Murach''s MySQL', 54.50);

INSERT INTO Products VALUES
('orac', 'Murach''s Oracle and PL/SQL', 54.50);

INSERT INTO Products VALUES
('andr', 'Murach''s Android Programming', 57.50);

INSERT INTO Products VALUES
('html', 'Murach''s HTML and CSS', 54.50);

INSERT INTO Products VALUES
('jscr', 'Murach''s JavaScript and jQuery', 54.50);


-- Populate the LineItems table
INSERT INTO LineItems VALUES
(1, 1, 'java', 5);

INSERT INTO LineItems VALUES
(2, 1, 'jsp', 5);

INSERT INTO LineItems VALUES
(3, 2, 'mysql', 1);

INSERT INTO LineItems VALUES
(4, 3, 'andr', 1);

INSERT INTO LineItems VALUES
(5, 3, 'orac', 2);

INSERT INTO LineItems VALUES
(6, 4, 'html', 1);

INSERT INTO LineItems VALUES
(7, 5, 'java', 1);

INSERT INTO LineItems VALUES
(8, 5, 'mysql', 5);

-- create a user and grant privileges to that user
DROP USER IF EXISTS murach_user@localhost;
CREATE USER murach_user@localhost IDENTIFIED BY 'sesame';
GRANT SELECT, INSERT, DELETE, UPDATE ON murach.* TO murach_user@localhost;