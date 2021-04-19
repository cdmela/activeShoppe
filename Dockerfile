FROM airhacks/glassfish
COPY ./target/activeShoppe.war ${DEPLOYMENT_DIR}
