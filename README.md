Tynamo archetype
==================

-> WORK IN PROGRESS <-

The tynamo archetype
--------------------------------

First read:

* http://tynamo.org/Overview
* http://tynamo.org/Quick+start

.

Then run:

	mvn archetype:generate \
		-DarchetypeArtifactId=tynamo-archetype \
		-DarchetypeGroupId=org.amneris \
		-DarchetypeVersion=0.0.1 \
		-DgroupId=com.yourcompany \
		-DartifactId=projectname

.

And after that:

	mvn clean jetty:run -P commons,dev.local
