# GraalVM Example: JavaScript, Java, and JMX

This repository contains the code for a demo application for demonstrating reporting metrics to JMX from JavaScript's NodeJS.

## Prerequisite Installations
* [asdf](https://github.com/asdf-vm)
* GraalVM plugin for `asdf` (`asdf plugin add graalvm`)

## Preparation

Download or clone this repository:
```
git clone git@github.com:potatopankakes/graalvm-javascript-jmx-example.git
cd graalvm-javascript-jmx-example
asdf install
```

Install the npm packages for nodejs:
```
npm install
```

Build the java class files (could do w/maven... but demonstrate it w/npm as the orchestrator):
```
npm run build
```

Now you're all set to run or debug the example.

## Running the application

```
npm run startWithJmx
```

## Viewing JMX metrics

To experiment with the application and view JMX records:

- Launch `jconsole` and start a remote JMX session to `127.0.0.1:9999`
- Within `jconsole`, navigate to the MBeans panel, and find `net.klymur.examples.nodejs.jmx`.
- Within `net.klymur.examples.nodejs.jmx`, open `ServerStatus` and click on `Attributes`.  You should see request counts set to 0.
- If you click `Refresh` on this view while browsing repeatedly to http://127.0.0.1:3000/, you will see the Success and Failure counts increasing.

## Debugging the application

```
npm run debugWithJmx
```

## Running or Debugging the application with VSCode

One should be able to use VSCode to run or debug the application.  The "Launch Program" configuration option will handle either of these scenarios.

One can set breakpoints in the  JavaScript.  I am unsure if there is a way to get breakpoints in the Java working.
