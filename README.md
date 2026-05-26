# Actividad final programación orientada a objetos

## Compilar

```sh
mvn compile
```

Alternativa sin Maven:

```sh
find src/main/java -name "*.java" > sources.txt && javac @sources.txt -d target/classes
```

## Ejecutar

```sh
mvn compile exec:java -Dexec.mainClass="com.App"
```

Alternativa sin Maven:

```sh
java -cp target/classes com.App
```

