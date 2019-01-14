find -name *.java > sources.txt
javac -d compiled -sourcepath @sources.txt