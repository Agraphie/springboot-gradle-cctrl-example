#Building a Webapp with Spring Boot, MongoDB and Gradle

This project is a simple example project about how to create a webapp with Spring Boot, MongoDB and Gradle and then push it to a cloud service like CloudControl.
With some simple tweeking you should be able to run this app on any cloud hoster.

###What this app is able to do
- Say hello
- create a person with first name and last name
- find a person by its last name and display his full name

###Things you'll need for running this app locally
- a running MongoDB instance

###Things you'll need for running this app on CloudControl
- The cctrlapp installed
- a CloudControl account
- a CloudControl billing account in order to be able to add AddOns

###Run this app locally
To run this app simply type "./gradlew bootRun" or "gradlew.bat bootRun" in a shell or command line.

###Run this app on CloudControl
First, create a repository.
```
cctrlapp APP_NAME create custom --buildpack https://github.com/Agraphie/buildpack-gradle.git
```

Now add the MongoSoup addon to your repository (when in doubt about DEP_NAME, use "default").
```
cctrlapp APP_NAME/DEP_NAME addon.add mongosoup.sandbox
```

Third push your app to cloudControl (when in doubt about DEP_NAME, use "default").
```
cctrlapp APP_NAME/DEP_NAME push
```

Lastly deploy your app (when in doubt about DEP_NAME, use "default").
```
cctrlapp APP_NAME/DEP_NAME deploy
```


###Say hello
Type in a browser window (if running on cloudControl, use your app's deployment URL)
```
http://localhost:8080/hello
```

###Create a person
Type in a browser window (if running on cloudControl, use your app's deployment URL)
```
http://localhost:8080/newperson?lastName=alastname&firstName=afirstname
```

###Display/find a person
```
http://localhost:8080/showperson/alastname
```

###Credits
- [cloudControl](https://www.cloudcontrol.com/dev-center/Quickstart)
- [Spring Boot](http://projects.spring.io/spring-boot/)