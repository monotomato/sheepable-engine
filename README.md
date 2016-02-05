# Sheepable Engine #
> ECS game engine developed with scala.js

>TODO: Rename this project. Or not.

## Development ##

### Enviroment setup ###
Compile and run server for development.
``` Bash
$ sbt ~fastOptJS
```
Test site is now live and can be found at
```
http://localhost:12345/target/scala-2.11/classes/index-dev.html
```
Sbt will compile code and update your browser tab automatically.
### Notes ###
This project uses [workbench](https://github.com/lihaoyi/workbench) tool by lihaoyi.

### Linter-scalac and classpath ###
[linter-scalac](https://atom.io/packages/linter-scalac)  might freak out if `.classpath` is not defined.
Run `sbt 'export fullClasspath'` and copy classpath to `.classpath`.

## Technologies ##
* [Scala.js](http://www.scala-js.org/)
