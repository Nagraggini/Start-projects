# Mockito és Mockkolás

[https://mvnrepository.com/](https://mvnrepository.com/)-n minden függőség megtalálható. -> mockito core -> JUnit Jupiter (Aggregator)

pom.xml-be a dependencies részre ezt másold be:		
		
```xml
        <!-- Mockito Core -->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>    
```

Eclipse használata esetén:
Projekten jobb egér -> Run As -> Run Conf -> Arguments lapfül -> VM Arguments-ben -javaagent:'/eclipse/mockito/byte-buddy-agent-1.14.11.jar' -ea -> Run -> Apply Ha másutt van a fájl, akkor azt írd be!