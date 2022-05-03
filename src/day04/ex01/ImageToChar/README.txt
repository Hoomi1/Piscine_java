rm -rf target

mkdir -p target

javac -d target src/java/edu/school21/printer/*/*.java

cp -R src/resources target

jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target edu -C src resources

java -jar target/images-to-chars-printer.jar 0 .