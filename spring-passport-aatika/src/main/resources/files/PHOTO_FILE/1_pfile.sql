db_name='orcl'
memory_target=1G
processes = 150
audit_file_dest='C:/oraclexe/app/oracle/admin/orcl/adump'
audit_trail ='db'
db_block_size=8192
db_domain=''
db_recovery_file_dest='C:/oraclexe/app/oracle/fast_recovery_area'
db_recovery_file_dest_size=2G
diagnostic_dest='C:/oraclexe/app/oracle'
dispatchers='(PROTOCOL=TCP) (SERVICE=orcl)'
open_cursors=300 
remote_login_passwordfile='EXCLUSIVE'
undo_tablespace='undotbs'
# You may want to ensure that control files are created on separate physical
# devices
control_files = (C:/oraclexe/app/oracle/oradata/orcl/ora_control1, C:/oraclexe/app/oracle/oradata/orcl/ora_control2)
compatible ='11.1.0'