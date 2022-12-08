# country-info-app
This app allows you to get information about 5-20 random locations around the world.

Instructions:

■ How to pull the code / clone or fork your project repository

On **github.com/jeleniasty/country-info-app** navigate to green Code button and expand it.

![image](https://user-images.githubusercontent.com/107942648/206553796-2ca27b36-1526-485e-937e-f899ef60c149.png)

There are few options to clone this repo. Two easiest ways are:
1. Download ZIP file with project documentation and then unzip it and run it on your local machine using IDE (preferably IntelliJ IDEA).
2. Clone repository using HTTPS URL. Just copy URL, open Git Bash, type git clone and then paste the URL you copied earlier.

■ How to compile / assemble the code
Open CLI and navigate to project directory then run "mvn clean install".

■ How to run/deploy the solution
Open CLI and navigate to project directory then run "mvn org.springframework.boot:spring-boot-maven-plugin:3.0.0:run".

■ How to use it (if any user input required)
After running application use browser, Postman or any similar tool to send a request using e.g. http://localhost:8080/countries?number=20.
Last two digits are input and signify the number of countries to be displayed.
