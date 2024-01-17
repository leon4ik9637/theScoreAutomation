Hello all!

I love sports, and this would be great opportunity to grow in such environment, and I would like to thank you 
for having such an amazing opportunity to collaborate and introduce my skills to you.

First thing is first, I could not use Appium Inspector and Android Studio, I believe my local does not
have enough memory to launch emulator after all updates. I also tried online appium inspector and many other 
ways to make it work, but I had only 1 week to complete this assignment, so I decided to create a framework
in which there are no locators (I often practice such thing before new update is about to be released),
but hopefully you will check my approach to automate mobile application. If I could test it on my end,
I would at least know what is going on and if it is working, so I can only predict.

Everything is under src/test.

I used Maven to store all my dependencies, Appium 2 and Java 11.

In this project, there are pages package, I created classes for every Page and stored the corresponding 
WebElements, Lists and methods, there is runner which has MobileRunner class which is configured to run the feature 
file. It can run different tests depending on its settings. 

Under resources/mobile there is feature file in which there is scenario to this automation task. 

Every scenario has its step and corresponding script which are located in the "TheScoreLeaguesStepDefs" and 
which also use elements from corresponding pages Classes

In the utils folder we have ConfigReader which reads properties from configuration.properties file and 
helps us switch between different properties faster and easier (e.g. we can switch between browser testing and 
app testing) 

In src/test/java/mobile/apps I store the apk file for theScore application which I downloaded from
"apkmirror.com" and the version is "theScore: Sports News & Scores 24.1.0"

Lastly, the task specifies bonus points for using data-driven approach. I used BDD approach since I am 
more comfortable with it. I could have practiced and become comfortable with data-driven, but it would 
have taken time, and I did not want to miss the deadline. 

Thank you, hope to hear from you soon. 
