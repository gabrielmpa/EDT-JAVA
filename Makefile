all: compile jar 
	
compile:
	mkdir build
	javac Face.java -d ./build
	javac ./exceptions/InvalidPlyFile.java -d ./build
	javac Vertice.java -d ./build
	javac Ply.java -d ./build
	javac Main.java -d ./build

jar:
	echo "Main-Class: Main" > manifest
	jar cvfm Main.jar manifest -C ./build/ .
	echo "\n***usage-> make run ARG=filename.ply***\n"
run:
	java -jar Main.jar $(ARG) 

clean:
	rm -r build
	rm manifest
	rm Main.jar
	rm -rf *.*~
clean2:
	find -name "*.class" | xargs rm -rf
