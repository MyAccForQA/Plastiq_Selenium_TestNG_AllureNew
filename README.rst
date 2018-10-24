########################################
Plastiq [Selenium Tests]
########################################

This repository contains `Selenium <http://seleniumhq.org/>`_ tests for the `Plastiq <https://www.plastiq.com/>`_, `GitHub Account <https://github.com/MyAccForQA/Plastiq_Selenium_TestNG_AllureNew>`_.


    .. image:: https://github.com/MyAccForQA/Plastiq_Selenium_TestNG_AllureNew/blob/master/screenshot/README/homepage.png
        :alt: Plastiq
        :width: 30%
        :align: center


.. contents::

.. section-numbering::

.. raw:: pdf

   PageBreak oneColumn


=============
Dependencies
=============
----------------
Git
----------------
Make sure you have `Git <https://git-scm.com/>`_ installed on your system. For check use the commands below:

``git -v``

----------------
GitHub
----------------
Make sure you have access `GitHub Account <https://github.com/MyAccForQA/Plastiq_Selenium_TestNG_AllureNew>`_:

``git clone https://github.com/MyAccForQA/Plastiq_Selenium_TestNG_AllureNew``

----------------
Maven
----------------
Make sure you have `Maven <https://maven.apache.org/download.cgi>`_ installed on your system. For check use the commands below:

``mvn -v/--version``

----------------
Java
----------------
Make sure you have `Java <http://www.java.com/>`_ installed on your system, if not follow the vendor instructions for installing them on your operating system.

``java -version``

----------------
GeckoDriver
----------------
~~~~~~~~~~~~
FireFox - WebDriver for FireFox
~~~~~~~~~~~~
Need download driver from `GeckoDriver <https://github.com/mozilla/geckodriver/releases>`_ and drop in folder:
For Mac - ./src/test/resources/geckodriver/ios/ff/geckodriver
For Win - ./src/test/resources/geckodriver/win/ff/geckodriver.exe

Instruction - https://github.com/SeleniumHQ/selenium/issues/2990

~~~~~~~~~~~~
ChromeDriver - WebDriver for Chrome
~~~~~~~~~~~~
Need download chromedriver from `GeckoDriver <https://sites.google.com/a/chromium.org/chromedriver/downloads>`_ and drop in folder:
For Mac - ./src/test/resources/geckodriver/ios/ch/chromedriver
For Win - ./src/test/resources/geckodriver/win/ch/chromedriver.exe


=============
Run
=============
To run the framework using basic options and their syntax:

``./mvnw [clean] [test] [site] [-DdriverType=ch] [-Ptest1/-Ptest2/-Ptest3] [-Dtestngfile=testng_xml_file]``

----------------
Clean
----------------
To clean the folders from test data from the previous run use the command [clean]

``./mvnw clean``

----------------
Run test without/with report
----------------
To run the framework for execution you need to choose the desired option [test/site]

~~~~~~~~~~~~
Run test without report
~~~~~~~~~~~~
To run tests without getting a report use option test

``./mvnw clean test``

~~~~~~~~~~~~
Run test with report
~~~~~~~~~~~~
To run tests with getting a report use option site

``./mvnw clean test site``

----------------
Browser
----------------
To run the framework in a particular browser, to need to specify the name of the browser as a parameter of the option of [-DdriverType]

~~~~~~~~~~~~
Firefox
~~~~~~~~~~~~
To run in Firefox use -DdriverType=ff, below:

``./mvnw clean test site -DdriverType=[FF/ff/FIREFOX/FireFox/firefox/FOX/Fox/fox]``

~~~~~~~~~~~~
Chrome
~~~~~~~~~~~~
To run in Chrome use -DdriverType=ch, below:

``./mvnw clean test site -DdriverType=[CH/ch/CHROME/chrome]``

~~~~~~~~~~~~
Internet Explorer - [Not Implement yet]
~~~~~~~~~~~~
To run in Internet Explorer use -DdriverType=ie, below:

``./mvnw clean test site -DdriverType=[IE/ie]``

~~~~~~~~~~~~
Default
~~~~~~~~~~~~
If you don't specify this parameter, default option -DdriverType = ch

``./mvnw clean test site -DdriverType=ch``

----------------
Profile
----------------
In order to use a profile to run tests specify the desired option [-Ptest1/-Ptest2/-Ptest3]

~~~~~~~~~~~~
Profile #1
~~~~~~~~~~~~
Use option -Ptest1 to run the default profile

* if you specify a profile -Ptest1, then the following option [-Dtestngfile=testng_Tests_All.xml] should not be specified.

~~~~~~~~~~~~
Profile #2
~~~~~~~~~~~~
Use option -Ptest2 to run the profile where to need specify just testng_xml_file use option [-Dtestngfile=testng_Tests_All.xml]

~~~~~~~~~~~~
Profile #3
~~~~~~~~~~~~
Use option -Ptest3 to run the profile where to need specify full path and testng_xml_file use option [-Dtestngfile=!testngxml!/testng_Tests_All.xml]

~~~~~~~~~~~~
Default
~~~~~~~~~~~~
If you don't specify this parameter default option profile = -Ptest1

* if you specify a profile -Ptest1, then the following option [-Dtestngfile=testng_Tests_All.xml] should not be specified.

----------------
TestNG files
----------------
If specified the previous option, it is necessary to specify what of file need to run test, specify the option [-Dtestngfile=testng_xml_file]

testng_All_Test.xml 				- run all tests

testng_Google_Test.xml 				- run test of Google only


=============
OPEN REPORT
=============

In project exist 3 kind of reports:

----------------
Allure report
----------------
`Allure <http://allure.qatools.ru/>`_ is open-source framework designed to create test execution reports clear to everyone in the team.

~~~~~~~~~~~~
Open report
~~~~~~~~~~~~
To open the browser and in the address bar enter the path:

``./target/site/allure-maven-plugin/index.html``

----------------
Java Code Coverage report - [Not Implement yet]
----------------
`JaCoCo <http://www.eclemma.org/jacoco/index.html>`_ is a free code coverage library for Java, which has been created by the EclEmma team based on the lessons learned from using and integration existing libraries for many years. 

~~~~~~~~~~~~
Open report
~~~~~~~~~~~~
[Not Implement yet]


=============
Example
=============
----------------
1 - Default testng-file
----------------
./mvnw clean test site -DdriverType=ch -Ptest1														->	full path = '!testngxml!/testng_All_Test.xml'

----------------
2 - Only testng-file file
----------------
./mvnw clean test site -DdriverType=ch -Ptest2 -Dtestngfile=testng_All_Test.xml					->	full path = '!testngxml!/testng_All_Test.xml'

----------------
3 - Full path of testng-file file
----------------
./mvnw clean test site -DdriverType=ch -Ptest3 -Dtestngfile=!testngxml!/testng_All_Test.xml		->	full path = '!testngxml!/testng_All_Test.xml'
