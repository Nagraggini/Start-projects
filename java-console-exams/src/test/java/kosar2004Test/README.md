# Folyamat diagramm a programhoz

[![](https://mermaid.ink/img/pako:eNqdVMtS2zAU_ZU76gKYSTx-QAiawjQPmHbKimXrLpRYjhUrkkeSgSTDx7Bk0RXb7vJjvX4QGl6L2hufq3OPztW91ppMdcIJJd1uN1ZTrVIxo7ECkGypS0chFbc8qQIu4wtOIWEmj1XNTqW-mWbMOLi8QoYtJzPDigy-Mue4sSuhfsYEYvKrSgdIhOFTJ7Rq6O0zRM6379oyI9kkYVe80FY4bZZwzaRORBWAU1D8Bi7YXL7F3C_dtVZMHmy3qp4BCg8m0-eESzFjF1yyhDmdg7Yrt7mXy52c0cc5hdFY4aK18z5x_9n6rqcx6rcinlCJcMzu7zJUgJTAg8vNgzM806tVmQODXKvcYAgWfIbim0e7-Y32rYN9thCQbu7ncrJ5lKDlNbMH3ueJOTvPMr6CnEsJfLbcFtyBKkMsCon9VFVozoCtQChsWrp5QJq3ayn8ssZxmHBJsZmhB3tDLtSc53Vume-hv1e2asvWmTLHDmHLc254ZeCPRHG4-0c9woIjD84lHghmz-t620PSWytcJU3OAE5Pz2DYgGENRg0Y1WD8tNL1umd4nE9rDQwbOG5hFKuWjiXajBU44NWQtv5Gb0br83gdhiGlFH1PubVtZPQqMsaI01q2UAWIlXb8CYcvcLSDp5JZO-YptKL4c0pJP4VRvxf1OnjaOuf0U5qm7Xf3RiQuo0Fx25lqqU299kKqctPqBGkv5ZP_1KlctjpRFG1F-n71vqvTLqdaua4VK06DsLhtlK1bSo7tbjQHA9-_uHi1fUN6vnBatu_7HzoIdyohHTIzIiEUx5V3yIKbBasgWVebxKS--WJSTX99-5FY3WFOwdQPrRdPaUaXs4zQlEmLqCzwJuBjwaox3kYNjjE3I10qR2gY1BqErsktouO-54dB0D_xe1HUCw8PO2RJaHTsBf3jQyzhMOydHAXhXYes6l19r398dPcXrzXjpg?type=png)](https://mermaid.live/edit#pako:eNqdVMtS2zAU_ZU76gKYSTx-QAiawjQPmHbKimXrLpRYjhUrkkeSgSTDx7Bk0RXb7vJjvX4QGl6L2hufq3OPztW91ppMdcIJJd1uN1ZTrVIxo7ECkGypS0chFbc8qQIu4wtOIWEmj1XNTqW-mWbMOLi8QoYtJzPDigy-Mue4sSuhfsYEYvKrSgdIhOFTJ7Rq6O0zRM6379oyI9kkYVe80FY4bZZwzaRORBWAU1D8Bi7YXL7F3C_dtVZMHmy3qp4BCg8m0-eESzFjF1yyhDmdg7Yrt7mXy52c0cc5hdFY4aK18z5x_9n6rqcx6rcinlCJcMzu7zJUgJTAg8vNgzM806tVmQODXKvcYAgWfIbim0e7-Y32rYN9thCQbu7ncrJ5lKDlNbMH3ueJOTvPMr6CnEsJfLbcFtyBKkMsCon9VFVozoCtQChsWrp5QJq3ayn8ssZxmHBJsZmhB3tDLtSc53Vume-hv1e2asvWmTLHDmHLc254ZeCPRHG4-0c9woIjD84lHghmz-t620PSWytcJU3OAE5Pz2DYgGENRg0Y1WD8tNL1umd4nE9rDQwbOG5hFKuWjiXajBU44NWQtv5Gb0br83gdhiGlFH1PubVtZPQqMsaI01q2UAWIlXb8CYcvcLSDp5JZO-YptKL4c0pJP4VRvxf1OnjaOuf0U5qm7Xf3RiQuo0Fx25lqqU299kKqctPqBGkv5ZP_1KlctjpRFG1F-n71vqvTLqdaua4VK06DsLhtlK1bSo7tbjQHA9-_uHi1fUN6vnBatu_7HzoIdyohHTIzIiEUx5V3yIKbBasgWVebxKS--WJSTX99-5FY3WFOwdQPrRdPaUaXs4zQlEmLqCzwJuBjwaox3kYNjjE3I10qR2gY1BqErsktouO-54dB0D_xe1HUCw8PO2RJaHTsBf3jQyzhMOydHAXhXYes6l19r398dPcXrzXjpg)

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