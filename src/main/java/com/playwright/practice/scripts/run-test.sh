#!/bin/bash

# Resolve the directory of the current script
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Determine the relative path to pom.xml
# POM_PATH="$SCRIPT_DIR/../../pom.xml"
POM_PATH=$(echo "$SCRIPT_DIR" | awk -F'/' '{print "/" $2 "/" $3 "/" $4 "/" $5 "/" $6}')/pom.xml

# Debug output for verification
echo "Script Directory: $SCRIPT_DIR"
echo "Resolved POM Path: $POM_PATH"

# Check if the POM file exists
if [ ! -f "$POM_PATH" ]; then
    echo "Error: pom.xml not found at $POM_PATH"
    exit 1
fi

# Function to display the usage of the script
usage() {
    echo "Usage: $0 [test-type] [-h] [-b] [-t TestClass]"
    echo "test-type:"
    echo "  u   Run unit tests"
    echo "  i   Run integration tests"
    echo "  e   Run end-to-end (e2e) tests"
    echo "  a   Run API tests"
    echo "Options:"
    echo "  -h   Run in headless mode (default: false)"
    echo "  -b   Specify browser (f for Firefox, c for Chrome)"
    echo "  -t   Specify a specific test class"
    exit 1
}

# Default values
HEADLESS="-Dheadless=false"
BROWSER="-Dbrowser=firefox"
OPTIONS=""

# Ensure a test type is provided
if [ $# -lt 1 ]; then
    usage
fi

# Parse test type
TEST_TYPE=$1
shift

# Parse options (e.g., headless mode, browser type, specific test class)
while getopts ":h:b:t:" opt; do
    case $opt in
    h)
        if [ "$OPTARG" == "false" ]; then
            HEADLESS="-Dheadless=false"
        fi
        ;;
    b)
        if [ "$OPTARG" == "f" ]; then
            BROWSER="-Dbrowser=firefox"
        elif [ "$OPTARG" == "c" ]; then
            BROWSER="-Dbrowser=chrome"
        fi
        ;;
    t)
        OPTIONS="-Dtest=$OPTARG"
        ;;
    *)
        usage
        ;;
    esac
done

# Map test type to Maven profile
case $TEST_TYPE in
u)
    mvn -f "$POM_PATH" test -Punit-tests $HEADLESS $BROWSER $OPTIONS
    ;;
i)
    mvn -f "$POM_PATH" test -Pintegration-tests $HEADLESS $BROWSER $OPTIONS
    ;;
e)
    mvn -f "$POM_PATH" test -Pe2e-tests $HEADLESS $BROWSER $OPTIONS
    ;;
a)
    mvn -f "$POM_PATH" test -Papi-tests $HEADLESS $BROWSER $OPTIONS
    ;;
*)
    usage
    ;;
esac
