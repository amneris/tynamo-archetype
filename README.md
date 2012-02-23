Tynamo archetype
==================

-> WORK IN PROGRESS <-

The tynamo archetype
--------------------------------

First read:

* http://tynamo.org/Overview
* http://tynamo.org/Quick+start

Then run:

	mvn archetype:generate \
		-DarchetypeArtifactId=tynamo-archetype \
		-DarchetypeGroupId=org.amneris \
		-DarchetypeVersion=3.0.0-SNAPSHOT \
		-DgroupId=com.yourcompany \
		-DartifactId=projectname \
		-Dpackage=com.yourcompany.projectname \
		-Dversion=0.1.0-SNAPSHOT

And after that:

	mvn clean jetty:run -P commons,dev.local
