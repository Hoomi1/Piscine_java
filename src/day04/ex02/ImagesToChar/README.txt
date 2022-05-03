rm -rf target
rm -rf lib

mkdir -p target
mkdir -p lib
curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
curl -o lib/JCDP-4.0.2.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar
jar -xvf lib/jcommander-1.82.jar
jar -xvf lib/JCDP-4.0.2.jar

cp -R src/resources target

mv com target
rm -rf META-INF

javac -classpath lib/jcommander-1.82.jar:lib/JCDP-4.0.2.jar src/edu/school21/printer/*/*.java -d target

jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN