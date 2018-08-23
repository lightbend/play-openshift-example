Lightbend Red Hat Certification
===============================

### what is this?

This is a sample app we are creating so Lightbend can become certified on OpenShift Platform.

I've taken Play Hello world app, applied Lightbend Orchestration, and sustituted the base image to "registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift" <https://github.com/jboss-dockerfiles/base-jdk>.

### status

Owner: Tooling team / Karl

### notes

```
eval $(minikube docker-env)
sbt Docker/publishLocal
docker tag 2387c0e7fbf4  scan.connect.redhat.com/ospid-27a7763d-9768-4cb2-8f40-48a656332443/play-hello-certification:0.9
docker push scan.connect.redhat.com/ospid-27a7763d-9768-4cb2-8f40-48a656332443/play-hello-certification:0.9
```
