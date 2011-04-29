mysql -u root -proot < create_databases.sql
mysql ${artifactId} -u root -proot < create_changelog_table.sql
mysql ${artifactId}_dev -u root -proot < create_changelog_table.sql
mysql ${artifactId}_tests -u root -proot < create_changelog_table.sql

