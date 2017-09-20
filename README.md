<h4> Prerequisites </h4>

* Java SDK 9 Early Access (or later)
* IntelliJ IDEA 2017.1 (or later with support for Java 9 modules)
* Maven 3 (maven-compiler-plugin v3.6.2 support for compiling java 9 modules)

<h4> Technologies used </h4>

* JavaFX with Java 9
* [Puddle](https://github.com/jbilander/Puddle) A thread-safe lightweight standalone Java JDBC connection pool manager that I wrote.
* SQLite-native (as backend db, native x86_64 binary libs included in below driver)
* [Forked Xerial SQLite JDBC Driver (v3.20.0)](https://github.com/jbilander/sqlite-jdbc) with support for encryption (SQLCipher) 

<h4> About </h4>

This demo application is built to show you how you can structure your desktop JavaFX app similar to the [Robotlegs](http://www.robotlegs.org/) approach.
The structure in this app is highly inspired by Yennick Trevels [blog post](http://yennicktrevels.com/blog/2013/10/15/javafx-structuring-your-application-overview/) 
with using direct calls with interfaces over events because that makes it easier to follow the flow of your application. However this example does
not use any dependency injection framework such as guice since I wanted to keep it as pure Java 9 as possible for instructional purposes.
This app is also built with the new module approach in Java 9. The UI is built with pure Java code instead of using fxml since I prefer
it that way giving me more control over my code. Also the UI is built to be resizable meaning the UI-components adapt their size when 
the main application windows is being resized.

<h4> Backend </h4>

SQLite with [Forked Xerial SQLite JDBC Driver (v3.20.0)](https://github.com/jbilander/sqlite-jdbc) with support for encryption (SQLCipher) is used as a backend with pure JDBC-calls for instructional purpose.
The driver has native binary libs (dll, jnilib, so) included for 64-bit Windows x86_64, MacOSX x86_64 and Linux x86_64 platforms.

<h4> Output </h4>

The application creates and populates an encrypted JavaFx-structure-demo.db file under the user home directory, System.getProperty("user.home").

* MacOS
>/Users/username/JavaFx-structure-demo.db

* Windows
>C:\Users\username\JavaFx-structure-demo.db

* Linux
>/home/username/JavaFx-structure-demo.db

<h4> Screenshot of application </h4>

MacOS<br />
<img src="https://github.com/jbilander/JavaFx-structure-demo/blob/master/app_screenshot_macos.png">
<br />Windows<br />
<img src="https://github.com/jbilander/JavaFx-structure-demo/blob/master/app_screenshot_windows.png">
<br />Linux Mint<br />
<img src="https://github.com/jbilander/JavaFx-structure-demo/blob/master/app_screenshot_linux.png">

<h4> Usage </h4>

compile and package with Maven/Java 9 SDK
* mvn package

<br />
<h4> Create a reduced native runtime image with jlink </h4>

Build artifacts (jars) from the modules. From within Intellij choose Build->Build Artifacts...

Now the following two jars should have been created under the target folder:

* JavaFx-strucure-demo.jar (including a MANIFEST.MF-file containing "Main-Class: com.example.Main")

Please not that you have to do `mvn install` first on `Puddle` and `sqlite-jdbc-sqlcipher` projects so that the jars is installed in your .m2 maven repo.

Run the following jlink command from the target catalog

* MacOS (61 MB)

>jlink --output release/JavaFx-structure-demo --compress=2 --module-path="JavaFx-structure-demo.jar:sqlite-jdbc.jar:/Library/Java/JavaVirtualMachines/jdk-9.jdk/Contents/Home/jmods" --add-modules com.example,sqlite.jdbc

* Windows (51,4 MB) Obviously this can be stripped down further removing the binaries not used for Windows in `sqlite-jdbc-sqlcipher` project.

>jlink --output release/JavaFx-structure-demo --compress=2 --strip-debug --module-path="JavaFx-structure-demo-1.0.jar;%homepath%\.m2\repository\com\creang\Puddle\1.0\Puddle-1.0.jar;%homepath%\.m2\repository\org\xerial\sqlite-jdbc-sqlcipher\3.20.0\sqlite-jdbc-sqlcipher-3.20.0.jar;C:\Program Files\Java\jdk-9\jmods" --add-modules com.example,puddle,sqlite.jdbc

copy the libeay32.dll (shell\Windows\x86_64\libeay32.dll) from the `sqlite-jdbc-sqlcipher` project into your release\JavaFx-structure-demo\bin folder.

* Linux (72 MB)

>jlink --output release/JavaFx-structure-demo --compress=2 --module-path="JavaFx-structure-demo.jar:sqlite-jdbc.jar:/opt/jdk-9/jmods" --add-modules com.example,sqlite.jdbc

Usage:

From the release/JavaFx-structure-demo/bin folder run:

* MacOS/Linux

>./java -m com.example/com.example.Main

* Windows

>.\javaw -m com.example/com.example.Main

Use the `javapackager` if you want to make a native package for distribution, more about that [here](https://stackoverflow.com/questions/45446827/error-when-trying-to-package-native-image-with-javapackager-in-java-9-ea)