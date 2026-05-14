# Folyamat diagramm a programhoz

[![](https://mermaid.ink/img/pako:eNqlVUtv20YQ_iuDDYI4AEXwITEyURvVI0bSOAgQpzm06mEpLskVl7vCcmVbMnzoD8iP8NGHHopceyP6vzp8SJacxJcuAUrz-vabmZ3lDZmrmJGQJEJdzTOqDZx_nEkoV1Gq6TKDN9QYpssNl7_PCMzIH2jEFXPN5oYr2bp3a4w-b9-pkmpBo5h-ZEtVcqP0Gi6pUDGvFXACkl3BGV2I73kercylklS83G1VrxECj6L5Q8A5T-kZEzSmRuWgyo2p7sT6IGbydMxSK8yw6Oj82PHogfohpynidyA2lzE3tDw69JAuurg2nFf3RrNMbTarHCjkSuYaVVCwFMGrr2X1F9IvDRzRgkNS3S1EVH0VoMQlLV_aP0X69HWWsQ3kTAhg6XqXsAV1BC-WghVM1qoFBboBLrFpSXWPbvYhJe_nG8AkmQixmZ4NL8aMywXLm9hV_gL5fUOroVwavcqxQ9jynGlWE_hHIDjc7qH7mLBvw2uBBcHoRZNvVyS1o8Jk3MaM4OTkFMatMG6ESStMGmG6tfTs3imWc2trRa8Vp53oz2TnjimWGV2yEOpD2vGbfFfb1ONbdft-_hwuPlVfzn-9-PAOfhl9rr58qv68GLXGuaBlOWVJnd6clSUkXIjwmecPAz-wsFoqZ-GzJEm6_70rHpssdJfX1lwJpVtboqTplXzDQjdYXj9CNkqJDtZNgoRF_wt2l9NbU7dUVPdyzdIQPnNR3aV4-KMIsurOmOpeW5CwDH8hYubfvy2QNF0rtBeoY-YRTakM62j2-_0dx6FTP0_RfMR0gMZWNGvBQhwowef73JsdYWxNtjXfV0-bcu1rpGtJz5J-Q3Afp8HHw9dyHo0c5-zsB9UbbjldMZ5mJoyUiPdBHq7HDs1xnCcr4B1UgFgk1TwmIQ4Xs0jBdEFrkdzUm8yIyXCuZ6Se1ZjqfEZm8hZjllT-plSxDdNqlWYkTKgoUVot8d5iU07rodu54MwxPVEraUh47DQQJLwh1yTsYdPsQeC6Tr9_PPT7gTewyJqErufax87wOBgE_aE3fBUMbi2yabb1bMcdeq8cb9B3_YHrexZhcX19v28_Js035fY_KUAfGg?type=png)](https://mermaid.live/edit#pako:eNqlVUtv20YQ_iuDDYI4AEXwITEyURvVI0bSOAgQpzm06mEpLskVl7vCcmVbMnzoD8iP8NGHHopceyP6vzp8SJacxJcuAUrz-vabmZ3lDZmrmJGQJEJdzTOqDZx_nEkoV1Gq6TKDN9QYpssNl7_PCMzIH2jEFXPN5oYr2bp3a4w-b9-pkmpBo5h-ZEtVcqP0Gi6pUDGvFXACkl3BGV2I73kercylklS83G1VrxECj6L5Q8A5T-kZEzSmRuWgyo2p7sT6IGbydMxSK8yw6Oj82PHogfohpynidyA2lzE3tDw69JAuurg2nFf3RrNMbTarHCjkSuYaVVCwFMGrr2X1F9IvDRzRgkNS3S1EVH0VoMQlLV_aP0X69HWWsQ3kTAhg6XqXsAV1BC-WghVM1qoFBboBLrFpSXWPbvYhJe_nG8AkmQixmZ4NL8aMywXLm9hV_gL5fUOroVwavcqxQ9jynGlWE_hHIDjc7qH7mLBvw2uBBcHoRZNvVyS1o8Jk3MaM4OTkFMatMG6ESStMGmG6tfTs3imWc2trRa8Vp53oz2TnjimWGV2yEOpD2vGbfFfb1ONbdft-_hwuPlVfzn-9-PAOfhl9rr58qv68GLXGuaBlOWVJnd6clSUkXIjwmecPAz-wsFoqZ-GzJEm6_70rHpssdJfX1lwJpVtboqTplXzDQjdYXj9CNkqJDtZNgoRF_wt2l9NbU7dUVPdyzdIQPnNR3aV4-KMIsurOmOpeW5CwDH8hYubfvy2QNF0rtBeoY-YRTakM62j2-_0dx6FTP0_RfMR0gMZWNGvBQhwowef73JsdYWxNtjXfV0-bcu1rpGtJz5J-Q3Afp8HHw9dyHo0c5-zsB9UbbjldMZ5mJoyUiPdBHq7HDs1xnCcr4B1UgFgk1TwmIQ4Xs0jBdEFrkdzUm8yIyXCuZ6Se1ZjqfEZm8hZjllT-plSxDdNqlWYkTKgoUVot8d5iU07rodu54MwxPVEraUh47DQQJLwh1yTsYdPsQeC6Tr9_PPT7gTewyJqErufax87wOBgE_aE3fBUMbi2yabb1bMcdeq8cb9B3_YHrexZhcX19v28_Js035fY_KUAfGg)

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