CREATE DATABASE orcl
   USER SYS IDENTIFIED BY tiger
   USER SYSTEM IDENTIFIED BY tiger
   LOGFILE GROUP 1 ('C:\oraclexe\app\oracle\oradata\orcl\redo01.log') SIZE 100M,
           GROUP 2 ('C:\oraclexe\app\oracle\oradata\orcl\redo02.log') SIZE 100M,
           GROUP 3 ('C:\oraclexe\app\oracle\oradata\orcl\redo03.log') SIZE 100M
   MAXLOGFILES 32
   MAXLOGMEMBERS 5
   MAXLOGHISTORY 1
   MAXDATAFILES 100
   MAXINSTANCES 16
   CHARACTER SET US7ASCII
   NATIONAL CHARACTER SET AL16UTF16
   EXTENT MANAGEMENT LOCAL
   DATAFILE 'C:\oraclexe\app\oracle\oradata\orcl\system01.dbf' SIZE 325M REUSE
   SYSAUX DATAFILE 'C:\oraclexe\app\oracle\oradata\orcl\sysaux01.dbf' SIZE 325M REUSE
   DEFAULT TABLESPACE users
      DATAFILE 'C:\oraclexe\app\oracle\oradata\orcl\users01.dbf'
      SIZE 500M REUSE AUTOEXTEND ON MAXSIZE UNLIMITED
   DEFAULT TEMPORARY TABLESPACE tempts1
      TEMPFILE 'C:\oraclexe\app\oracle\oradata\orcl\temp01.dbf'
      SIZE 20M REUSE
   UNDO TABLESPACE undotbs
      DATAFILE 'C:\oraclexe\app\oracle\oradata\orcl\undotbs01.dbf'
      SIZE 200M REUSE AUTOEXTEND ON MAXSIZE UNLIMITED;
