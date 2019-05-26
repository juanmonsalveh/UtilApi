FROM mysql

ENV MYSQL_DATABASE=bank_db \
    MYSQL_ROOT_PASSWORD=rootadmin \
    MYSQL_PASSWORD=bankpwd \
    MYSQL_USER=bank_user

COPY ddl.sql /docker-entrypoint-initdb.d/ddl.sql