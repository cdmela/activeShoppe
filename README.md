# Build
mvn clean package && docker build -t com.momentum/activeShoppe .

# RUN
docker rm -f activeShoppe || true && docker run -d -p 8080:8080 -p 4848:4848 --name activeShoppe com.momentum/activeShoppe 


############# REST DOCUMENTATION #############
Insomnia RESTful Client was used to test the APIs.
Insomnia does not come with the API Documentation generator. 
A Plugin was installed with Node JS.
Files were generated. Check zipped file(API_DOC.zip).
On Terminal, Node JS command <npx serve> was run to deploy the documentation,
Hosted at http://localhost:5000

NB: For convinience I have also generated an HTML(API_DOC.html) inside Zipped file API_DOC.zip

##############################################