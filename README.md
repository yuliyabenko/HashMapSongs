# HashMapSongs
My own realization of HashMap

In my demo-app I created MyHashMap which stores the catalog of songs. Name of song it is a key, singer - value. To test the program, use the following functions:


Build

$ ./mvnw clean package


Usages:


SIZE

$ java -jar target/app.jar SIZE


PUT

$ java -jar target/app.jar PUT -k Strangers_in_the_night -v Frank_Sinatra


GET

$ java -jar target/app.jar GET -k Strangers_in_the_night
