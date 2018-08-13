# chrisarroyoResumeSiteTests

Download latest ChromeDriver: (windows)

Download the latest release from here: http://chromedriver.chromium.org/

Add the chromedriver to your system path

Install Maven: (windows)

To install Maven on windows, head over to Apache Maven site (http://maven.apache.org/) to download the latest version, select the Maven zip file, for example apache-maven-3.3.9-bin.zip. (make sure to choose the binary one)

Unzip it to the folder you want Maven to live.

Add both M2_HOME and MAVEN_HOME variables to the Windows environment using system properties, and point it to your Maven folder.

Update the PATH variable by appending the Maven bin folder – %M2_HOME%\bin, so that you can run the Maven’s command everywhere.

To verify it run:
mvn -version

in the command prompt. It should display the Maven version, the java version, and the operating system information. That’s it, you have set up Maven on your Windows system.

Running the tests:

mvn test -Dtest=FullRegressionTestRun