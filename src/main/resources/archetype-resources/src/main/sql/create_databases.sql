/* USAGE: mysql -u root -p < create_databases.sql */

DROP DATABASE IF EXISTS ${artifactId};
DROP DATABASE IF EXISTS ${artifactId}_dev;
DROP DATABASE IF EXISTS ${artifactId}_tests;

CREATE DATABASE ${artifactId} CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE ${artifactId}_dev CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE ${artifactId}_tests CHARACTER SET utf8 COLLATE utf8_general_ci;

GRANT ALL ON ${artifactId}.* TO ${artifactId}_admin@localhost IDENTIFIED BY "${artifactId}_4dm1n";
GRANT ALL ON ${artifactId}_dev.* TO ${artifactId}_admin@localhost IDENTIFIED BY "${artifactId}_4dm1n";
GRANT ALL ON ${artifactId}_tests.* TO ${artifactId}_admin@localhost IDENTIFIED BY "${artifactId}_4dm1n";

FLUSH PRIVILEGES;
exit