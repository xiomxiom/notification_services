# Sample

## Prerequisites

Docker, Java 17.

## Building

```
./gradlew build
```

## Running

```
./gradlew bootRun
```

Go to http://localhost:8080 or http://localhost:8080/swagger-ui/.

## Deployment

1. Build the image:

```
source secrets.conf
# secrets.conf should contain:
# AWS_ECR_REGION=ap-southeast-1
# AWS_ECR_URI=...

docker run --rm -it \
  -v ~/.aws:/root/.aws \
  amazon/aws-cli \
  ecr get-login-password --region $AWS_ECR_REGION | \
  docker login --username AWS --password-stdin $AWS_ECR_URI

PROJECT_VERSION=$(./gradlew printProjectVersion -q | tee /dev/tty)

./gradlew bootBuildImage --imageName=$AWS_ECR_URI:$PROJECT_VERSION
```

2. Push the image:

```
docker push $AWS_ECR_URI:$PROJECT_VERSION
```
