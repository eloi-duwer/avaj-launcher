find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.avaj.simulator.Simulator scenario.txt