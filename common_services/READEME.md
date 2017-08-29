
```
java -jar ServiceCenter.jar --spring.profiles.active=dev
java -jar sxun-gateway-1.0.jar --spring.profiles.active=dev --eureka.client.service-url.defaultZone=http://localhost:8201/eureka/  --spring.datasource.url=jdbc:mysql://localhost:3306/sxun-auth --spring.datasource.username=root --spring.datasource.password=asdf123!
```