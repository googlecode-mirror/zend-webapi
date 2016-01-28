# Introduction #

This document describes how to build webapi project using its sources.


# Details #

Before webapi can be build following requirements must be satisfied:
  * Gradle is available. If you do not have it installed yet go to http://www.gradle.org/downloads and download the newest version. Then follow installation steps from http://www.gradle.org/installation.
  * Eclipse IDE for Java Developers or any other Eclipse with JDT installed.
  * SVN client.

Here are steps to build webapi:
  1. Run Eclipse.
  1. Checkout webapi code from repository (details at http://code.google.com/p/zend-webapi/source/checkout) to your workspace.
  1. One of the following variables must be set before build is performed:
    * system environment GRADLE\_HOME,
    * ant variable gradle.home (you can add it on Properties tab in Preferences->Ant->Runtime).
  1. Build project in Eclipse.

After those steps project is ready for development. The main script for building webapi is build.gradle.

Here is a list of task which are available for this project:

**Build tasks**
  * assemble - Assembles jar archive (available in {project\_root}/build/libs).
  * build - Assembles and tests this project.
  * buildDependents - Assembles and tests this project and all projects that depend on it.
  * buildNeeded - Assembles and tests this project and all projects it depends on.
  * classes - Assembles the main classes (available in {project\_root}/build/classes).
  * clean - Deletes the build directory.
  * jar - Assembles a jar archive containing the main classes (available in {project\_root}/build/libs).
  * testClasses - Assembles the test classes (available in {project\_root}/build/classes).

**Documentation tasks**
  * javadoc - Generates Javadoc API documentation for the main source code (available in {project\_root}/build/docs/javadoc)

**Verification tasks**
  * check - Runs all checks.
  * test - Runs the unit tests with Emma code coverage (results available in {project\_root}/build/reports).


**Other tasks**
  * createBinPackage - create binary package (available in {project\_root}/build/distributions/).
  * createJavadocJar - Assembles jar with javadoc (available in {project\_root}/build/libs/).
  * createSourceJar - Assembles jar with sources (available in {project\_root}/build/libs/).
  * createSrcPackage - create source package (available in {project\_root}/build/distributions/).
  * createTestJar - Assembles jar with tests (available in {project\_root}/build/libs/).