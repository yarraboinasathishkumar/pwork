--SQL Create Database 
CREATE DATABASE databasename;
CREATE DATABASE testDB;

--SQL DROP DATABASE 
DROP DATABASE databasename;
DROP DATABASE testDB;

---SQL Backup Database for SQL Server
-- Create full backup of existing database 
BACKUP DATABASE databasename
TO DISK = 'filepath';
BACKUP DATABASE testDB
TO DISK = 'D:\backups\testDB.bak';
-- Differential backs up the database that have changed since the last full backup
BACKUP DATABASE databasename
TO DISK = 'filename'
WITH DIFFERENTIAL;

BACKUP DATABASE testDB
TO DISK = 'D:\backups\testDB.bak'
WITH DIFFERENTIAL;

--Create Table
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    ...
);
CREATE TABLE Persons (
    PersonID INT,
    LastName VARCHAR2(255),
    FirstName VARCHAR2(255),
    Address VARCHAR2(255),
    City VARCHAR2(255),
);

--Create Table Using Another Table



