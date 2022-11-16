# devops-pipeline-qa-serenity-front

[![gradle](https://img.shields.io/badge/gradle-v6.0.1-green.svg)](https://gradle.org/install/)
[![maven](https://img.shields.io/badge/maven-v4.0-red.svg)](https://maven.apache.org/)


>A simple Gradle & Maven project to test ADL DevOps Java Serenity &&  Cucumbert  Pipelines. `:wq`
>
>Developed with all :heart: in the world by ADL DevOps team

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org)
* [Maven](https://maven.apache.org/)
* [Java](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)


## Installation

We use [Gradle](http://www.gradle.org), a cross-platform build automation tool that help with our full development flow. 
If you prefer [install Gradle](http://www.gradle.org/installation) or use a [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) inside this project.

* Configurar token personal acorde al siguiente link: [Personal Token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
* Debe abrir una terminal ![Mac](https://img.shields.io/badge/Mac-BigSur-white.svg) o consola ![Windows](https://img.shields.io/badge/Windows-version10-green.svg)
* Ejecute el comando git clone git@github.com:avaldigitallabs/bpop-hipotecario-qa-e2e.git
* Cargue el proyecto en el IDE de preferencia o ejecute el comando: gradle clean build

##  Executing the tests

En la seccion de configuracion del proyecto configure **-Denvironment** con alguno de los siguiente valores: 

   * dev
   - stg
   + pro
   
By default, the tests will run using Chrome.

```bash
./gradlew clean test aggregate -Denvironment=pro
```
Or 
```bash
 mvn clean verify -Denvironment=stg 
```

with other webdriver

```bash
 mvn clean verify -Denvironment=stg  -Dwebdriver.driver=firefox
```
The test results will be recorded in the `target/site/serenity` directory.

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _stg_ and _pro_, with different starting URLs for each:
```configure
environments {
  default {
  webdriver.base.url = "https://hipotecario-stg-popular.avaldigitallabs.com/"
}
dev {
  webdriver.base.url = "https://hipotecario-dev-popular.avaldigitallabs.com/"
}
stg {
  webdriver.base.url = "https://hipotecario-stg-popular.avaldigitallabs.com/"
  bstack_build=serenity-browserstack
  bstack_debug=true
  bstack_browserstack.console=verbose
  bstack_browserstack.local=true
  bstack_browserstack.autoWait=120
  single{
  name=single_test
  browser=edge
  browser_version=latest
  os=Windows
  os_version=10
}
}
pro {
webdriver.base.url = "https://hipotecario-pro-popular.avaldigitallabs.com/"
}
}
```
  
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```bash
$ mvn clean verify -Denvironment=stg
```

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main                                  | Source main
    + java
      + co.bpop.hipotecario.qa.ui
                + logs                     | Package class log
                + screenplay               | Package class screenplay
                + utilities                | Package class utilities and varios
  + test                                  |
    + java                                | Test runners and supporting code
      + co.bpop.hipotecario.qa.ui           | Package base
        + runners
          + {runner_name}.java              | Main class
        + steps
          + {step_name}.class
    + resources                           |
      + features                          | Feature files
         + {feature_name}.feature         | Feature file  specific
      + serenity.conf                     | Config file for Serenity
build.gradle                              | Config file Gradle
serenity.properties                       | General properties Serenity
Jenkinsfile.yml                           | Config file Jenkins
README.md                                 | readme file
```


## Intall webdriver local

```bash
brew tap homebrew/cask && brew cask install chromedriver

```

## Want to learn more?
For more information about Serenity BDD, you can read the [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD
* [**The Serenity BDD Dojo**](https://serenitydojo.teachable.com) - Online training on Serenity BDD and on test automation and BDD in general. 
