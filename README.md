# Java Template

## Project Structure

```
3_profiling/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/profiling/
│   │           └── Main.java
│   └── test/
│       └── java/
│           └── com/profiling/
│               └── MainTest.java
├── lib/                    # JUnit JAR for testing
├── out/
│   ├── main/              # Compiled main classes
│   └── test/              # Compiled test classes
├── recordings/            # JFR recordings output
├── Makefile
└── README.md
```

## Requirements

- **JDK 25** (OpenJDK 25.0.2 or compatible)
- **Make** (for running build commands)

## Setup

### 1. Verify JDK Installation

The Makefile expects JDK 25 to be available. It will use:
- `JAVA_HOME` environment variable if set
- Default location: `/opt/homebrew/opt/openjdk` (macOS Homebrew)

To verify your JDK version:
```bash
java --version
```

## Usage

### Compile the Project

```bash
make compile
```

Compiles all Java sources in `src/main/java/` to `out/main/`.

### Run the Application

```bash
make run
```

Compiles (if needed) and runs the main application.

### Compile Tests

```bash
make compile-test
```

Compiles test sources. Requires JUnit JAR in `lib/` directory.

### Run Tests

```bash
make test
```

Compiles and runs all JUnit tests.

### Profile with Java Flight Recorder

```bash
make profile
```

Runs the application with JFR profiling enabled. The recording will be saved to `recordings/` directory with a timestamp.

**JFR Configuration:**
- Duration: 60 seconds (configurable in Makefile)
- Settings: `profile` (higher overhead, more detailed profiling)
- Output: Timestamped `.jfr` files in `recordings/`

### Clean Build Artifacts

```bash
make clean
```

Removes all compiled classes and JFR recordings.

### Help

```bash
make help
```

Shows all available Makefile targets.
