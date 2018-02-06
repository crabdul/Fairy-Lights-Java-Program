# Fairy Lights Java Program

 Java program to turn on/off a set of coloured lights in sequence. 
 The number of lights are configurable on the command line. 
 The default colour sequence is "red, green, white".
 Each light should remain on for 1 second and then turn off.
 Colours and sequence can be specified in the command line:

## Getting Started

### Prerequisites

**[Java](https://java.com/en/download/)** 

**Maven** - Download from [here](https://maven.apache.org/install.html) and follow the [installation guide](https://maven.apache.org/install.html) to install it on your system.
Alternatively, if you use homebrew, simply install using the following command

```
brew install maven
```

### Installing

```
git clone https://github.com/crabdul/Fairy-Lights-Java-Program.git
cd Fairy-Lights-Java-Program
mvn clean install 
```

### Running the Program
```
cd target
```

Number of lights specified after "-number"

```
java -jar fairylightsexercise-1.0.jar -number 15
```

Sequence options specified after "-sequence":
 - default parameter "linear" - lights turn on/off in a linear order
 - "even" - only even indexed lights turned on/off
 - "odd" - only odd indexed lights turned on/off
 
```
java -jar fairylightsexercise-1.0.jar -sequence even -number 12 
```

## Built With

* [Java](https://java.com/en/download/)
* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* **Karim El Khazaani** - [crabdul](https://github.com/crabdul)

## License

This project is licensed under the MIT License
