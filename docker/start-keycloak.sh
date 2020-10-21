docker run \
    -d \
    --rm \
    --name keycloak \
    -p 8180:8080 \
    -v $(pwd)/tmp \
    -v ${PWD}/docker/keycloak-quarkus-realm.json:/tmp/firststeps-realm.json \
    -e KEYCLOAK_IMPORT=/tmp/firststeps-realm.json \
    -e KEYCLOAK_USER=admin \
    -e KEYCLOAK_PASSWORD=admin \
    jboss/keycloak:11.0.2

